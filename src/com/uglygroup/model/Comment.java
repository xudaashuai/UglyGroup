package com.uglygroup.model;

import com.uglygroup.Utils.UserDataUtils;

import java.sql.Timestamp;

/**
 * Created by Think on 2017/6/10.
 */
public class Comment {
    private int commentId;
    private int shopId;
    private int userId;
    private String commentBody;
    private int score;
    private Timestamp time;
    private String[] pic;
    public void allset(int cCommentId,int cShopId,int cUserId,
                       String cCommentBody,int cScore,Timestamp cTime,String cPic){
        commentId=cCommentId;
        shopId=cShopId;
        userId=cUserId;
        commentBody=cCommentBody;
        score=cScore;
        time=cTime;
    }
    public User selectUser(int userId){
        User u;
        u= UserDataUtils.selectUserInfor(userId);
        return u;
    }
    public int getCommentId(){
        return commentId;
    }
    public int getShopId(){
        return shopId;
    }
    public int getUserId(){
        return getUserId();
    }
    public String getCommentBody(){
        return commentBody;
    }
    public int getScore(){
        return score;
    }
    public Timestamp getTime(){
        return time;
    }
}
