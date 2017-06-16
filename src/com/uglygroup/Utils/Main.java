package com.uglygroup.Utils;

import com.uglygroup.model.User;
import com.uglygroup.model.Shop;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Think on 2017/6/10.
 */
public class Main {
    public static String[] firstU={
            "a","b","c","d","e","f","g","h","i","j","k"
    };
    public static String[]  lastU={
            "1","2","3","4","5","6","7","8"
    };
    public static String[] firstName={
            "陈","徐","王","李","贾","姚","童","程","蒋","沈","黄"
    };
    public static String[]  lastName={
            "努","迎","港","树","梁","彩","娟","白"
    };

    public static String getRandomStr(){
        String name="";
        Random random = new Random();
        int number=random.nextInt(10);

        int j=Utils.getRandom(6)[0];
        System.out.println(number);
        name=firstU[number];
        for(int i=0;i<j;i++){
            int number2=random.nextInt(7);
            name+=lastU[number2];
        }
        return name;

    }
    public static String getRandomNickname(){
        String name="";
        Random random = new Random();
        int number=random.nextInt(10);

        int j=Utils.getRandom(3)[0];
        System.out.println(number);
        name=firstName[number];
        for(int i=0;i<j;i++){
            int number2=random.nextInt(7);
            name+=lastName[number2];
        }
        return name;

    }
    public static void main(String []args){
       // for(int i=0;i<100;i++)
        //UserDataUtils.register(getRandomStr(),getRandomStr(),getRandomNickname());
       // UserDataUtils.register("456","321","男","19","Fate灬潇雨南","19970808","李树梁");
        //UserDataUtils.register("12322","321");
        //User u=new User();
      //  System.out.println(UserDataUtils.login("123","321",u));
        //UserDataUtils.searchUser("魔菌");
       // ArrayList<Shop> shops=new ArrayList<>();
        //shops=ShopDataUtils.getRandomShop();
        //for(int i=0;i<shops.size();i++){
          //  System.out.println(shops.get(i).getShopname());
       // }
        //UserDataUtils.addFriend(1,2);
       MessageUtils.addMessage(2,1,3);
      // System.out.println(Utils.setStatus.ILLEAGEL.toString());
       //
        /*
       u=UserDataUtils.selectUserInfor(1);
       u.addHate("爱食");
       u.addFavorite("黄焖鸡");
       u.setAge(18);
       u.setBirthday("19970701");
       u.setHeadPicture("no picture");
       u.setNickName("陈魔菌");
       u.setPassword("7033715");
       u.setSex("男");
       u.setSign("穿梭。");
       System.out.println(u.getAge());
        System.out.println(u.getBirthday());
        */
        //UserDataUtils.



        //
        /*
        ShopDataUtils.addShop("132,123","全国百佳食堂","食堂","0819222",10,6,6,6,6,"食堂","中国地质大学52栋旁边","学三食堂","1");
        Shop s;


        s=ShopDataUtils.selectShop(1);
        System.out.println(s.getAddress());
        s.setTel("05927033715");
        s.setAvgPrice(6.5);
        */
       // CommentUtils.addComment("学三真的太好吃了",1,1,10);
        //CommentUtils.removeComment(1);
    }
}
