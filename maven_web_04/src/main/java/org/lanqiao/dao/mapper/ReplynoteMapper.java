package org.lanqiao.dao.mapper;

import java.util.List;

import org.lanqiao.entity.Replynote;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplynoteMapper {
    public List<Replynote> findAllReplyById(int id);
    public void addReply(Replynote replynote);
    public void addCount(int id,int count);
    public int getCountById(int id);
}
