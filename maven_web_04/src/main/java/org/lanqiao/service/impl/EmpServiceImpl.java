//package org.lanqiao.service.impl;
//
//import java.util.List;
//
//import org.lanqiao.entity.Dept;
//import org.lanqiao.entity.Emp;
//import org.lanqiao.vo.Condition;
//import org.lanqiao.vo.EmpVo;
//import org.lanqiao.vo.PageData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmpServiceImpl {
//    
//    @Autowired
//    EmpDaoImpl empDaoImpl ;
//    public List<EmpVo> findAll() throws Exception{
//        
//        return empDaoImpl.findAll();
//    }
//    
//    public void addEmp(Emp emp) throws Exception{
//        empDaoImpl.addEmp(emp);
//    }
//    
//    public void deleteById(Integer id) throws Exception{
//        empDaoImpl.deleteById(id);
//    }
//    
//    public List<Dept> findDepts() throws Exception{
//       return empDaoImpl.findDepts();
//    }
//    
//    public PageData<EmpVo> findAllByPagination(int pagesize,int pageindex) throws Exception{
//        return empDaoImpl.findAllByPagination(pagesize, pageindex);
//    }
//    
//    public PageData<EmpVo> findAllByPagination_condition(Condition condition,int pagesize,int pageindex) throws Exception{
//        return empDaoImpl.findAllByPagination_condition(condition, pagesize, pageindex);
//    }
//}
