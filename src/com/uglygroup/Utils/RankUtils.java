package com.uglygroup.Utils;

import com.uglygroup.model.Rank;
import com.uglygroup.model.Shop;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by Think on 2017/7/8.
 */
public class RankUtils {
    private static int inId;
    static {
        String sql="select max(id) from \"rank\"";
        inId=Utils.getInid(sql);
    }
    public static void addRank(String name,int creatorId,String introduction,String[] shopList,String pic){
        inId++;
        if(pic.equals("")){
            Random random2=new Random();
            pic=Utils.rankPicture[random2.nextInt(9)];
        }
        Date date=new Date();
        Timestamp time =new Timestamp(date.getTime());
        String str="";
        if(shopList.length>0) {
            for (int i = 0; i < shopList.length; i++) {
                str +=shopList[i];
                if (i != shopList.length - 1) {
                    str += ",";
                }
            }
            String sql = "insert into rank values(" + "'"
                    + String.valueOf(inId) + "','"
                    + name + "','"
                    + String.valueOf(creatorId) + "','"
                    + time.toString()
                    + "','" + introduction + "','" +str+"','"+pic+ "')" + "on conflict do nothing;";
            DatabaseUtils.doSql(sql);
        }
        Rank r=selectRank(inId);
        String[] sId;
        sId=r.getShopList();
        for(int i=0;i<sId.length;i++){
            Shop s=ShopDataUtils.selectShop(Integer.parseInt(sId[i]));
            s.addRank(String.valueOf(inId));
        }
    }
    public static ArrayList<Rank> getAllRank(int page) {
        ArrayList<Integer> RankId = new ArrayList<Integer>();
        ResultSet myRs;
        String sql="";
        if(page==-1){
            sql= "select \"id\" from rank";
        }
        else {
            sql = "select \"id\" from rank limit 10 offset " + String.valueOf(page * 10) + ";";
        }
        try {
            myRs = DatabaseUtils.getResult(sql);
            while (myRs.next()) {
                int id = myRs.getInt(1);
                RankId.add(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < RankId.size(); i++) {
            ranks.add(selectRank(RankId.get(i)));
        }
        return ranks;
    }

    public static void removeRank(int rankId){
        String sql="delete from rank where Id='"+rankId+"';";
        DatabaseUtils.doSql(sql);
    }
    public static  ArrayList<Rank>  getRandomRank(){
        ArrayList<Rank> res = new ArrayList<>();
        int[] r;
        ArrayList<Rank> ranks = getAllRank(-1);
        int x = ranks.size();
        r = Utils.getRandom(x);
        for (int i = 0; i < 3; i++) {
            Rank rank = ranks.get(r[i] - 1);
            res.add(rank);
        }

        return res;
    }
    public static Rank selectRank(int rankId){
        Rank c=new Rank();
        String sql="select * from rank where Id='"+rankId+"';";
        ResultSet rs;

        try {
            rs=DatabaseUtils.getResult(sql);
            if(rs.next()){

                c.allSet(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getTimestamp(4),
                        rs.getString(5),
                        rs.getString(6).split(","),
                        rs.getString(7)
                        );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;

    }

}
