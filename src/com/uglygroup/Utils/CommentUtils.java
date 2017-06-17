package com.uglygroup.Utils;
import com.uglygroup.model.Comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 * Created by Think on 2017/6/10.
 */
public class CommentUtils {
    private static int inId;
    static {
        String sql="select max(commentId) from \"comment\"";
        Utils.getInid(sql);
    }
    public static void addComment(String commentBody,int shopId,int userId,int score){
        inId++;
        Date date=new Date();
        Timestamp time =new Timestamp(date.getTime());
        String sql = "insert into comment values("+"'"
                +String.valueOf(inId)+"','"
                +String.valueOf(shopId)+"','"
                +String.valueOf(userId)+ "','"
                +commentBody+"','"+String.valueOf(score)+"','"+time.toString()+ "')" + "on conflict do nothing;";
        DatabaseUtils.doSql(sql);
    }
    public static void removeComment(int commentId){
        String sql="delete from comment where commentId='"+commentId+"';";
        DatabaseUtils.doSql(sql);
    }
    public static Comment selectComment(int commentId){
        Comment c=new Comment();
        String sql="select * from comment where commentId='"+commentId+"';";
                try {
                    ResultSet rs;
                    rs=DatabaseUtils.getResult(sql);
                    if(rs.next()){
                        c.allset(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getTimestamp(6),rs.getString(7));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
       return c;

    }

    public static ArrayList<Comment> selectUserComment(int userId){
        String sql="select commentId from comment where userId='"+String.valueOf(userId)+"';";
        ArrayList<Integer>commentId=new ArrayList<Integer>();
        ArrayList<Comment>comments=new ArrayList<Comment>();
        int id;
        try{
            ResultSet rs=DatabaseUtils.getResult(sql);
            while (rs.next()){
                id=rs.getInt(1);
                commentId.add(id);
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<commentId.size();i++){
            comments.add(CommentUtils.selectComment(commentId.get(i)));
        }
        return comments;
    }

}
