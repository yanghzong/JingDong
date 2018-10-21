package com.bw.jingdong.bean;

import java.util.List;

/**
 * Created by 择木 on 2018/10/17.
 */

public class Shou_ninebean {


    /**
     * code : 0
     * data : [{"cid":1,"createtime":"2017-10-10T19:41:39","icon":"http://120.27.23.105/images/category/shop.png","ishome":1,"name":"京东超市"},{"cid":2,"createtime":"2017-10-10T19:41:39","icon":"http://120.27.23.105/images/category/qqg.png","ishome":1,"name":"全球购"},{"cid":3,"createtime":"2017-10-10T19:45:11","icon":"http://120.27.23.105/images/category/phone.png","ishome":1,"name":"手机数码"},{"cid":5,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/man.png","ishome":1,"name":"男装"},{"cid":6,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/girl.png","ishome":1,"name":"女装"},{"cid":7,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/manshoe.png","ishome":1,"name":"男鞋"},{"cid":8,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/girlshoe.png","ishome":1,"name":"女鞋"},{"cid":9,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/shirt.png","ishome":1,"name":"内衣配饰"},{"cid":10,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/bag.png","ishome":1,"name":"箱包手袋"},{"cid":11,"createtime":"2017-10-10T20:12:03","icon":"http://120.27.23.105/images/category/beauty.png","ishome":1,"name":"美妆个护"}]
     * msg :
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cid : 1
         * createtime : 2017-10-10T19:41:39
         * icon : http://120.27.23.105/images/category/shop.png
         * ishome : 1
         * name : 京东超市
         */

        private int cid;
        private String createtime;
        private String icon;
        private int ishome;
        private String name;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getIshome() {
            return ishome;
        }

        public void setIshome(int ishome) {
            this.ishome = ishome;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
