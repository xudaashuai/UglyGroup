package com.uglygroup.model;

import com.uglygroup.Utils.ShopDataUtils;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Think on 2017/6/13.
 */
public class Rank {
    private int id;
    private String name;
    private int creatorId;
    private Timestamp time;
    private String introduction;
    private String[] shopList;
    private String pic;

    public void allSet(int rId,
                       String rName,
                       int rCreatorId,
                       Timestamp rTime,
                       String rIntroduction,
                       String[] rShopList,
                       String pic

    ){
        id=rId;
        name=rName;
        creatorId=rCreatorId;
        time=rTime;
        introduction = rIntroduction;
        shopList=rShopList;
        this.pic=pic;
    }

    public int getId() {
        return id;
    }


    public ArrayList<Shop> selectShop(int page){
        ArrayList<Shop> shops=new ArrayList<>();
        if((page+1)*10>shopList.length){
            return shops;
        }
        else {
            for (int i = page; i < (page + 1) * 10; i++) {
                Shop s = ShopDataUtils.selectShop(Integer.parseInt(shopList[i]));
                shops.add(s);
            }
            return shops;
        }
    }
    public String getName(){
        return name;
    }

    public Timestamp getTime(){
        return time;
    }

    public String getIntroduction(){
        return introduction;
    }

    public String getPic() {
        return pic;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String[] getShopList() {
        return shopList;
    }
}
