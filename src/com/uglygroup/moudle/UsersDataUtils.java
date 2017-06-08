package com.uglygroup.moudle;

import java.util.ArrayList;

/**
 * Created by Think on 2017/6/6.
 */
import java.sql.ResultSet;

public class UsersDataUtils {
    //git test Q
    private static int inId;
    //用户登录、注册和更改信息操作
    static {
        inId=0;
    }
    //登陆处理
    public static Utils.loginStatus login(String loginName, String usersPassword, User u) {
        String sql = "select password from users where loginname='" + loginName + "'";
        try {
            //statement = connection.createStatement();
            ResultSet resultSet = DatabaseUtils.getResult(sql);
            int count = 0;
            while (resultSet.next()) {
                String cPassword = resultSet.getString(1);
                if (cPassword.equals(usersPassword)) {
                    try {
                        String sql2="select * from users where loginname='"+loginName+"'";
                        ResultSet rs = DatabaseUtils.getResult(sql2);
                        if(rs.next()) {
                            u.allSet(rs.getString(1), rs.getString(2),
                                    rs.getString(3), rs.getString(4),
                                    rs.getString(5), rs.getString(6),
                                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
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
    public static Utils.registerStatus register(String loginName, String userPassword, String sex, String age, String nickName, String birthDay, String realName) {
        inId++;
        String userId = String.valueOf(inId);
        String favorite = " ";
        String hate = " ";
        String sign="这个人很懒，什么都没写。";
        String sql = "insert into users values(" +
                "'" + sex + "','" + age + "','" + birthDay + "','" + favorite + "','" + hate + "','" + realName + "','"
                + userPassword + "','" + userId + "','" + loginName +
                "','" + nickName+"','"+sign+ "')" + "on conflict do nothing;";
        String sql2="select * from users where loginName='"+loginName+"'";
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

    public static void userChangeInfor(String content,String loginname,String changeWhat){
            String sql="update users set "+changeWhat+"='"+content+"'where loginname='"+loginname+"'";
            DatabaseUtils.doSql(sql);

    }
    // 查询用户信息
    public static User selectUserInfor(String userId){
        User u=new User();
        String sql = "select * from users where user_id='" + userId + "'";
        try {
            ResultSet rs = DatabaseUtils.getResult(sql);
            if (rs.next()) {
                u.allSet(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));;

            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }


    //查询操作

    //获取好友列表
    public static ArrayList<User> selectUserFriend(String userId){
        User u=new User();
        ArrayList<User> friLis=new ArrayList<User>();
        u=selectUserInfor(userId);
        String friendId="";
        for(int i=0;i<u.getFrinedList().size();i++){
            friendId=u.getFrinedList().get(i);
            friLis.add(selectUserInfor(friendId));
        }
        return friLis;

    }
    //获取用户特别关心
    public static ArrayList<User> selectUserConcern(String userId){
        User u=new User();
        ArrayList<User> concernLis=new ArrayList<User>();
        u=selectUserInfor(userId);
        String friendId="";
        for(int i=0;i<u.getConcern().size();i++){
            friendId=u.getConcern().get(i);
            concernLis.add(selectUserInfor(friendId));
        }
        return concernLis;

    }
    //获取用户粉丝
    public static ArrayList<User> selectUserFans(String userId){
        User u=new User();
        ArrayList<User> fansLis=new ArrayList<User>();
        u=selectUserInfor(userId);
        String friendId="";
        for(int i=0;i<u.getFans().size();i++){
            friendId=u.getFans().get(i);
            fansLis.add(selectUserInfor(friendId));
        }
        return fansLis;
    }
    //获取用户喜欢吃的列表
    public static ArrayList<String> selectUserFavorite(String userId){
        User u=new User();
        ArrayList<String> favLis=new ArrayList<String>();
        u=selectUserInfor(userId);
        for(int i=0;i<u.getFavorite().size();i++){
            favLis.add(u.getFavorite().get(i));
        }
        return favLis;
    }
     //获取用户讨厌吃的列表
    public static ArrayList<String> selectUserHate(String userId){
        User u=new User();
        ArrayList<String> hateLis=new ArrayList<String>();
        u=selectUserInfor(userId);
        for(int i=0;i<u.getHate().size();i++){
            hateLis.add(u.getHate().get(i));
        }
        return hateLis;
    }
    //获取所有注册用户的对象数组
    public static ArrayList<User> getAlluserId(){
        ArrayList<String> allUserId=new ArrayList<String>();
        ArrayList<User> allUser=new ArrayList<User>();
        String sql="select user_id from users";

   try{
       ResultSet rs = DatabaseUtils.getResult(sql);
       while(rs.next()){
           allUserId.add(rs.getString(1));

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
    public static  void addFriend(String userId,String friendId){
        User u=new User();
        u=selectUserInfor(userId);
        u.addFriend(friendId);

    }
    //添加关心
    public static  void addConcern(String userId,String concernId){
        User u=new User();
        u=selectUserInfor(userId);
        u.addConcern(concernId);

    }
    //添加粉丝
    public static  void addFans(String userId,String fansId){
        User u=new User();
        u=selectUserInfor(userId);
        u.addFans(fansId);

    }
    //添加喜欢吃
    public static  void addFavorite(String userId,String favorite){
        User u=new User();
        u=selectUserInfor(userId);
        u.addFavorite(favorite);

    }
    //添加讨厌吃
    public static  void addHate(String userId,String hate){
        User u=new User();
        u=selectUserInfor(userId);
        u.addHate(hate);

    }


    //删除操作

    //删除好友
    public static  void deleteFriend(String userId,String friendId){
        User u=new User();
        u=selectUserInfor(userId);
        u.deleteFriend(friendId);

    }
    //删除关心
    public static  void deleteConcern(String userId,String concernId){
        User u=new User();
        u=selectUserInfor(userId);
        u.deleteConcern(concernId);

    }
    //删除粉丝
    public static  void deleteFans(String userId,String fansId){
        User u=new User();
        u=selectUserInfor(userId);
        u.deleteFans(fansId);

    }
    //删除喜欢吃
    public static  void deleteFavorite(String userId,String favorite){
        User u=new User();
        u=selectUserInfor(userId);
        u.deleteFavorite(favorite);

    }
    //删除讨厌吃
    public static  void deleteHate(String userId,String hate){
        User u=new User();
        u=selectUserInfor(userId);
        u.deleteHate(hate);

    }



}
