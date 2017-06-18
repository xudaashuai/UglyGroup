package com.uglygroup.model;

import com.uglygroup.Utils.CommentUtils;
import com.uglygroup.Utils.MessageUtils;
import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.Utils.Utils;

import javax.persistence.Basic;
import javax.persistence.Column;
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
   public  int getUnread(){
        return MessageUtils.unreadNumber(trueId);
   }

    public String getFriendList(){
        return friendList;
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

    public ArrayList<com.uglygroup.model.User> selectFriend() {
        ArrayList<Integer> fId=new ArrayList<Integer>();
        fId=getIntList(friendList);
        ArrayList<com.uglygroup.model.User> friends=new ArrayList<com.uglygroup.model.User>();
        int friendId;
        for(int i=0;i<fId.size();i++){
            friendId=fId.get(i);
            friends.add(UserDataUtils.selectUserInfor(friendId));
        }
        return friends;
    }
    public Utils.addStatus addFriend(int friendId){
        ArrayList<Integer> fId=new ArrayList<Integer>();
        fId=getIntList(friendList);
        for(int i=0;i<fId.size();i++){
            if(friendId==fId.get(i)) {
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
        ArrayList<Integer> a=new ArrayList<Integer>();
        a=getIntList(friendList);
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
    public  ArrayList<com.uglygroup.model.User> selectFollow() {
        ArrayList<Integer> foId = new ArrayList<Integer>();
        foId=getIntList(follow);
        ArrayList<com.uglygroup.model.User> follows=new ArrayList<>();

        int followId;
        for(int i=0;i<foId.size();i++){
            followId=foId.get(i);
            follows.add(UserDataUtils.selectUserInfor(followId));
        }
        return follows;
    }
    public Utils.addStatus addFollow(int followId){
        ArrayList<Integer> foId = new ArrayList<Integer>();
        foId=getIntList(follow);
        for(int i=0;i<foId.size();i++){

            if(followId==foId.get(i)) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.follow.equals("")){
            this.follow=String.valueOf(followId);
        }
        else {
            this.follow = this.follow + "," + String.valueOf(followId);
        }
        MessageUtils.addMessage(trueId,followId,4);
        User u;
        u=UserDataUtils.selectUserInfor(followId);
        u.addFans(trueId);
        UserDataUtils.userChangeInfor(this.follow,trueId,"follow");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFollow(int oldFollow){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a=getIntList(follow);
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
    public ArrayList<com.uglygroup.model.User> selectFans() {

        ArrayList<Integer> faId = new ArrayList<Integer>();
        faId=getIntList(fans);
        ArrayList<User> fansLis=new ArrayList<User>();
        int fansId;
        for(int i=0;i<faId.size();i++){
            fansId=faId.get(i);
            fansLis.add(UserDataUtils.selectUserInfor(fansId));
        }

        return fansLis;
    }
    public Utils.addStatus addFans(int fansId){
        ArrayList<Integer> faId = new ArrayList<Integer>();
        faId=getIntList(fans);
        for(int i=0;i<faId.size();i++){
            if(fansId==faId.get(i)) {
                return Utils.addStatus.ITEMEXIST;
            }
        }
        if (this.fans.equals("")){
            this.fans=String.valueOf(fansId);
        }
        else {
            this.fans = this.fans + "," + fansId;
        }
        MessageUtils.addMessage(trueId,fansId,5);
        UserDataUtils.userChangeInfor(this.fans,trueId,"fans");
        return Utils.addStatus.ADDSUCCESS;
    }
    public Utils.deleteStatus deleteFans(int oldFans){
        ArrayList<Integer> faId = new ArrayList<Integer>();
        faId=getIntList(fans);
        int c=0;
        this.fans=getStrFromIntList(faId,oldFans,c);
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
    public   ArrayList<Message> selectMessage() {
        ArrayList<Integer>  messageList = new ArrayList<>();
        ArrayList<Message> messages=new ArrayList<>();
        messageList=getIntList(message);
        int messageId;
        for(int i=0;i<messageList.size();i++){
            messageId=messageList.get(i);
            messages.add(MessageUtils.selectMessage(messageId));
        }
        return messages;

    }

    public void addComment(int shopId,String commentBody,int score,String[] pic){
        CommentUtils.addComment(commentBody,shopId,trueId,score,pic);

    }
    public void addMessage(String newMessage){
           if(this.message.equals("")){
               this.message=newMessage;
           }
           else {
               this.message = this.message + "," + newMessage;
           }
        UserDataUtils.userChangeInfor(this.message,trueId,"message");
    }
    public ArrayList<Message> checkMessage(int type,int status) {
        ArrayList<Message> messages = new ArrayList<>();
        messages= selectMessage();
        ArrayList<Message> typeMessage=new ArrayList<>();
        for(int i=0;i<messages.size();i++){
            if(messages.get(i).getType()==type){
                if(messages.get(i).getStatus()==status){
                    typeMessage.add(messages.get(i));
                }
            }
        }
        return typeMessage;
    }

    public   void setRead(int messageId){
      MessageUtils.selectMessage(messageId).setStatus(1);
    }
    public boolean inList(String whatList,int id){
        ArrayList<Integer> lis=new ArrayList<>();
         if(whatList.equals("friend")) {
            lis = getIntList(friendList);
            for (int i = 0; i < lis.size(); i++) {
                if (lis.get(i) == id) {
                    return true;
                }
            }
            return false;
        }
        else if(whatList.equals("follow")){
                lis=getIntList(follow);
                for(int i = 0; i< selectFollow().size(); i++){
                    if(lis.get(i)==id){
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
