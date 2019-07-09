package com.yulong.pojo;

/**
 * @program: testSSM
 * @description: 描述用户的实体类
 * @author: Dragon
 * @create: 2019-06-27 17:06
 */
public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String grade;
    private int usertype;
    private int userstate;
    private String email;
    private String telephone;
    private String address;
    private String remark;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getUserstate() {
        return userstate;
    }

    public void setUserstate(int userstate) {
        this.userstate = userstate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", grade='" + grade + '\'' +
                ", usertype=" + usertype +
                ", userstate=" + userstate +
                ", email='" + email + '\'' +
                ", telepone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
