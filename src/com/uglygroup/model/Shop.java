package com.uglygroup.model;

import com.uglygroup.Utils.CommentUtils;
import com.uglygroup.Utils.DatabaseUtils;
import com.uglygroup.Utils.ShopDataUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/4.
 */

public class Shop {
    private String location;
    private String inRank;
    private String phone;
    private int star;
    private int price;
    private String address;
    private String name;
    private int id;
    private String[] recommend_thing;
    private String simple_info;
    private String long_info;
    private String type;
    private String time;
    private String parking;
    private String wifi;
    private String[] shopPic;

    public void allSet(
                       int sId,
                       String sName,
                       String sLocal,
                       String sAddress,
                       int  sStar,
                       int sPrice,
                       String sPhone,
                       String[] sRecommend,
                       String sSimple_info,
                       String sLong_info,
                       String sType,
                       String sInRank,
                       String sTime,
                       String sParking,
                       String sWifi,
                       String[]pic



    ) {
        id=sId;
        name=sName;
        location = sLocal;
        address=sAddress;
        star=sStar;
        price=sPrice;
        phone=sPhone;
        recommend_thing=sRecommend;
        simple_info=sSimple_info;
        long_info=sLong_info;
        type=sType;
        inRank = sInRank;
        time=sTime;
        parking=sParking;
        wifi=sWifi;
        shopPic=pic;



    }

    //单个属性
    @Id
    @Column(name = "id")//商家Id
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "name")//名字
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "location")//经纬度
    public String getLocation() {
        return location;
    }

    @Basic
    @Column(name = "address")//详细地址
    public String getAddress() {
        return address;
    }

    @Basic
    @Column(name = "star")//评星等级
    public int getStar() {
        return star;
    }
    @Basic
    @Column(name = "price")//平均价格
    public int getPrice() {
        return price;
    }

    @Basic
    @Column(name = "phone")//电话
    public String getPhone() {
        return phone;
    }

    @Basic
    @Column(name = "recommend")//推荐
    public String[] getRecommend_thing() {
        return recommend_thing;
    }


    @Basic
    @Column(name = "simple_info")//简单信息
    public String getSimple_info() {
        return simple_info;
    }
    public String getTime(){return time;}
    public String getParking(){return parking;}
    public String getWifi(){return parking;}
    public String[] getShopPic(){return shopPic;}



    @Basic
    @Column(name = "long_info")//长信息
    public String getLong_info() {
        return long_info;
    }


    @Basic
    @Column(name = "type")//类型
    public String getType() {
        return type;
    }

    public  ArrayList<Comment> getShopComment(){
        String sql="select commentId from comment where shopId='"+String.valueOf(id)+"';";
        ArrayList<Integer>commentId=new ArrayList<Integer>();
        ArrayList<Comment>comments=new ArrayList<Comment>();
        int cid;
        try{

            ResultSet rs= DatabaseUtils.getResult(sql);
            while (rs.next()){

                cid=rs.getInt(1);
                commentId.add(cid);
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<commentId.size();i++){
            comments.add(CommentUtils.selectComment(commentId.get(i)));
        }
        return comments;
    }
    //列表属性
    @Basic
    @Column(name = "inRank")//所在排行榜
    public ArrayList<String> getInRank() {
        ArrayList<String> inRankList=new ArrayList<String>();
        inRankList=getList(inRank);
        return inRankList;
    }
    public void addRank(String newRank) {
        for(int i=0;i<this.getInRank().size();i++){
            if(newRank.equals(this.getInRank().get(i))) {
                return;
            }
        }
        if (this.inRank.equals("")){
            this.inRank=newRank;
        }
        else {
           this.inRank = this.inRank+ "/" + newRank;
    }
        ShopDataUtils.shopChangeInfor(this.inRank,id,"inRank");
}
    public void deleteRank(String oldRank) {
        ArrayList<String> a = this.getInRank();
        this.inRank = getStr(a, oldRank);
        ShopDataUtils.shopChangeInfor(this.inRank, id, "inRank");
    }

    //用字符串分割的方法获取到列表
    private ArrayList<String> getList(String str){
        ArrayList<String> list=new ArrayList<String>();
        String[] strList=str.split("/");
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
                str+="/";
            }
        }
        return str;
    }
}
