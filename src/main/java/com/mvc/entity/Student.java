package com.mvc.entity;

public class Student {
    private int sid;
    private String sname;
    private String sex;
    private String phone;

    public Student() {
    }

    public Student( String sname, String sex, String phone) {
        this.sname = sname;
        this.sex = sex;
        this.phone = phone;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
