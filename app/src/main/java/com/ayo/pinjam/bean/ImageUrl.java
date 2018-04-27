package com.ayo.pinjam.bean;

import java.util.List;

/**
 * Created by yanshihao on 2018/1/17.
 */

public class ImageUrl {

    /**
     * code : 200
     * message :
     * data : [{"id":"1","name":"块钱","pictrue":"http://or2eh71ll.bkt.clouddn.com/149760896587611.jpg?e=1497612565&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:JtsY_HbNvx0i61EQBskQOZRAhsU=","h5":"https://www.99bill.com/seashell/html/activity/161125_kyhcach_mm/default.html?datasrc=link106","remarks":"","status":"1","admin_id":"0","created_at":"2017-06-16 10:29:25","updated_at":"2017-06-16 10:30:33"}]
     * error_code : 0
     * error_message :
     * time : 2017-08-18 15:24:09
     */

    private int code;
    private String message;
    private int error_code;
    private String error_message;
    private String time;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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
    public String toString() {
        return "ImageUrl{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", error_code=" + error_code +
                ", error_message='" + error_message + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 块钱
         * pictrue : http://or2eh71ll.bkt.clouddn.com/149760896587611.jpg?e=1497612565&token=Npg7Sanmf4z8uv3mvwwffjOvoCMYN8Ezm4T8pDrC:JtsY_HbNvx0i61EQBskQOZRAhsU=
         * h5 : https://www.99bill.com/seashell/html/activity/161125_kyhcach_mm/default.html?datasrc=link106
         * remarks :
         * status : 1
         * admin_id : 0
         * created_at : 2017-06-16 10:29:25
         * updated_at : 2017-06-16 10:30:33
         */

        private String id;
        private String name;
        private String pictrue;
        private String h5;
        private String remarks;
        private String status;
        private String admin_id;
        private String created_at;
        private String updated_at;

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

        public String getPictrue() {
            return pictrue;
        }

        public void setPictrue(String pictrue) {
            this.pictrue = pictrue;
        }

        public String getH5() {
            return h5;
        }

        public void setH5(String h5) {
            this.h5 = h5;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(String admin_id) {
            this.admin_id = admin_id;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", pictrue='" + pictrue + '\'' +
                    ", h5='" + h5 + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", status='" + status + '\'' +
                    ", admin_id='" + admin_id + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    '}';
        }
    }
}
