package com.uglygroup.model;

import com.uglygroup.Utils.ShopsDataUtils;
import com.uglygroup.Utils.UsersDataUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/4.
 */

public class Shops {

    private String id;
    private String local;
    private String inRank;
    private String subtype;
    private String tel;
    private String star;
    private String avgprice;
    private String tastep;
    private String enviornmentp;
    private String servicep;
    private String maintype;
    private String address;
    private String shopname;
    private String signId;
    private int tId;
    public void allSet(String sId,
                       String sLocal,
                       String sInRank,
                       String sSubtype,
                       String sTel,
                       String sStar,
                       String sAvgprice,
                       String sTastep,
                       String sEnviornmentp,
                       String sServicep,
                       String sMaintype,
                       String sAddress,
                       String sName,
                       String sSignId,
                       int sTid

    ) {
        id = sId;
        local = sLocal;
        inRank = sInRank;
        subtype = sSubtype;
        tel = sTel;
        star = sStar;
        avgprice = sAvgprice;
        tastep = sTastep;
        enviornmentp = sEnviornmentp;
        servicep = sServicep;
        maintype = sMaintype;
        address=sAddress;
        shopname=sName;
        signId=sSignId;

    }

    //单个属性
    @Id
    @Column(name = "Id")//商家Id
    public String getId() {
        return id;
    }
    @Id
    @Column(name = "tId")//商家Id
    public int getTid() {
        return tId;
    }
    @Basic
    @Column(name = "local")//经纬度
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
        ShopsDataUtils.shopChangeInfor(local,signId,"local");
    }
    @Basic
    @Column(name = "tel")//电话
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
        ShopsDataUtils.shopChangeInfor(tel,signId,"tel");
    }
    @Basic
    @Column(name = "star")//评星等级
    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
        ShopsDataUtils.shopChangeInfor(star,signId,"star");
    }
    @Basic
    @Column(name = "avgprice")//平均价格
    public String getAvgprice() {
        return avgprice;
    }
    public void setAvgprice(String avgprice) {
        this.avgprice = avgprice;
        ShopsDataUtils.shopChangeInfor(avgprice,signId,"avgprice");
    }
    @Basic
    @Column(name = "tastep")//味道评分
    public String getTastep() {
        return tastep;
    }
    public void setTastep(String tastep) {
        this.tastep = tastep;
        ShopsDataUtils.shopChangeInfor(tastep,signId,"tastep");
    }
    @Basic
    @Column(name = "enviornmentp")//环境评分
    public String getEnviornmentp() {
        return enviornmentp;
    }
    public void setEnviornmentp(String enviornmentp) {
        this.enviornmentp = enviornmentp;
        ShopsDataUtils.shopChangeInfor(enviornmentp,signId,"enviornmentp");
    }
    @Basic
    @Column(name = "servicep")//服务评分
    public String getServicep() {
        return servicep;
    }
    public void setServicep(String servicep) {
        this.servicep = servicep;
        ShopsDataUtils.shopChangeInfor(servicep,signId,"servicep");
    }
    @Basic
    @Column(name = "address")//详细地址
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
        ShopsDataUtils.shopChangeInfor(address,signId,"address");
    }
    @Basic
    @Column(name = "shopname")//详细地址
    public String getShopname() {
        return shopname;
    }
    public void setShopname(String shopname) {
        this.shopname =shopname ;
        ShopsDataUtils.shopChangeInfor(shopname,signId,"shopname");
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
        UsersDataUtils.userChangeInfor(this.inRank,signId,"inRank");
    }
    public void deleteRank(String oldRank){
        ArrayList<String> a= this.getInRank();
        this.inRank=getStr(a,oldRank);
        UsersDataUtils.userChangeInfor(this.inRank,signId,"inRank");
    }
    @Basic
    @Column(name = "subtype")//类型
    public ArrayList<String> getSubtype() {
        ArrayList<String> subtypeList=new ArrayList<String>();
        subtypeList=getList(subtype);
        return subtypeList;
    }
    public void addSubtype(String newSubtype) {
        for(int i=0;i<this.getSubtype().size();i++){
            if(newSubtype.equals(this.getSubtype().get(i))) {
                return;
            }
        }
        if (this.subtype.equals("")){
            this.subtype=newSubtype;
        }
        else {
            this.subtype= this.subtype+ "/" + newSubtype;
        }
        UsersDataUtils.userChangeInfor(this.subtype,signId,"subtype");
    }
    public void deleteSubtype(String oldSubtype){
        ArrayList<String> a= this.getSubtype();
        this.inRank=getStr(a,oldSubtype);
        UsersDataUtils.userChangeInfor(this.subtype,signId,"subtype");
    }
    @Basic
    @Column(name = "maintype")//商圈
    public ArrayList<String> getMaintype() {
        ArrayList<String> maintypeList=new ArrayList<String>();
        maintypeList=getList(maintype);
        return maintypeList;
    }
    public void addMaintype(String newMaintype) {
        for(int i=0;i<this.getMaintype().size();i++){
            if(newMaintype.equals(this.getMaintype().get(i))) {
                return;
            }
        }
        if (this.maintype.equals("")){
            this.maintype=newMaintype;
        }
        else {
            this.maintype = this.maintype+ "/" + newMaintype;
        }
        UsersDataUtils.userChangeInfor(this.maintype,signId,"maintype");
    }
    public void deleteMaintype(String oldMaintype){
        ArrayList<String> a= this.getMaintype();
        this.maintype=getStr(a,oldMaintype);
        UsersDataUtils.userChangeInfor(this.maintype,signId,"maintype");
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
