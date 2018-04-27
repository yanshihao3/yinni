package com.ayo.pinjam.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by yanshihao on 2018/1/3.
 */

public class Product implements Parcelable{

    /**
     * code : 200
     * message : 0
     * data : [{"id":"41","name":"请问","link":"","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"9999","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/151210393297018.png?e=1512107543&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:15XE3vd-lwyIpkJ2O3POyxMIz8c=","product_introduction":"请问","product_details":"","created_at":"2017-12-01 12:52:23","updated_at":"2018-01-04 11:42:07","status":"1","admin_users_id":"0"},{"id":"43","name":"555","link":"","maximum_amount":"3","minimum_amount":"21","interest_algorithm":"日利率","min_cycle":"12","max_cycle":"213","min_algorithm":"1.000","max_algorithm":"2.000","crowd":"问天网","fee":"2323","prepayment":"一次性还清","passing_rate":"","index_type1":"9999","index_type2":"9999","fastest_type":"天","fastest":"2","product_logo":"http://or2eh71ll.bkt.clouddn.com/151618183772537.jpg?e=1516185437&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:Qvd4Y_LcM72B06deI3ykQbFzUWk=","product_introduction":"访问","product_details":"是的","created_at":"2018-01-17 17:37:17","updated_at":"2018-01-17 18:35:39","status":"1","admin_users_id":"1"},{"id":"22","name":"沃尔得十分","link":"asdas","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"999","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/150936067844413.png?e=1509364279&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:UQKczbc1DKWldgSkVQKjKBuJQd4=","product_introduction":"撒地方","product_details":"123","created_at":"1970-01-02 00:00:00","updated_at":"2018-01-02 11:08:29","status":"1","admin_users_id":"0"},{"id":"14","name":"用钱宝","link":"http://www.yongqianbao.com/wr/launch-register?c=329","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"140","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760705756398.png?e=1497610657&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:kKGKKyJ_pe2qHzQ67ZZbjwyw2AM=","product_introduction":"想不想试试，30分钟拿到钱","product_details":"18-40周岁非学生群体aaa持本人身份证（临时身份证不可以），本人身份证办理的手机号aaa千元现金借款，最快30分钟到账","created_at":"2017-06-16 17:57:37","updated_at":"2018-01-02 11:07:55","status":"1","admin_users_id":"0"},{"id":"13","name":"小赢卡贷","link":"https://cardloan.xiaoying.com/kadaicredit/index?source=10000328","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"130","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760669746429.png?e=1497610297&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:wYTcdfmH82QgSq1C-JVs46RYpAE=","product_introduction":"信用卡快速还款，当天到账","product_details":"20周岁以上,本人手机实名认证。aaa信用卡持有一年以上。aaa主要用于信用卡快速还款，需要简版征信，黑名单禁入","created_at":"2017-06-16 17:51:37","updated_at":"2018-01-02 11:07:53","status":"1","admin_users_id":"0"},{"id":"12","name":"2个标签","link":"http://www.niwodai.com/index.do?method=ac&artId=3800001233858290&nwd_ext_aid=3000001999611263&source_id=","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"120","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/150874286284930.jpg?e=1508746462&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:G0cReg7pDF-rimfw7KO7Eq64msI=","product_introduction":"当天下款，件均13000元","product_details":"22-40岁aaa有信用卡aaa你我贷主要授权项包括身份证，运营商授权","created_at":"2017-06-16 17:46:03","updated_at":"2018-01-02 11:07:52","status":"1","admin_users_id":"0"},{"id":"11","name":"现金巴士","link":"https://weixin.cashbus.com/#/events/promo/7104","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"110","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"HTTP/1.0 302 Found\r\nCache-Control: no-cache\r\nDate:          Mon, 23 Oct 2017 07:20:25 GMT\r\nLocation:      https://test.admin.anwenqianbao.com/product/editt/11\r\n\r\n<!DOCTYPE html>\n<html>\n    <head>\n        <meta charset=\"UTF-8\" />\n        <meta http-equiv=\"","product_introduction":"小额短期，无限循环","product_details":"身份证aaa手机号aaa现金巴士最牛的特点就是可无限期延期，只需要还清本期费用，就可以马上循环贷","created_at":"2017-06-16 17:41:42","updated_at":"2018-01-02 11:07:50","status":"1","admin_users_id":"0"},{"id":"10","name":"小花钱包","link":"https://www.xhqb.com/m/bfpp.html?appChannel=xinh01","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"100","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760543558230.png?e=1497609035&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:Vd-w-W3TMgdHCYHb33afGJ6VLuY=","product_introduction":"最快3分钟，件均5500元","product_details":"20-40岁的在职员工aaa本人2代身份证aaa身份证扫描一定要多试，扫描成功","created_at":"2017-06-16 17:30:35","updated_at":"2018-01-02 11:07:45","status":"1","admin_users_id":"0"},{"id":"9","name":"借钱快","link":"https://www.jie518.com/web/invitation/wm-register?channel=xjd4&utm_source=xjd4&utm_medium=cps&utm_campaign=xjd410017","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"90","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760511382844.png?e=1497608713&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:gANDnnevTanc-Iv7RXZ5at0UVj0=","product_introduction":"身份证借款，最快5分钟到账","product_details":"身份证aaa手机号aaa近期放款成功率高","created_at":"2017-06-16 17:25:13","updated_at":"2018-01-02 11:07:42","status":"1","admin_users_id":"0"},{"id":"8","name":"身份贷","link":"http://m.rong360.com/express?from=sem21&utm_source=xinhe&utm_medium=dk&utm_campaign=app","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"80","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760482120714.png?e=1497608421&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:J3Z49qce4EjBUc68IUcy7RVT0Vw=","product_introduction":"借款额度范围大，类型齐全","product_details":"身份证号aaa手机号aaa填写身份证及手机号，客服人员将在24小时之内进行电话初步审核","created_at":"2017-06-16 17:20:21","updated_at":"2018-01-02 11:07:37","status":"1","admin_users_id":"0"},{"id":"7","name":"闪银","link":"http://m.wecash.net/wep/share/simple_h5.html?version=h5&channelId=3798&channelCode=11459a","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"70","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760444187890.png?e=1497608041&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:4U1aG8qtSVWeWgYIFPq7_X5powI=","product_introduction":"11月免息借钱，现金10分钟到账","product_details":"手机实名认证，使用超过4个月aaa淘宝/京东有消费记录aaa手机号使用和淘宝京东消费记录不足半年的不容易下款","created_at":"2017-06-16 17:14:01","updated_at":"2018-01-02 11:07:34","status":"1","admin_users_id":"0"},{"id":"6","name":"快易花","link":"https://www.99bill.com/seashell/html/activity/161125_kyhcach_mm/default.html?datasrc=link142","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"60","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760429460887.png?e=1497607894&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:5fkR3hkkrWc1EDSOFlVsd5_26Eo=","product_introduction":"万达快钱贷-轻松秒批50000额度","product_details":"年龄20~60周岁，信用记录良好aaa具有有效的身份证明，稳定的工作和收入来源aaa还款方式：分期还款（西藏、新疆不可申请）","created_at":"2017-06-16 17:11:34","updated_at":"2018-01-02 11:07:32","status":"1","admin_users_id":"0"},{"id":"2","name":"douping","link":"http://m.haomoney.com/activity/reg/register.html?utm_source=wap_xianjindai","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"20","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760072876192.jpeg?e=1497604328&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:RZDt5XjBM3b82h1jpE-UOX1W56A=","product_introduction":"1000~10000门槛低、快速到账、额度灵活","product_details":"实名认证、基本信息、手机授权\\n大额需芝麻信用等\\n支持部分还款、提前还款、有人行征信报告可提额","created_at":"2017-06-16 16:12:08","updated_at":"2018-01-02 11:07:18","status":"1","admin_users_id":"0"},{"id":"15","name":"手机贷","link":"https://m.shoujidai.com/?channel=xianjindai03-llcs","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"12","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/149760730533351.png?e=1497610905&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:bT5QXl6sG3OLZ7BWIs2-CCMN7RU=","product_introduction":"费用超级低，要借钱快点来","product_details":"手机实名认证aaa电商认证，淘宝或京东都可以aaa21天借款时间特别适合工薪族的用款需求","created_at":"2017-06-16 18:01:45","updated_at":"2018-01-02 11:07:57","status":"1","admin_users_id":"0"},{"id":"1","name":"米米贷","link":"http://www.mimidai.com/expand/xjdslj2","maximum_amount":"0","minimum_amount":"0","interest_algorithm":"日利率","min_cycle":"0","max_cycle":"0","min_algorithm":"0.000","max_algorithm":"0.000","crowd":"","fee":"","prepayment":"一次性还清","passing_rate":"","index_type1":"10","index_type2":"9999","fastest_type":"秒","fastest":"","product_logo":"http://or2eh71ll.bkt.clouddn.com/150874445076409.jpg?e=1508748050&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:4ZnZCgQcWFRdbVi1lGuGlQ3pJBA=","product_introduction":"","product_details":"1.身份证、18岁以上公民、非苹果系统用户\r\n2.身份证 、银行卡、 运营商验证\r\n3.米米贷要求填写的信息必须真实\r\n4.wme ","created_at":"2017-06-16 16:07:19","updated_at":"2018-01-02 11:07:17","status":"1","admin_users_id":"0"}]
     * error_code : 0
     * error_message :
     * time : 2018-01-18 12:24:18
     */

