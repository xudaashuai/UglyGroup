package com.uglygroup.Utils;

import com.uglygroup.model.Rank;
import com.uglygroup.model.Shop;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

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
    public static void removeRank(int rankId){
        String sql="delete from rank where Id='"+rankId+"';";
        DatabaseUtils.doSql(sql);
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
