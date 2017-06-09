package com.uglygroup.Utils;


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
    public static  enum  addFriend{
        ADDSUCCESS,
        NOUSERID,
        NOFRIENDID
    }
}
