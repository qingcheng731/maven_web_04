package org.lanqiao.vo;

import java.util.Date;


/**
 * 
 * create table emp(
    id int primary key auto_increment,
    mail varchar(30),
    name varchar(20),
    telphone int(11),
    deptid int,
    regdate datetime
)
 */
public class EmpVo {
    private int id;
    private String name;
    private String email;
    private String telphone;
    private Date regdate;
    private String imgurl;
    private String deptname;
    
    
    public String getImgurl() {
        return imgurl;
    }

    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelphone() {
        return telphone;
    }
    
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    
    public Date getRegdate() {
        return regdate;
    }
    
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    
    public String getDeptname() {
        return deptname;
    }
    
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    
}
