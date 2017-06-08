package com.uglygroup.moudle;

/**
 * Created by Think on 2017/6/4.
 */
public class Main {
    public static void main(String[] args) {
        try {
            User u;
           // u= UsersDataUtils.selectUserInfor("1");
           // ShopsDataUtils.addShop("131,123","东半球最好吃的学生食堂","食堂/家常菜/平价","0592-7033715","10","6.5","10","10","10","鲁磨路","中国地质大学西区52栋旁边,弘毅堂后面","学三食堂","11");
            Shops s;
            s=ShopsDataUtils.selectShop("1");
            System.out.println(s.getAvgprice());

            s.setTel("031-8213");
            for(int i=0;i<ShopsDataUtils.getAboutShop("食堂").size();i++){
                System.out.println(ShopsDataUtils.getAllShops().get(i).getAddress());

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
