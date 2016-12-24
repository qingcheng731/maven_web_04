package org.lanqiao.dao.mapper;

import java.util.List;

import org.lanqiao.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMapper {
    public List<Emp> selectEmp();
}
