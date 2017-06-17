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
    //获取商家信息
    public static com.uglygroup.model.Shop selectShop(int shopId){
        com.uglygroup.model.Shop shop=new com.uglygroup.model.Shop();
        String sql = "select * from \"shop\" where id='" + String.valueOf(shopId) + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql);

            if (rs.next()) {


                shop.allSet(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getString(8).split(","),
                        rs.getString(9), rs.getString(10),
                        rs.getString(11),rs.getInt(12),
                        rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(17).split(","));

            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }
    //获取在列表中的所有商家的对象数组
    public static ArrayList<com.uglygroup.model.Shop> getAllShop(int page){
        ArrayList<Integer> ShopId=new ArrayList<Integer>();
        String sql="select \"id\" from shop limit 10 offset "+String.valueOf(page*10)+";";
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
    public static ArrayList<com.uglygroup.model.Shop> searchShop(String keyword,int page){
        ArrayList<com.uglygroup.model.Shop> Shop=new ArrayList<com.uglygroup.model.Shop>();
        ArrayList<Integer> ShopId=new ArrayList<Integer>();
        String sql="select \"id\" from shop where name like '%"+keyword+"%' limit 10 offset "+String.valueOf(page*10);
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
    //TODO
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
        int[] r;
        int x=getAllShop(1).size();
        r=Utils.getRandom(x);
                for (int i=0;i<10;i++){
                    Shop shop=selectShop(r[i]);
                    shops.add(shop);
                }

        return shops;
    }

}


