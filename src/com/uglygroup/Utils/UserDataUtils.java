package com.uglygroup.Utils;

import com.uglygroup.Utils.Utils;

import java.util.ArrayList;

/**
 * Created by Think on 2017/6/6.
 */
import java.sql.ResultSet;

public class UserDataUtils {
    //git test QQQQQ
    private static int inId;
    //用户登录、注册和更改信息操作
    static {
        inId=0;
    }
    //登陆处理
    public static Utils.loginStatus login(String userName, String userPassword, com.uglygroup.model.User u) {
        String sql = "select password from \"users\" where userName='" + userName + "'";
        try {
            //statement = connection.createStatement();
            ResultSet resultSet = DatabaseUtils.getResult(sql);
            int count = 0;
            while (resultSet.next()) {
                String cPassword = resultSet.getString(1);
                if (cPassword.equals(userPassword)) {
                    try {
                        String sql2="select * from \"users\" where userName='"+userName+"'";
                        ResultSet rs = DatabaseUtils.getResult(sql2);
                        if(rs.next()) {
                            u.allSet(rs.getString(1), rs.getInt(2),
                                    rs.getString(3), rs.getString(4),
                                    rs.getString(5), rs.getString(6),
                                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));
                        }
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return Utils.loginStatus.SUCCESS;
                }
                else{
                    count++;
                }
            }
            if (count == 0) {
                return Utils.loginStatus.LOGINNAMENOEXIST;
            }
            else{
                return Utils.loginStatus.PASSWORDERROR;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //注册处理
    public static Utils.registerStatus register(String userName, String userPassword) {
        inId++;
        String birthDay="";
        String sex="";
        String age="0";
        String nickName="";
        String favorite ="";
        String hate = "";
        String headPicture="";
        String friendList="";
        String follow="";
        String fans="";
        String sign="这个人很懒，什么都没写。";
        String sql = "insert into users values(" +
                "'" + sex + "','" + age + "','" + birthDay + "','" + favorite + "','" + hate  + "','"
                + userPassword + "','" + userName +
                "','" + nickName+"','"+friendList+ "','"+follow+"','"+fans+"','"+sign+"','"+String.valueOf(inId)+"','"+headPicture+ "')" + "on conflict do nothing;";
        String sql2="SELECT * FROM \"users\" WHERE userName='"+userName+"';";
        try {
            ResultSet rs= DatabaseUtils.getResult(sql2);
            if (rs.next()){
                return Utils.registerStatus.LOGINNAMEEXIST;
            }
            else {
                try {
                    DatabaseUtils.doSql(sql);
                    return Utils.registerStatus.SUCCESS;

                    //  ResultSet resultSet = statement.executeQuery(sql);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //更改信息处理

    public static void userChangeInfor(String content,int userId,String changeWhat){
            String sql="update users set "+changeWhat+"='"+content+"'where trueId='"+String.valueOf(userId)+"'";
            DatabaseUtils.doSql(sql);

    }
    // 查询用户信息
    public static com.uglygroup.model.User selectUserInfor(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        String sql = "select * from users where trueId='" + userId + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql);
            if (rs.next()) {
                u.allSet(rs.getString(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14));;

            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }


    //查询操作

    //获取好友列表
    public static ArrayList<com.uglygroup.model.User> selectUserFriend(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        ArrayList<com.uglygroup.model.User> friLis=new ArrayList<com.uglygroup.model.User>();
        u=selectUserInfor(userId);
        int friendId;
        for(int i=0;i<u.getFriendList().size();i++){
            friendId=u.getFriendList().get(i);
            friLis.add(selectUserInfor(friendId));
        }
        return friLis;

    }
    //获取用户特别关心
    public static ArrayList<com.uglygroup.model.User> selectUserfollow(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        ArrayList<com.uglygroup.model.User> followLis=new ArrayList<com.uglygroup.model.User>();
        u=selectUserInfor(userId);
        int friendId;
        for(int i=0;i<u.getFollow().size();i++){
            friendId=u.getFollow().get(i);
            followLis.add(selectUserInfor(friendId));
        }
        return followLis;

    }
    //获取用户粉丝
    public static ArrayList<com.uglygroup.model.User> selectUserFans(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        ArrayList<com.uglygroup.model.User> fansLis=new ArrayList<com.uglygroup.model.User>();
        u=selectUserInfor(userId);
        int friendId;
        for(int i=0;i<u.getFans().size();i++){
            friendId=u.getFans().get(i);
            fansLis.add(selectUserInfor(friendId));
        }
        return fansLis;
    }
    //获取用户喜欢吃的列表
    public static ArrayList<String> selectUserFavorite(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        ArrayList<String> favLis=new ArrayList<String>();
        u=selectUserInfor(userId);
        for(int i=0;i<u.getFavorite().size();i++){
            favLis.add(u.getFavorite().get(i));
        }
        return favLis;
    }
     //获取用户讨厌吃的列表
    public static ArrayList<String> selectUserHate(int userId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        ArrayList<String> hateLis=new ArrayList<String>();
        u=selectUserInfor(userId);
        for(int i=0;i<u.getHate().size();i++){
            hateLis.add(u.getHate().get(i));
        }
        return hateLis;
    }
    //获取所有注册用户的对象数组
    public static ArrayList<com.uglygroup.model.User> getAllUser(){
        ArrayList<Integer> allUserId=new ArrayList<Integer>();
        ArrayList<com.uglygroup.model.User> allUser=new ArrayList<com.uglygroup.model.User>();
        String sql="select trueId from users";

   try{
       ResultSet rs = DatabaseUtils.getResult(sql);
       while(rs.next()){
           allUserId.add(rs.getInt(1));

       }

    }catch (Exception e) {
        throw new RuntimeException(e);
    }
    for(int i=0;i<allUserId.size();i++){
        allUser.add(selectUserInfor(allUserId.get(i)));
    }
    return allUser;
    }

    //添加操作

    //添加好友
    public static  void addFriend(int userId,int friendId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.addFriend(friendId);

    }
    //添加关心
    public static  void addFollow(int userId,int followId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.addFollow(followId);

    }
    //添加粉丝
    public static  void addFans(int userId,int fansId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.addFans(fansId);

    }
    //添加喜欢吃
    public static  void addFavorite(int userId,String favorite){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.addFavorite(favorite);

    }
    //添加讨厌吃
    public static  void addHate(int userId,String hate){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.addHate(hate);

    }


    //删除操作

    //删除好友
    public static  void deleteFriend(int userId,int friendId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.deleteFriend(friendId);

    }
    //删除关心
    public static  void deleteFollow(int userId,int followId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.deleteFollow(followId);

    }
    //删除粉丝
    public static  void deleteFans(int userId,int fansId){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.deleteFans(fansId);

    }
    //删除喜欢吃
    public static  void deleteFavorite(int userId,String favorite){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.deleteFavorite(favorite);

    }
    //删除讨厌吃
    public static  void deleteHate(int userId,String hate){
        com.uglygroup.model.User u=new com.uglygroup.model.User();
        u=selectUserInfor(userId);
        u.deleteHate(hate);

    }



}
