package org.lanqiao.dao.mapper;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.entity.Condition;
import org.lanqiao.entity.Majornote;
import org.springframework.stereotype.Repository;

@Repository
public interface MajornoteMapper {
    public List<Majornote> findAllNote(Condition condition);
    public List<Majornote> findAllNote2();
    public List<HashMap<String,String>> findAllNote3();
    public void addMajornote(Majornote majornote);
    public void addMajornote2(Majornote majornote);
    public void deleteNotes(String[] id);
    public List<HashMap> findNoteAndReplyById(int id);
    public void addNote(Majornote majornote);
    
    public List<Majornote> findNoteByIds(String[] ids);
}
