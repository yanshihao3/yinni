package com.ayo.pinjam.bean;

/**
 * Created by yanshihao on 2018/1/17.
 */

public class LoginInfo {

    /**
     * code : 200
     * message :
     * data : {"is_user":1,"token":"token值"}
     * error_code : 0
     * error_message :
     * time : 2017-08-18 15:24:09
     */

    private int code;
    private String message;
    private DataBean data;
    private int error_code;
    private String error_message;
    private String time;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "LoginInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", error_code=" + error_code +
                ", error_message='" + error_message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * is_user : 1
         * token : token值
         */

        private int is_user;
        private String token;

        public int getIs_user() {
            return is_user;
        }

        public void setIs_user(int is_user) {
            this.is_user = is_user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "is_user=" + is_user +
                    ", token='" + token + '\'' +
                    '}';
        }
    }
}
