package com.uglygroup.Utils;
import java.util.HashSet;
import java.util.Random;

import com.uglygroup.model.Shop;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/6.
 */
public class ShopDataUtils {
    private static int inId;
//git test PPPPP
    //用户登录、注册和更改信息操作
    static {
    String sql="select max(shopTrueId) from \"shop\"";
    ResultSet rs=DatabaseUtils.getResult(sql);
    try {
        if (rs.next()) {
            inId=rs.getInt(1);
        }
        else {
            inId = 0;
        }
    }catch (Exception e) {
        throw new RuntimeException(e);
    }
    // System.out.println(inId);
    }


    //添加一家商家
    public static void addShop(String sLocal,String sInrank, String sSubType, String sTel, int sStar, int sAvgprice, int sTastep, int sEnviornmentp, int sServicep, String sMainType, String sAddress, String sName, String sSignId) {
        inId++;

        String shopId = String.valueOf(inId);
        String sql = "insert into shop values(" +
                "'" +sLocal + "','" + sInrank + "','" + sSubType + "','" + sTel + "','" + String.valueOf(sStar) + "','"
                + String.valueOf(sAvgprice) + "','" + String.valueOf(sTastep) + "','" + String.valueOf(sEnviornmentp) +
                "','" + String.valueOf(sServicep) + "','" + sMainType + "','" + sAddress + "','" + sName + "','" + sSignId +"','"+ shopId+"')" + "on conflict do nothing;";
        String sql2 = "select * from \"shop\" where signId='" + sSignId + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql2);
            if (rs.next()) {
                  return;
            } else {
                try {
                    DatabaseUtils.doSql(sql);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   //信息查询

    //获取商家信息
    public static com.uglygroup.model.Shop selectShop(int shopId){
        com.uglygroup.model.Shop shop=new com.uglygroup.model.Shop();
        String sql = "select * from \"shop\" where shopTrueId='" + String.valueOf(shopId) + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql);

            if (rs.next()) {

                shop.allSet(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10),
                        rs.getString(11),rs.getString(12),
                        rs.getInt(13));

            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }
    //获取在列表中的所有商家的对象数组
    public static ArrayList<com.uglygroup.model.Shop> getAllShop(){
        ArrayList<Integer> ShopId=new ArrayList<Integer>();
        String sql="select \"shopTrueId\" from shop;";
        try {
            ResultSet myrs=DatabaseUtils.getResult(sql);
            while (myrs.next()){
                int id=myrs.getInt(1);
                ShopId.add(id);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<com.uglygroup.model.Shop> Shop=new ArrayList<com.uglygroup.model.Shop>();
        for(int i=0;i<ShopId.size();i++){
            Shop.add(selectShop(ShopId.get(i)));
        }
        return Shop;
    }
    //获取相关商家
    public static ArrayList<com.uglygroup.model.Shop> getAboutShop(String keyWrod){
        ArrayList<com.uglygroup.model.Shop> Shop=new ArrayList<com.uglygroup.model.Shop>();
        ArrayList<Integer> ShopId=new ArrayList<Integer>();
        String sql="select \"shopTrueId\" from shop where shopname like '%"+keyWrod+"%';";
        try {
            ResultSet rs;
            rs=DatabaseUtils.getResult(sql);
            while (rs.next()){
                ShopId.add(rs.getInt(1));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<ShopId.size();i++){
            Shop.add(selectShop(ShopId.get(i)));
        }
        return Shop;
    }
    //变更商家信息处理
    public static void shopChangeInfor(String content,int shopId,String changeWhat){
            String sql="update \"shop\" set "+changeWhat+"='"+content+"'where shopTrueId='"+String.valueOf(shopId)+"'";
            DatabaseUtils.doSql(sql);
    }

    //添加操作
    public static  void addShopInRank(int shopId,String newRank){
        com.uglygroup.model.Shop shop;
        shop=selectShop(shopId);
        shop.addRank(newRank);
    }

    //删除操作
    public  static void deleteShopInRank(int shopId,String oldRank){
        com.uglygroup.model.Shop shop;
        shop=selectShop(shopId);
        shop.deleteRank(oldRank);
    }

    //推荐
    public static ArrayList<Shop> getRandomShop(){
        ArrayList<Shop> shops=new ArrayList<>();
        int[] r=new int [2];
        r=Utils.getRandom(3);
                for (int i=0;i<2;i++){
                    System.out.println(r[i]);
                    Shop shop=selectShop(r[i]);
                    shops.add(shop);
                }

        return shops;
    }

}


