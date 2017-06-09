package com.uglygroup.model;

import com.uglygroup.Utils.UsersDataUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/3.
 */
public class User {
    private String sex;
    private String age;
    private String birthday;
    private String favorite;
    private String hate;
    private String realname;
    private String password;
    private String userId;
    private String loginname;
    private String nickname;
    private String friendlist;
    private String concern;
    private String fans;
    private String sign;
    private int tId;
    public void allSet(String uSex,
                       String uAge,
                       String uBirthDay,
                       String uFavorite,
                       String uHate,
                       String uRealname,
                       String uPassword,
                       String uUserId,
                       String uLoginname,
                       String uNickname,
                       String uFriendlist,
                       String uConcern,
                       String uFans,
                       String uSign,
                       int uTid

    ){
        sex=uSex;
        age=uAge;
        birthday=uBirthDay;
        favorite=uFavorite;
        hate=uHate;
        realname=uRealname;
        password=uPassword;
        userId=uUserId;
        loginname=uLoginname;
        nickname=uNickname;
        friendlist=uFriendlist;
        concern=uConcern;
        fans=uFans;
        tId=uTid;


    }

    //单个属性
    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
       // getConnection();
         UsersDataUtils.userChangeInfor(sex,loginname,"sex");
    }
    @Basic
    @Column(name = "tId")
    public int getTid() {
        return tId;
    }
    @Basic
    @Column(name = "sign")
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
        // getConnection();
        UsersDataUtils.userChangeInfor(sign,loginname,"sign");
    }
    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
       UsersDataUtils.userChangeInfor(age,loginname,"age");
    }
    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
        UsersDataUtils.userChangeInfor(birthday,loginname,"birthday");
    }
    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
       UsersDataUtils.userChangeInfor(realname,loginname,"realname");
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
       UsersDataUtils.userChangeInfor(password,loginname,"password");
    }
    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }
    @Basic
    @Column(name = "loginname")
    public String getLoginname() {
        return loginname;
    }
    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
        UsersDataUtils.userChangeInfor(nickname,loginname,"nickname");
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
        UsersDataUtils.userChangeInfor(this.favorite,loginname,"favorite");
    }
    public void deleteFavorite(String oldFavorite){
        ArrayList<String> a= this.getFavorite();
        this.favorite=getStr(a,oldFavorite);
        UsersDataUtils.userChangeInfor(this.favorite,loginname,"favorite");

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
        UsersDataUtils.userChangeInfor(this.hate,loginname,"hate");
    }
    public void deleteHate(String oldHate){
        ArrayList<String> a= this.getHate();
        this.hate=getStr(a,oldHate);
        UsersDataUtils.userChangeInfor(this.hate,loginname,"hate");
    }

    @Basic
    @Column(name = "friendlist")
    public ArrayList<String> getFrinedList() {
        ArrayList<String> frList=new ArrayList<String>();
        frList=getList(friendlist);
        return frList;
    }
    public void addFriend(String friendId){
        for(int i=0;i<this.getFrinedList().size();i++){
            System.out.println(this.getFrinedList().get(i));
            if(friendId.equals(this.getFrinedList().get(i))) {
                return;
            }
        }
        if (this.friendlist.equals("")){
            this.friendlist=friendId;
        }
        else {
            this.friendlist = this.friendlist + "," + friendId;
        }
        UsersDataUtils.userChangeInfor(this.friendlist,loginname,"friendlist");
    }
    public void deleteFriend(String oldFriend){
        ArrayList<String> a= this.getFrinedList();
        this.friendlist=getStr(a,oldFriend);
        UsersDataUtils.userChangeInfor(this.friendlist,loginname,"friendlist");
    }


    @Basic
    @Column(name = "concern")
    public ArrayList<String> getConcern() {
        ArrayList<String> concernList = new ArrayList<String>();
        String a = "";
        concernList=getList(concern);
        return concernList;
    }
    public void addConcern(String concernId){
        for(int i=0;i<this.getConcern().size();i++){
            if(concernId.equals(this.getConcern().get(i))) {
                return;
            }
        }
        if (this.concern.equals("")){
            this.concern=concernId;
        }
        else {
            this.concern = this.concern + "," + concernId;
        }
        UsersDataUtils.userChangeInfor(this.concern,loginname,"concern");

    }
    public void deleteConcern(String oldConcern){
        ArrayList<String> a= this.getConcern();
        this.concern=getStr(a,oldConcern);
        UsersDataUtils.userChangeInfor(this.concern,loginname,"concern");
    }



    @Basic
    @Column(name = "fans")
    public ArrayList<String> getFans() {
        ArrayList<String> fansList = new ArrayList<String>();
        String a = "";
        fansList=getList(fans);
        return fansList;
    }
    public void addFans(String fansId){
        for(int i=0;i<this.getFans().size();i++){
            if(fansId.equals(this.getFans().get(i))) {
                return;
            }
        }
        if (this.fans.equals("")){
            this.fans=fansId;
        }
        else {
            this.fans = this.fans + "," + fansId;
        }
        UsersDataUtils.userChangeInfor(this.fans,loginname,"fans");

    }
    public void deleteFans(String oldFans){
        ArrayList<String> a= this.getFans();
        this.fans=getStr(a,oldFans);
        UsersDataUtils.userChangeInfor(this.fans,loginname,"fans");
    }


    //用字符串分割的方法获取到列表
    private ArrayList<String> getList(String str){
        ArrayList<String> list=new ArrayList<String>();
        String[] strList=str.split(",");
        for(int i=0;i<strList.length;i++){
            list.add(strList[i]);
        }
        return list;
    }
    //将列表接成字符串
    private String getStr(ArrayList<String> a,String content){
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
