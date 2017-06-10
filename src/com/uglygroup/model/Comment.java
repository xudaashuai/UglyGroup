package com.uglygroup.model;

/**
 * Created by Think on 2017/6/10.
 */
public class Comment {
    private int commentId;
    private int shopId;
    private int userId;
    private String commentBody;
    private int score;
    private String time;
    public void allset(int cCommentId,int cShopId,int cUserId,
                       String cCommentBody,int cScore,String cTime){
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
    public String getTime(){
        return time;
    }
}
