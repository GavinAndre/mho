package com.java.gavinandre.pojo;

/**
 * Created by gavinandre on 17-1-12.
 */
public class UserModel extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 5715947400419117755L;
    //登录名
    private String userName;
    //真实姓名
    private String realName;
    //密码
    private String userPwd;

    private String phoneNum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
