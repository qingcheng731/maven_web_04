package org.lanqiao.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.mapper.MajornoteMapper;
import org.lanqiao.dao.mapper.ReplynoteMapper;
import org.lanqiao.entity.Condition;
import org.lanqiao.entity.Majornote;
import org.lanqiao.entity.Replynote;
import org.lanqiao.util.JdbcMybatisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteServiceImpl {
    /**
     * @Description 查询全部的主题帖
     * @return
     */
    @Autowired
    private MajornoteMapper majornoteMapper;
    @Autowired
    private ReplynoteMapper replynoteMapper;
    public List<Majornote> findAllNote(Condition condition){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        List<Majornote> list = majornoteMapper.findAllNote(condition);
//        session.close();
        return list;
    }
    public List<Majornote> findAllNote2(){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        List<Majornote> list = majornoteMapper.findAllNote2();
//        session.close();
        return list;
    }
    
    public List<Replynote> findAllReplyById(int id){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        ReplynoteMapper replynoteMapper = session.getMapper(ReplynoteMapper.class);
        List<Replynote> list = replynoteMapper.findAllReplyById(id);
        return list;
        
    }
    
    @Transactional
    public void deleteNotes(String[] id){
        List<Majornote> list = majornoteMapper.findNoteByIds(id);
        for(int i=0;i<list.size();i++){
            majornoteMapper.addMajornote2(list.get(i));
        }
        majornoteMapper.deleteNotes(id);
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
//        session.commit();
//        session.close();
    }
    
    public List<HashMap> findNoteAndReplyById(int id){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        return majornoteMapper.findNoteAndReplyById(id);
    }
    
    public void addReply(Replynote replynote){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        ReplynoteMapper replynoteMapper = session.getMapper(ReplynoteMapper.class);
        replynoteMapper.addReply(replynote);
//        session.commit();
//        session.close();
    }
    
    public void addNote(Majornote majornote){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        majornoteMapper.addNote(majornote);
//        session.commit();
//        session.close();
    }
    public void addMajornote2(Majornote majornote){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        majornoteMapper.addMajornote2(majornote);
//        session.commit();
//        session.close();
    }
    
    public void addCount(int id,int count){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        ReplynoteMapper replynoteMapper = session.getMapper(ReplynoteMapper.class);
        replynoteMapper.addCount(id, count);
//        session.commit();
//        session.close();
    }
    
    public int getCountById(int id){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        ReplynoteMapper replynoteMapper = session.getMapper(ReplynoteMapper.class);
        int retuid = replynoteMapper.getCountById(id);
//        session.commit();
//        session.close();
        
        return retuid;
    }
    
    public List<Majornote> findNoteByIds(String[] ids){
//        SqlSession session = JdbcMybatisUtils.getSession();
//        MajornoteMapper majornoteMapper = session.getMapper(MajornoteMapper.class);
        return majornoteMapper.findNoteByIds(ids);
    }
    
}
