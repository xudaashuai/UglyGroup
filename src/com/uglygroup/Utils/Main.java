package com.uglygroup.Utils;

import com.uglygroup.model.User;

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

    }
}