    private int code;
    private int message;
    private int error_code;
    private String error_message;
    private String time;
    private List<DataBean> data;

    protected Product(Parcel in) {
        code = in.readInt();
        message = in.readInt();
        error_code = in.readInt();
        error_message = in.readString();
        time = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeInt(message);
        parcel.writeInt(error_code);
        parcel.writeString(error_message);
        parcel.writeString(time);
    }

    public static class DataBean implements Parcelable{
        /**
         * id : 41
         * name : 请问
         * link :
         * maximum_amount : 0
         * minimum_amount : 0
         * interest_algorithm : 日利率
         * min_cycle : 0
         * max_cycle : 0
         * min_algorithm : 0.000
         * max_algorithm : 0.000
         * crowd :
         * fee :
         * prepayment : 一次性还清
         * passing_rate :
         * index_type1 : 9999
         * index_type2 : 9999
         * fastest_type : 秒
         * fastest :
         * product_logo : http://or2eh71ll.bkt.clouddn.com/151210393297018.png?e=1512107543&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:15XE3vd-lwyIpkJ2O3POyxMIz8c=
         * product_introduction : 请问
         * product_details :
         * created_at : 2017-12-01 12:52:23
         * updated_at : 2018-01-04 11:42:07
         * status : 1
         * admin_users_id : 0
         */

