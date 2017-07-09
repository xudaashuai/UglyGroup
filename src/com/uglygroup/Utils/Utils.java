package com.uglygroup.Utils;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Think on 2017/6/3.
 */
public class Utils {
    public static int getInid(String sql){
        int inId=0;
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
        return inId;
    }
    public static enum loginStatus{
        PASSWORDERROR,
        LOGINNAMENOEXIST,
        SUCCESS;
    }
    public static enum registerStatus{
        LOGINNAMEEXIST,
        SUCCESS;
    }
    public static  enum  addStatus{
        ADDSUCCESS,
        FAILED,
        ITEMEXIST
    }
    public static  enum deleteStatus{
        DELETESUCCES,
        ITEMNOEXIST,
        FAILED
    }

    public static int[] getRandom(int n){
        Random random = new Random();
        int[] a=new int [n];
        int[]b=new int[n];
        System.out.println();
        for (int i=0;i<n;i++){
            a[i]=i+1;
        }
        int i=0;
        while (i<n){
            int number=random.nextInt(n);
            if(a[number]!=0){
                b[i]=a[number];
                a[number]=0;
                i++;

            }
        }
        return b;
    }
    public static String[] rheadPicture={"https://ooo.0o0.ooo/2017/06/14/59412b1e54cab.jpg",
           "https://ooo.0o0.ooo/2017/06/14/59412b1e54cb2.jpg",
            "https://ooo.0o0.ooo/2017/06/14/59412b1e3bafe.jpg",
            "https://ooo.0o0.ooo/2017/06/14/59412b1e706c1.jpg",
            "https://ooo.0o0.ooo/2017/06/14/59412b1e3bb57.jpg",
            "https://ooo.0o0.ooo/2017/06/14/59412b1e3c1a1.jpg",
            "https://ooo.0o0.ooo/2017/06/14/59412ba7a7ae4.jpg"
    };
    public  static String[] rankPicture={
        "http://i1.buimg.com/597927/8cbbaa74583c62ac.jpg",
           " http://i1.buimg.com/597927/e0db56c8644d08c6.jpg",
    "http://i1.buimg.com/597927/2c005e044218138b.jpg",
    "http://i1.buimg.com/597927/45fa036e98b23a56.jpg",
    "http://i1.buimg.com/597927/c1acb344c58acf0b.jpg",
    "http://i1.buimg.com/597927/408494c93bfe328a.jpg",
    "http://i1.buimg.com/597927/a6048c0080b295b9.jpg",
    "http://i1.buimg.com/597927/2ac26e6d63f9ab88.jpg",
    "http://i1.buimg.com/597927/37e7b3f116979a96.jpg"
    };

}
