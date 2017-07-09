package com.uglygroup.model;

import java.sql.Timestamp;

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

    public void allSet(int rId,
                       String rName,
                       int rCreatorId,
                       Timestamp rTime,
                       String rIntroduction,
                       String[] rShopList){
        id=rId;
        name=rName;
        creatorId=rCreatorId;
        time=rTime;
        introduction = rIntroduction;
        shopList=rShopList;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String[] getShopList() {
        return shopList;
    }
}
