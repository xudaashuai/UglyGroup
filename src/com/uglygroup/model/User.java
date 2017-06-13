package com.uglygroup.model;

import com.uglygroup.Utils.UserDataUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/3.
 */
public class User {
    private String sex;
    private int age;
    private String birthday;
    private String favorite;
    private String hate;
    private String password;
    private String userName;
    private String nickName;
    private String friendList;
    private String follow;
    private String fans;
    private String sign;
    private int trueId;
    private String headPicture;
    public void allSet(String uSex,
                       int uAge,
                       String uBirthDay,
                       String uFavorite,
                       String uHate,
                       String uPassword,
                       String uUserName,
                       String uNickName,
                       String uFriendList,
                       String uFollow,
                       String uFans,
                       String uSign,
                       int uTrueId,
                       String uHeadPicture

    ){
        sex=uSex;
        age=uAge;
        birthday=uBirthDay;
        favorite=uFavorite;
        hate=uHate;
        password=uPassword;
        userName=uUserName;
        nickName=uNickName;
        friendList=uFriendList;
        follow=uFollow;
        fans=uFans;
        trueId=uTrueId;
        sign=uSign;
        headPicture=uHeadPicture;


    }

    //单个属性
    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
        UserDataUtils.userChangeInfor(sex,trueId,"sex");
    }
    @Basic
    @Column(name = "headPicture")
    public String getHeadPicture() {
        return headPicture;
    }
    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
        // getConnection();
        UserDataUtils.userChangeInfor(headPicture,trueId,"headPicture");
    }
    @Basic
    @Column(name = "trueId")
    public int getTrueId() {
        return trueId;
    }
    @Basic
    @Column(name = "sign")
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        //new  here
        this.sign = sign;
        UserDataUtils.userChangeInfor(sign,trueId,"sign");
    }
    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
       UserDataUtils.userChangeInfor(String.valueOf(age),trueId,"age");
    }
    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
        UserDataUtils.userChangeInfor(birthday,trueId,"birthday");
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
       UserDataUtils.userChangeInfor(password,trueId,"password");
    }
    @Basic
    @Column(name = "userName")
    public String getLoginName() {
        return userName;
    }
    @Basic
    @Column(name = "nickName")
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
        UserDataUtils.userChangeInfor(nickName,trueId,"nickName");
    }

   //列表属性
    @Basic
    @Column(name = "favorite")
    public ArrayList<String> getFavorite() {
        ArrayList<String> favList=new ArrayList<String>();
        favList=getList(favorite);
        return favList;
    }
    public void addFavorite(String newFavorite) {
        for(int i=0;i<this.getFavorite().size();i++){
            if(newFavorite.equals(this.getFavorite().get(i))) {
                return;
            }
        }
        if (this.favorite.equals("")){
            this.favorite=newFavorite;
        }
        else {
            this.favorite = this.favorite + "," + newFavorite;
        }
        UserDataUtils.userChangeInfor(this.favorite,trueId,"favorite");
    }
    public void deleteFavorite(String oldFavorite){
        ArrayList<String> a= this.getFavorite();
        this.favorite=getStrFromStringList(a,oldFavorite);
        UserDataUtils.userChangeInfor(this.favorite,trueId,"favorite");

    }
    @Basic
    @Column(name = "hate")
    public ArrayList<String> getHate() {
        ArrayList<String> hateList=new ArrayList<String>();
        hateList=getList(hate);
        return hateList;
    }
    public void addHate(String newHate) {
        for(int i=0;i<this.getHate().size();i++){
            if(newHate.equals(this.getHate().get(i))) {
                return;
            }
        }
        if (this.hate.equals("")){
            this.hate=newHate;
        }
        else {
            this.hate = this.hate+ "," + newHate;
        }
        UserDataUtils.userChangeInfor(this.hate,trueId,"hate");
    }
    public void deleteHate(String oldHate){
        ArrayList<String> a= this.getHate();
        this.hate=getStrFromStringList(a,oldHate);
        UserDataUtils.userChangeInfor(this.hate,trueId,"hate");
    }

    @Basic
    @Column(name = "friendList")
    public ArrayList<Integer> getFriendList() {
        ArrayList<Integer> frList=new ArrayList<Integer>();
        frList=getIntList(friendList);
        return frList;
    }
    public void addFriend(int friendId){
        for(int i=0;i<this.getFriendList().size();i++){
            if(friendId==this.getFriendList().get(0)) {
                return;
            }
        }
        if (this.friendList.equals("")){
            this.friendList=String.valueOf(friendId);
        }
        else {
            this.friendList = this.friendList + "," + String.valueOf(friendId);
        }
        UserDataUtils.userChangeInfor(this.friendList,trueId,"friendList");
    }
    public void deleteFriend(int oldFriend){
        ArrayList<Integer> a= this.getFriendList();
        this.friendList=getStrFromIntList(a,oldFriend);
        UserDataUtils.userChangeInfor(this.friendList,trueId,"friendList");
    }


    @Basic
    @Column(name = "follow")
    public ArrayList<Integer> getFollow() {
        ArrayList<Integer> followList = new ArrayList<Integer>();
        String a = "";
        followList=getIntList(follow);
        return followList;
    }
    public void addFollow(int followId){
        for(int i=0;i<this.getFollow().size();i++){
            if(followId==this.getFollow().get(i)) {
                return;
            }
        }
        if (this.follow.equals("")){
            this.follow=String.valueOf(followId);
        }
        else {
            this.follow = this.follow + "," + String.valueOf(followId);
        }
        UserDataUtils.userChangeInfor(this.follow,trueId,"follow");

    }
    public void deleteFollow(int oldFollow){
        ArrayList<Integer> a= this.getFollow();
        this.follow=getStrFromIntList(a,oldFollow);
        UserDataUtils.userChangeInfor(this.follow,trueId,"follow");
    }



    @Basic
    @Column(name = "fans")
    public ArrayList<Integer> getFans() {
        ArrayList<Integer> fansList = new ArrayList<Integer>();
        fansList=getIntList(fans);
        return fansList;
    }
    public void addFans(int fansId){
        for(int i=0;i<this.getFans().size();i++){
            if(fansId==this.getFans().get(i)) {
                return;
            }
        }
        if (this.fans.equals("")){
            this.fans=String.valueOf(fansId);
        }
        else {
            this.fans = this.fans + "," + fansId;
        }
        UserDataUtils.userChangeInfor(this.fans,trueId,"fans");

    }
    public void deleteFans(int oldFans){
        ArrayList<Integer> a= this.getFans();
        this.fans=getStrFromIntList(a,oldFans);
        UserDataUtils.userChangeInfor(this.fans,trueId,"fans");
    }


    //用字符串分割的方法获取到列表
    private ArrayList<Integer> getIntList(String str){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(str.equals("")){
            return list;
        }
        else {
            String[] strList = str.split(",");

            for (int i = 0; i < strList.length; i++) {


                list.add(Integer.parseInt(strList[i]));
            }
            return list;
        }

    }
    private ArrayList<String> getList(String str){
        ArrayList<String> list=new ArrayList<String>();
        String[] strList=str.split(",");
        for(int i=0;i<strList.length;i++){
            list.add(strList[i]);
        }
        return list;
    }
    //将列表接成字符串
    private String getStrFromIntList(ArrayList<Integer> a,int content){
        String str="";
        for(int i=0;i<a.size();i++){
            if(content==(a.get(i))) {
                a.remove(i);
                break;
            }
        }
        for (int i=0;i<a.size();i++){

            str+=String.valueOf(a.get(i));
            if(i!=a.size()-1){
                str+=",";
            }
        }
        return str;
    }
    private String getStrFromStringList(ArrayList<String> a,String content){
        String str="";
        for(int i=0;i<a.size();i++){
            if(content.equals(a.get(i))) {
                a.remove(i);
                break;
            }
        }
        for (int i=0;i<a.size();i++){

            str+=a.get(i);
            if(i!=a.size()-1){
                str+=",";
            }
        }
        return str;
    }
}
