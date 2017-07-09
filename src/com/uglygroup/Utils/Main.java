package com.uglygroup.Utils;

import com.uglygroup.model.Shop;
import com.uglygroup.model.User;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Think on 2017/6/10.
 */
public class Main {
    public static String[] firstU={
            "宇宙","世界","天下","地表","中国","全亚洲","中国高校"
    };
    public static String[]  lastU={
            "第一","第二","第三","最强","无敌","一级棒","顶级","公认"
    };
    public static String[] firstName={
            "好吃的","美味的","吸引人的","受欢迎的"
    };
    public static String[]  lastName={
            "店家榜单","吃货福地榜单","美食天堂榜单","大饱口福之地榜单"
    };

    public static String getRandomStr(){
        String name="";
        Random random = new Random();
        int number=random.nextInt(7);
        int number2=random.nextInt(8);
        int number3=random.nextInt(4);
        int number4=random.nextInt(4);
        name=firstU[number]+lastU[number2]+firstName[number3]+lastName[number4];
        return name;

    }
    public static void main(String []args) {
        for (int j = 0; j < 20;j++) {
            String[] rank = new String[10];
            ArrayList<Shop> shops = ShopDataUtils.getAllShop(-1);
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                rank[i] = String.valueOf(shops.get(random.nextInt(shops.size())).getId());

            }
            Random random2=new Random();

            String pic=Utils.rankPicture[random2.nextInt(9)];
            RankUtils.addRank(getRandomStr(), 2, "介绍个屁！直接看内容。", rank, "");
        }
    }
}
