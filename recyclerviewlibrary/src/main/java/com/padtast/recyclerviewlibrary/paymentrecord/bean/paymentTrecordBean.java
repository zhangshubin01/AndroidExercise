package com.padtast.recyclerviewlibrary.paymentrecord.bean;

import java.util.List;

/**
 * @author zhangshubin
 * @time 2018-09-29 14:50
 * @tel 3487
 * @desc
 */
public class paymentTrecordBean {
    private String name;
    private List<paymentTrecordBean1> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<paymentTrecordBean1> getList() {
        return list;
    }

    public void setList(List<paymentTrecordBean1> list) {
        this.list = list;
    }

  public static class  paymentTrecordBean1{
        private String name;
        private String money;
        List<paymentTrecordBean2> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public List<paymentTrecordBean2> getList() {
            return list;
        }

        public void setList(List<paymentTrecordBean2> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "paymentTrecordBean1{" +
                    "name='" + name + '\'' +
                    ", money='" + money + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    public static  class paymentTrecordBean2{
        private String name;
        private String money;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "paymentTrecordBean2{" +
                    "name='" + name + '\'' +
                    ", money='" + money + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "paymentTrecordBean{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
