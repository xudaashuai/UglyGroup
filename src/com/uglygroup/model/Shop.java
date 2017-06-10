package com.uglygroup.model;

import com.uglygroup.Utils.ShopDataUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/4.
 */

public class Shop {
    private String location;
    private String inRank;
    private String subType;
    private String tel;
    private double star;
    private double avgPrice;
    private double tastep;
    private double enviornmentp;
    private double servicep;
    private String mainType;
    private String address;
    private String shopName;
    private String signId;
    private int shopTrueId;
    public void allSet(
                       String sLocal,
                       String sInRank,
                       String sSubType,
                       String sTel,
                       double sStar,
                       double sAvgPrice,
                       double sTastep,
                       double sEnviornmentp,
                       double sServicep,
                       String sMainType,
                       String sAddress,
                       String sName,
                       String sSignId,
                       int sTid

    ) {
        location = sLocal;
        inRank = sInRank;
        subType = sSubType;
        tel = sTel;
        star = sStar;
        avgPrice = sAvgPrice;
        tastep = sTastep;
        enviornmentp = sEnviornmentp;
        servicep = sServicep;
        mainType = sMainType;
        address=sAddress;
        shopName=sName;
        signId=sSignId;
        shopTrueId=sTid;

    }

    //单个属性
    @Id
    @Column(name = "tId")//商家Id
    public int getTid() {
        return shopTrueId;
    }
    @Basic
    @Column(name = "local")//经纬度
    public String getLocal() {
        return location;
    }
    public void setLocal(String local) {
        this.location = local;
       ShopDataUtils.shopChangeInfor(local,shopTrueId,"location");
    }
    @Basic
    @Column(name = "tel")//电话
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
       ShopDataUtils.shopChangeInfor(tel,shopTrueId,"tel");
    }
    @Basic
    @Column(name = "star")//评星等级
    public double getStar() {
        return star;
    }
    public void setStar(double star) {
        this.star = star;
       ShopDataUtils.shopChangeInfor(String.valueOf(star),shopTrueId,"star");
    }
    @Basic
    @Column(name = "avgprice")//平均价格
    public double getAvgPrice() {
        return avgPrice;
    }
    public void setAvgPrice(double avgprice) {
        this.avgPrice = avgprice;
       ShopDataUtils.shopChangeInfor(String.valueOf(avgprice),shopTrueId,"avgPrice");
    }
    @Basic
    @Column(name = "tastep")//味道评分
    public double getTastep() {
        return tastep;
    }
    public void setTastep(double tastep) {
        this.tastep = tastep;
       ShopDataUtils.shopChangeInfor(String.valueOf(tastep),shopTrueId,"tastep");
    }
    @Basic
    @Column(name = "enviornmentp")//环境评分
    public double getEnviornmentp() {
        return enviornmentp;
    }
    public void setEnviornmentp(double enviornmentp) {
        this.enviornmentp = enviornmentp;
       ShopDataUtils.shopChangeInfor(String.valueOf(enviornmentp),shopTrueId,"enviornmentp");
    }
    @Basic
    @Column(name = "servicep")//服务评分
    public double getServicep() {
        return servicep;
    }
    public void setServicep(double servicep) {
        this.servicep = servicep;
       ShopDataUtils.shopChangeInfor(String.valueOf(servicep),shopTrueId,"servicep");
    }
    @Basic
    @Column(name = "address")//详细地址
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
       ShopDataUtils.shopChangeInfor(address,shopTrueId,"address");
    }
    @Basic
    @Column(name = "shopname")//详细地址
    public String getShopname() {
        return shopName;
    }
    public void setShopname(String shopname) {
        this.shopName =shopname ;
       ShopDataUtils.shopChangeInfor(shopname,shopTrueId,"shopName");
    }
    @Basic
    @Column(name = "signId")//详细地址
    public String getSignId() {
        return signId;
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
        ShopDataUtils.shopChangeInfor(this.inRank,shopTrueId,"inRank");
    }
    public void deleteRank(String oldRank){
        ArrayList<String> a= this.getInRank();
        this.inRank=getStr(a,oldRank);
        ShopDataUtils.shopChangeInfor(this.inRank,shopTrueId,"inRank");
    }
    @Basic
    @Column(name = "subType")//类型
    public ArrayList<String> getSubType() {
        ArrayList<String> subTypeList=new ArrayList<String>();
        subTypeList=getList(subType);
        return subTypeList;
    }
    public void addSubType(String newSubType) {
        for(int i=0;i<this.getSubType().size();i++){
            if(newSubType.equals(this.getSubType().get(i))) {
                return;
            }
        }
        if (this.subType.equals("")){
            this.subType=newSubType;
        }
        else {
            this.subType= this.subType+ "/" + newSubType;
        }
        ShopDataUtils.shopChangeInfor(this.subType,shopTrueId,"subType");
    }
    public void deleteSubType(String oldSubType){
        ArrayList<String> a= this.getSubType();
        this.inRank=getStr(a,oldSubType);
        ShopDataUtils.shopChangeInfor(this.subType,shopTrueId,"subType");
    }
    @Basic
    @Column(name = "mainType")//商圈
    public ArrayList<String> getMainType() {
        ArrayList<String> mainTypeList=new ArrayList<String>();
        mainTypeList=getList(mainType);
        return mainTypeList;
    }
    public void addMainType(String newMainType) {
        for(int i=0;i<this.getMainType().size();i++){
            if(newMainType.equals(this.getMainType().get(i))) {
                return;
            }
        }
        if (this.mainType.equals("")){
            this.mainType=newMainType;
        }
        else {
            this.mainType = this.mainType+ "/" + newMainType;
        }
        ShopDataUtils.shopChangeInfor(this.mainType,shopTrueId,"mainType");
    }
    public void deleteMainType(String oldMainType){
        ArrayList<String> a= this.getMainType();
        this.mainType=getStr(a,oldMainType);
        ShopDataUtils.shopChangeInfor(this.mainType,shopTrueId,"mainType");
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
