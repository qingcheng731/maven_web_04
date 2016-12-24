package org.lanqiao.entity;

import java.util.Date;

public class Emp {
    private Dept dept;
    private int deptid;
    private String email;
    private int id;
    private String imgurl;
    private String name;
    private Date regdate;
    private String telphone;
    
    
    public Dept getDept() {
        return dept;
    }


    
    public int getDeptid() {
        return deptid;
    }


    public String getEmail() {
        return email;
    }

    
    public int getId() {
        return id;
    }

    public String getImgurl() {
        return imgurl;
    }
    
    public String getName() {
        return name;
    }
    
    public Date getRegdate() {
        return regdate;
    }
    
    public String getTelphone() {
        return telphone;
    }
    
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    
    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    
}
