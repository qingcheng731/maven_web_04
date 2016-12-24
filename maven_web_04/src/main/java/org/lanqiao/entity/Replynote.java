package org.lanqiao.entity;

import java.util.Date;

/**
 * create table replynote(
    id int primary key auto_increment,
    replynote_username varchar(50),
    replynote_content text,
    replynote_replytime datetime,
    replynote_majornote_id int
    )
 */
public class Replynote {
    private int id;
    private String username;
    private String content;
    private Date replytime;
    private Majornote majornote;
    private int majornoteid;
    private int majornotecount;
    
    public int getMajornotecount() {
        return majornotecount;
    }



    
    public void setMajornotecount(int majornotecount) {
        this.majornotecount = majornotecount;
    }



    public int getMajornoteid() {
        return majornoteid;
    }


    
    public void setMajornoteid(int majornoteid) {
        this.majornoteid = majornoteid;
    }


    public Majornote getMajornote() {
        return majornote;
    }

    
    public void setMajornote(Majornote majornote) {
        this.majornote = majornote;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getReplytime() {
        return replytime;
    }
    
    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}
