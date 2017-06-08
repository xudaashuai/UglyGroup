package com.uglygroup.moudle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/6.
 */
public class ShopsDataUtils {
    private static int inId;
//git test PPPPP
    //用户登录、注册和更改信息操作
    static {
        inId = 0;
    }


    //添加一家商家
    public static void addShop(String sLocal,String sInrank, String sSubtype, String sTel, String sStar, String sAvgprice, String sTastep, String sEnviornmentp, String sServicep, String sMaintype, String sAddress, String sName, String sSignId) {
        inId++;

        String shopId = String.valueOf(inId);
        String sql = "insert into shop values(" +
                "'" + shopId + "','" + sLocal + "','" + sInrank + "','" + sSubtype + "','" + sTel + "','" + sStar + "','"
                + sAvgprice + "','" + sTastep + "','" + sEnviornmentp +
                "','" + sServicep + "','" + sMaintype + "','" + sAddress + "','" + sName + "','" + sSignId + "')" + "on conflict do nothing;";
        String sql2 = "select * from shop where \"signId\"='" + sSignId + "'";
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
    public static Shops selectShop(String shopId){
        Shops shop=new Shops();
        String sql = "select * from shop where \"Id\"='" + shopId + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql);

            if (rs.next()) {

                shop.allSet(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10),
                        rs.getString(11),rs.getString(12),
                        rs.getString(13),rs.getString(14));

            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }
    //获取在列表中的所有商家的对象数组
    public static ArrayList<Shops> getAllShops(){
        ArrayList<String> shopsId=new ArrayList<String>();
        String sql="select \"Id\" from shop;";
        try {
            ResultSet myrs=DatabaseUtils.getResult(sql);
            while (myrs.next()){
                String id=myrs.getString(1);
                shopsId.add(id);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Shops> shops=new ArrayList<Shops>();
        for(int i=0;i<shopsId.size();i++){
            shops.add(selectShop(shopsId.get(i)));
        }
        return shops;
    }
    //获取相关商家
    public static ArrayList<Shops> getAboutShop(String keyWrod){
        ArrayList<Shops> shops=new ArrayList<Shops>();
        ArrayList<String> shopsId=new ArrayList<String>();
        String sql="select \"Id\" from shop where shopname like '%"+keyWrod+"%';";
        try {
            ResultSet rs;
            rs=DatabaseUtils.getResult(sql);
            while (rs.next()){
                shopsId.add(rs.getString(1));
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<shopsId.size();i++){
            shops.add(selectShop(shopsId.get(i)));
        }
        return shops;
    }
    //变更商家信息处理
    public static void shopChangeInfor(String content,String shopId,String changeWhat){
            String sql="update shop set "+changeWhat+"='"+content+"'where \"signId\"='"+shopId+"'";
            DatabaseUtils.doSql(sql);
    }

    //添加操作
    public static  void addShopInRank(String shopId,String newRank){
        Shops shop;
        shop=selectShop(shopId);
        shop.addRank(newRank);
    }
    public static void addShopSubtype(String shopId,String newSubtype){
        Shops shop;
        shop=selectShop(shopId);
        shop.addSubtype(newSubtype);
    }
    public static  void addShopMaintype(String shopId,String newMaintpe){
        Shops shop;
        shop=selectShop(shopId);
        shop.addMaintype(newMaintpe);
    }

    //删除操作
    public  static void deleteShopInRank(String shopId,String oldRank){
        Shops shop;
        shop=selectShop(shopId);
        shop.deleteRank(oldRank);
    }
    public  static void deleteShopSubtype(String shopId,String oldSubtype){
        Shops shop;
        shop=selectShop(shopId);
        shop.deleteSubtype(oldSubtype);
    }
    public  static void deleteShopMaintype(String shopId,String oldMaintype){
        Shops shop;
        shop=selectShop(shopId);
        shop.deleteMaintype(oldMaintype);
    }
}


