package com.uglygroup.Utils;

import com.uglygroup.model.Message;
import com.uglygroup.model.User;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Think on 2017/6/16.
 */
public class MessageUtils {
    private static int inId;
    static {
        String sql="select max(Id) from \"message\"";
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
        // System.out.println(inId);
    }

    public static void addMessage(int src, int dst,int type){
        inId++;
        Date date=new Date();
        Timestamp time =new Timestamp(date.getTime());
        String content="";
        int status=0;
        if(type==1) {
             content = UserDataUtils.selectUserInfor(src).getNickName() + "想加你好友呦！";
        }
        else if(type==2){
            content="你们已经是好友啦啦啦！";
            UserDataUtils.addFriend(src,dst);
            UserDataUtils.addFriend(dst,src);
        }
        else if(type==3) {
            content="对方残忍无情的拒绝了你";
        }
        else if(type==4){
            content=UserDataUtils.selectUserInfor(src).getNickName()+"关注了你!!";
        }
        else if(type==5){
            content=UserDataUtils.selectUserInfor(src).getNickName()+"成为了你的粉丝!!";
        }

        String sql="insert into message values('"+String.valueOf(inId)+"','"+String.valueOf(type)+"','"+String.valueOf(src)+"','"+String.valueOf(dst)+"','"+content+"','"+String.valueOf(status)+"','"+time.toString()+"');";
        DatabaseUtils.doSql(sql);
        User u=UserDataUtils.selectUserInfor(dst);
        u.addMessage(String.valueOf(inId));

    }
    public int unreadNumber(int userId){
        int count=0;
        String sql="select count(1) from message where dst='"+String.valueOf(userId)+"'and status='0';";
        try{
            ResultSet rs;
            rs=DatabaseUtils.getResult(sql);
            count=rs.getInt(1);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;

    }
    public static Message selectMessage(int id){
        Message m = new Message();
        String sql = "select * from message where id='" + id + "';";
        try {
            ResultSet rs;
            rs = DatabaseUtils.getResult(sql);
            while (rs.next()) {

                int mid = rs.getInt(1);
                int type = rs.getInt(2);
                int src = rs.getInt(3);
                int dst = rs.getInt(4);
                String body = rs.getString(5);
                int status = rs.getInt(6);
                Timestamp time = rs.getTimestamp(7);
                m.allSet(id, type, src, dst, body, status, time);
               // messages.add(m);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m;
    }


}
