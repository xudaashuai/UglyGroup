package com.uglygroup.model;

import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.Utils.Utils;

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
    private String message;
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
                       String uHeadPicture,
                       String uMessage

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
        message=uMessage;

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
    public int getId() {
        return trueId;
    }
    @Basic
    @Column(name = "sign")
    public String getSign() {
        return sign;
    }
    public  void setSign(String sign) {
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
            UserDataUtils.userChangeInfor(String.valueOf(age), trueId, "age");
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
    public Utils.addStatus addFavorite(String newFavorite) {
        for(int i=0;i<this.getFavorite().size();i++){
            if(newFavorite.equals(this.getFavorite().get(i))) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.favorite.equals("")){
            this.favorite=newFavorite;
        }
        else {
            this.favorite = this.favorite + "," + newFavorite;
        }
        UserDataUtils.userChangeInfor(this.favorite,trueId,"favorite");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFavorite(String oldFavorite){
        ArrayList<String> a= this.getFavorite();
        int c=0;
        this.favorite=getStrFromStringList(a,oldFavorite,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else{
            UserDataUtils.userChangeInfor(this.favorite,trueId,"favorite");
            return Utils.deleteStatus.DELETESUCCES;
        }

    }
    @Basic
    @Column(name = "hate")
    public ArrayList<String> getHate() {
        ArrayList<String> hateList=new ArrayList<String>();
        hateList=getList(hate);
        return hateList;
    }
    public Utils.addStatus addHate(String newHate) {
        for(int i=0;i<this.getHate().size();i++){
            if(newHate.equals(this.getHate().get(i))) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.hate.equals("")){
            this.hate=newHate;
        }
        else {
            this.hate = this.hate+ "," + newHate;
        }
        UserDataUtils.userChangeInfor(this.hate,trueId,"hate");
        return  Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteHate(String oldHate){
        ArrayList<String> a= this.getHate();
        int c=0;
        this.hate=getStrFromStringList(a,oldHate,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else {
            UserDataUtils.userChangeInfor(this.hate,trueId,"hate");
            return Utils.deleteStatus.DELETESUCCES;
        }
    }

    @Basic
    @Column(name = "friendList")
    public ArrayList<Integer> getFriendList() {
        ArrayList<Integer> frList=new ArrayList<Integer>();
        frList=getIntList(friendList);
        return frList;
    }
    public Utils.addStatus addFriend(int friendId){
        for(int i=0;i<this.getFriendList().size();i++){
            if(friendId==this.getFriendList().get(0)) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.friendList.equals("")){
            this.friendList=String.valueOf(friendId);
        }
        else {
            this.friendList = this.friendList + "," + String.valueOf(friendId);
        }
        UserDataUtils.userChangeInfor(this.friendList,trueId,"friendList");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFriend(int oldFriend){
        ArrayList<Integer> a= this.getFriendList();
        int c=0;
        this.friendList=getStrFromIntList(a,oldFriend,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else {
            UserDataUtils.userChangeInfor(this.friendList, trueId, "friendList");
            return Utils.deleteStatus.DELETESUCCES;
        }
    }


    @Basic
    @Column(name = "follow")
    public ArrayList<Integer> getFollow() {
        ArrayList<Integer> followList = new ArrayList<Integer>();
        String a = "";
        followList=getIntList(follow);
        return followList;
    }
    public Utils.addStatus addFollow(int followId){
        for(int i=0;i<this.getFollow().size();i++){
            if(followId==this.getFollow().get(i)) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.follow.equals("")){
            this.follow=String.valueOf(followId);
        }
        else {
            this.follow = this.follow + "," + String.valueOf(followId);
        }
        UserDataUtils.userChangeInfor(this.follow,trueId,"follow");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFollow(int oldFollow){
        ArrayList<Integer> a= this.getFollow();
        int c=0;
        this.follow=getStrFromIntList(a,oldFollow,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else {
            UserDataUtils.userChangeInfor(this.follow, trueId, "follow");
            return Utils.deleteStatus.DELETESUCCES;
        }
    }



    @Basic
    @Column(name = "fans")
    public ArrayList<Integer> getFans() {
        ArrayList<Integer> fansList = new ArrayList<Integer>();
        fansList=getIntList(fans);
        return fansList;
    }
    public Utils.addStatus addFans(int fansId){
        for(int i=0;i<this.getFans().size();i++){
            if(fansId==this.getFans().get(i)) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.fans.equals("")){
            this.fans=String.valueOf(fansId);
        }
        else {
            this.fans = this.fans + "," + fansId;
        }
        UserDataUtils.userChangeInfor(this.fans,trueId,"fans");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFans(int oldFans){
        ArrayList<Integer> a= this.getFans();
        int c=0;
        this.fans=getStrFromIntList(a,oldFans,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else {
            UserDataUtils.userChangeInfor(this.fans, trueId, "fans");
            return Utils.deleteStatus.DELETESUCCES;
        }
    }

    @Basic
    @Column(name = "message")
    public ArrayList<String> getMessage() {
        ArrayList<String>  messageList = new ArrayList<String>();
        messageList=getList(message);
        return messageList;

    }
    public void addMessage(String newMessage){
            this.message = this.message + "," + newMessage;

        UserDataUtils.userChangeInfor(this.message,trueId,"message");
    }
    public Utils.deleteStatus deleteMessage(String oldMessage){
        ArrayList<String> a= this.getMessage();
        int c=0;
        this.message=getStrFromStringList(a,oldMessage,c);
        if(c==0){
            return Utils.deleteStatus.ITEMNOEXIST;
        }
        else {
            UserDataUtils.userChangeInfor(this.message, trueId, "message");
            return Utils.deleteStatus.DELETESUCCES;
        }
    }
    public boolean inList(String whatList,int id){
        ArrayList<Integer> lis=new ArrayList<>();
        if(whatList.equals("fans")){
            lis=getFans();
            for(int i=0;i<getFans().size();i++){
                if(getFans().get(i)==id){
                    return true;
                }
            }
            return false;
        }
        else if(whatList.equals("friend")) {
            lis = getFriendList();
            for (int i = 0; i < getFriendList().size(); i++) {
                if (getFriendList().get(i) == id) {
                    return true;
                }
            }
            return false;
        }
        else if(whatList.equals("follow")){
                lis=getFollow();
                for(int i=0;i<getFollow().size();i++){
                    if(getFollow().get(i)==id){
                        return true;
                    }
                }
                return false;
        }
        return false;
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
    private String getStrFromIntList(ArrayList<Integer> a,int content,int c){
        String str="";
        for(int i=0;i<a.size();i++){
            if(content==(a.get(i))) {
                a.remove(i);
                c++;
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
    private String getStrFromStringList(ArrayList<String> a,String content,int c){
        String str="";
        for(int i=0;i<a.size();i++){
            if(content.equals(a.get(i))) {
                a.remove(i);
                c++;
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
