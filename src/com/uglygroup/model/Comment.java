package com.uglygroup.model;

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
    public void allset(int cCommentId,int cShopId,int cUserId,
                       String cCommentBody,int cScore,Timestamp cTime){
        commentId=cCommentId;
        shopId=cShopId;
        userId=cUserId;
        commentBody=cCommentBody;
        score=cScore;
        time=cTime;
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
