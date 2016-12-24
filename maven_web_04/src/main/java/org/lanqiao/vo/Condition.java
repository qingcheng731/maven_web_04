package org.lanqiao.vo;


public class Condition {
    private String username;
    private String email;
    private String tel;
    private String deptname;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public String getDeptname() {
        return deptname;
    }
    
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Condition [username=" + username + ", email=" + email + ", tel=" + tel + ", deptname=" + deptname + "]";
    }
    
}