        private String id;
        private String name;
        private String link;
        private String maximum_amount;
        private String minimum_amount;
        private String interest_algorithm;
        private String min_cycle;
        private String max_cycle;
        private String min_algorithm;
        private String max_algorithm;
        private String crowd;
        private String fee;
        private String prepayment;
        private String passing_rate;
        private String index_type1;
        private String index_type2;
        private String fastest_type;
        private String fastest;
        private String product_logo;
        private String product_introduction;
        private String product_details;
        private String created_at;
        private String updated_at;
        private String status;
        private String admin_users_id;

        protected DataBean(Parcel in) {
            id = in.readString();
            name = in.readString();
            link = in.readString();
            maximum_amount = in.readString();
            minimum_amount = in.readString();
            interest_algorithm = in.readString();
            min_cycle = in.readString();
            max_cycle = in.readString();
            min_algorithm = in.readString();
            max_algorithm = in.readString();
            crowd = in.readString();
            fee = in.readString();
            prepayment = in.readString();
            passing_rate = in.readString();
            index_type1 = in.readString();
            index_type2 = in.readString();
            fastest_type = in.readString();
            fastest = in.readString();
            product_logo = in.readString();
            product_introduction = in.readString();
            product_details = in.readString();
            created_at = in.readString();
            updated_at = in.readString();
            status = in.readString();
            admin_users_id = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getMaximum_amount() {
            return maximum_amount;
        }

        public void setMaximum_amount(String maximum_amount) {
            this.maximum_amount = maximum_amount;
        }

        public String getMinimum_amount() {
            return minimum_amount;
        }

        public void setMinimum_amount(String minimum_amount) {
            this.minimum_amount = minimum_amount;
        }

        public String getInterest_algorithm() {
            return interest_algorithm;
        }

        public void setInterest_algorithm(String interest_algorithm) {
            this.interest_algorithm = interest_algorithm;
        }

        public String getMin_cycle() {
            return min_cycle;
        }

        public void setMin_cycle(String min_cycle) {
            this.min_cycle = min_cycle;
        }

        public String getMax_cycle() {
            return max_cycle;
        }

        public void setMax_cycle(String max_cycle) {
            this.max_cycle = max_cycle;
        }

        public String getMin_algorithm() {
            return min_algorithm;
        }

        public void setMin_algorithm(String min_algorithm) {
            this.min_algorithm = min_algorithm;
        }

        public String getMax_algorithm() {
            return max_algorithm;
        }

        public void setMax_algorithm(String max_algorithm) {
            this.max_algorithm = max_algorithm;
        }

        public String getCrowd() {
            return crowd;
        }

        public void setCrowd(String crowd) {
            this.crowd = crowd;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getPrepayment() {
            return prepayment;
        }

        public void setPrepayment(String prepayment) {
            this.prepayment = prepayment;
        }

        public String getPassing_rate() {
            return passing_rate;
        }

        public void setPassing_rate(String passing_rate) {
            this.passing_rate = passing_rate;
        }

        public String getIndex_type1() {
            return index_type1;
        }

        public void setIndex_type1(String index_type1) {
            this.index_type1 = index_type1;
        }

        public String getIndex_type2() {
            return index_type2;
        }

        public void setIndex_type2(String index_type2) {
            this.index_type2 = index_type2;
        }

        public String getFastest_type() {
            return fastest_type;
        }

        public void setFastest_type(String fastest_type) {
            this.fastest_type = fastest_type;
        }

        public String getFastest() {
            return fastest;
        }

        public void setFastest(String fastest) {
            this.fastest = fastest;
        }

        public String getProduct_logo() {
            return product_logo;
        }

        public void setProduct_logo(String product_logo) {
            this.product_logo = product_logo;
        }

        public String getProduct_introduction() {
            return product_introduction;
        }

        public void setProduct_introduction(String product_introduction) {
            this.product_introduction = product_introduction;
        }

        public String getProduct_details() {
            return product_details;
        }

        public void setProduct_details(String product_details) {
            this.product_details = product_details;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdmin_users_id() {
            return admin_users_id;
        }

        public void setAdmin_users_id(String admin_users_id) {
            this.admin_users_id = admin_users_id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(name);
            parcel.writeString(link);
            parcel.writeString(maximum_amount);
            parcel.writeString(minimum_amount);
            parcel.writeString(interest_algorithm);
            parcel.writeString(min_cycle);
            parcel.writeString(max_cycle);
            parcel.writeString(min_algorithm);
            parcel.writeString(max_algorithm);
            parcel.writeString(crowd);
            parcel.writeString(fee);
            parcel.writeString(prepayment);
            parcel.writeString(passing_rate);
            parcel.writeString(index_type1);
            parcel.writeString(index_type2);
            parcel.writeString(fastest_type);
            parcel.writeString(fastest);
            parcel.writeString(product_logo);
            parcel.writeString(product_introduction);
            parcel.writeString(product_details);
            parcel.writeString(created_at);
            parcel.writeString(updated_at);
            parcel.writeString(status);
            parcel.writeString(admin_users_id);
        }
    }
}