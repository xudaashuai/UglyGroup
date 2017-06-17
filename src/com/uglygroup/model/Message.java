package com.uglygroup.model;

import com.uglygroup.Utils.DatabaseUtils;
import com.uglygroup.Utils.UserDataUtils;

import java.sql.Timestamp;

/**
 * Created by Think on 2017/6/16.
 */
public class Message {
    private int id;
    private int type;
    private int src;
    private int dst;
    private String content;
    private int status;
    private Timestamp time ;

    public void allSet(int mId,int mType,int mSrc,int mDst,String mContent,int mStatus,Timestamp mTime){
        id=mId;
        type=mType;
        src=mSrc;
        dst=mDst;
        content=mContent;
        status=mStatus;
        time=mTime;
    }
    public void setStatus(int status){
        this.status=status;
        String sql="update message set status='"+status+"' where id='"+id+"';";
        DatabaseUtils.doSql(sql);
    }
    public int getType(){
        return type;
    }
    public int getStatus(){
        return status;
    }
    public String getContent(){
        return content;
    }
    public User getUser(){
        User u=new User();
        u=UserDataUtils.selectUserInfor(src);
        return u;
    }
    public int getId(){
        return id;
    }
}
