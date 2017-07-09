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
    public static com.uglygroup.model.Shop selectShop(int shopId) {
        com.uglygroup.model.Shop shop = new com.uglygroup.model.Shop();
        String sql = "select * from \"shop\" where id='" + String.valueOf(shopId) + "'";

        try {
            ResultSet rs = DatabaseUtils.getResult(sql);
            String str1,str2,str3;
            String[]a={},b={},c={};
            ArrayList<String>inRank=new ArrayList<>();
            if (rs.next()) {
                str1=rs.getString(8);
                str3=rs.getString(12);
                str2=rs.getString(16);
                if(str1!=null){
                    a=str1.split(",");
                }
                if(str2!=null){
                    b=str2.split(",");
                }
                if(str3!=null){

                    c=str3.split(",");

                }
                for(int i=0;i<c.length;i++){
                    inRank.add(c[i]);
                }


                shop.allSet(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6),
                        rs.getString(7), a,
                        rs.getString(9), rs.getString(10),
                        rs.getString(11),inRank,
                        rs.getString(13), rs.getString(14), rs.getString(15), b);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }

    //获取在列表中的所有商家的对象数组
    public static ArrayList<com.uglygroup.model.Shop> getAllShop(int page) {
        ArrayList<Integer> ShopId = new ArrayList<Integer>();
        String sql="";
        if(page==-1){
             sql= "select \"id\" from shop";
        }
        else {
             sql = "select \"id\" from shop limit 10 offset " + String.valueOf(page * 10) + ";";
        }
        try {
            ResultSet myrs = DatabaseUtils.getResult(sql);
            while (myrs.next()) {
                int id = myrs.getInt(1);
                ShopId.add(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<com.uglygroup.model.Shop> Shop = new ArrayList<com.uglygroup.model.Shop>();
        for (int i = 0; i < ShopId.size(); i++) {
            Shop.add(selectShop(ShopId.get(i)));
        }
        return Shop;
    }

    //获取相关商家
    public static ArrayList<com.uglygroup.model.Shop> searchShop(String keyword, int page) {
        ArrayList<com.uglygroup.model.Shop> Shop = new ArrayList<com.uglygroup.model.Shop>();
        ArrayList<Integer> ShopId = new ArrayList<Integer>();
        ResultSet rs;
        String sql = "select \"id\" from shop where name like '%" + keyword + "%' limit 10 offset " + String.valueOf(page * 10);
        try {

            rs = DatabaseUtils.getResult(sql);
            while (rs.next()) {
                ShopId.add(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < ShopId.size(); i++) {
            Shop.add(selectShop(ShopId.get(i)));
        }
        return Shop;
    }
    //变更商家信息处理


    public static void shopChangeInfor(String content, int shopId, String changeWhat) {
        String sql = "update \"shop\" set " + changeWhat + "='" + content + "'where shopTrueId='" + String.valueOf(shopId) + "'";
        DatabaseUtils.doSql(sql);
    }

    //推荐
    public static ArrayList<Shop> getRandomShop() {
        ArrayList<Shop> shops = new ArrayList<>();
        int[] r;
        ArrayList<Shop> s = getAllShop(-1);
        int x = s.size();
        r = Utils.getRandom(x);
        for (int i = 0; i < 10; i++) {
            Shop shop = s.get(r[i] - 1);
            shops.add(shop);
        }

        return shops;
    }

}


