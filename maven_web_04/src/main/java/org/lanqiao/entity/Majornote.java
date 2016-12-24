package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

/**
 * 
 * create table majornote(
    id int primary key auto_increment,
    majornote_title text not null,
    majornote_author varchar(50) not null,
    majornote_publishtime datetime not null,
    majornote_content text
    )
 */
public class Majornote {
    private int id;
    private String title;
    private String author;
    private Date publishtime;
    private String content;
    private List<Replynote> replys;
    
    public List<Replynote> getReplys() {
        return replys;
    }
    
    public void setReplys(List<Replynote> replys) {
        this.replys = replys;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Date getPublishtime() {
        return publishtime;
    }
    
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
