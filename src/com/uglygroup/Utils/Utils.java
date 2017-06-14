package com.uglygroup.Utils;


import java.util.Random;

/**
 * Created by Think on 2017/6/3.
 */
public class Utils {
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

}
