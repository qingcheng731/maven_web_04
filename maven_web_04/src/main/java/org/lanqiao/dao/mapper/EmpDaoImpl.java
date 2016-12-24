//package org.lanqiao.dao.mapper;
//
//import java.util.List;
//
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.ArrayHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import org.lanqiao.entity.Dept;
//import org.lanqiao.entity.Emp;
//import org.lanqiao.util.JdbcUtils;
//import org.lanqiao.vo.Condition;
//import org.lanqiao.vo.EmpVo;
//import org.lanqiao.vo.PageData;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class EmpDaoImpl {
//    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//    /**
//     * 
//     * @Description 查询所有记录
//     * @return
//     * @throws Exception
//     */
//    public List<EmpVo> findAll() throws Exception{
//        String sql = "select e.id,e.name,e.email,e.telphone,e.regdate,e.imgurl,d.deptname  "
//                +" from emp e,dept d "
//                +" where e.deptid=d.deptid";
//        List<EmpVo> list = qr.query(sql, new BeanListHandler<EmpVo>(EmpVo.class));
//        
//        return list;
//    }
//    
//    /**
//     * 
//     * @Description 查询记录带分页
//     * @param pagesize
//     * @param pageindex
//     * @return
//     * @throws Exception
//     */
//    public PageData<EmpVo> findAllByPagination(int pagesize,int pageindex) throws Exception{
//        PageData<EmpVo> pd = new PageData<EmpVo>();
//        String sql = "select e.id,e.name,e.email,e.telphone,e.regdate,e.imgurl,d.deptname "
//                +" from emp e,dept d "
//                +" where e.deptid=d.deptid"
//                +" limit "+(pageindex-1)*pagesize+ " , "+pagesize+" ";
//        String total_sql = "select count(*) from emp";
//        Object[] obj = qr.query(total_sql, new ArrayHandler());
//        int totalcount = Integer.parseInt(String.valueOf(obj[0]));
//        List<EmpVo> list = qr.query(sql, new BeanListHandler<EmpVo>(EmpVo.class));
//        pd.setPageindex(pageindex);
//        pd.setPagesize(pagesize);
//        pd.setTotalrecords(totalcount);
//        int pagecount = totalcount % pagesize == 0 ? totalcount / pagesize
//                : totalcount / pagesize + 1;
//        pd.setPagecount(pagecount);
//        pd.setList(list);
//        return pd;
//    }
//    /**
//     * 
//     * @Description 查询分页数据带条件
//     * @param pagesize
//     * @param pageindex
//     * @return
//     * @throws Exception
//     */
//    public PageData<EmpVo> findAllByPagination_condition(Condition condition,int pagesize,int pageindex) throws Exception{
//        PageData<EmpVo> pd = new PageData<EmpVo>();
//        StringBuffer sql = new StringBuffer();
//        sql.append( "select e.id,e.name,e.email,e.telphone,e.regdate,e.imgurl,d.deptname "
//                +" from emp e,dept d "
//                +" where e.deptid=d.deptid and 1=1 ");
//        
//        
//        StringBuffer sql_condition = new StringBuffer();
//        //sql_condition.append(" where 1=1 ");
//        if(condition.getEmail()!=null){ 
//            sql_condition.append(" and e.email like '%"+condition.getEmail()+"%' ");
//        }
//        if(condition.getTel()!=null){
//            sql_condition.append(" and e.telphone like '%"+condition.getTel()+"%' ");
//        }
//        if(condition.getUsername()!=null){
//            sql_condition.append(" and e.name like '%"+condition.getUsername()+"%' ");
//        }
//        if(condition.getDeptname()!=null){
//            sql_condition.append(" and d.deptname like '%"+condition.getDeptname()+"%' ");
//        }
//        sql.append(sql_condition.toString());
//        String sql_limit = " limit "+(pageindex-1)*pagesize+ " , "+pagesize+" ";
//        
//        sql.append(sql_limit);
//        
//        String total_sql = "select count(*) from emp e,dept d where e.deptid=d.deptid and 1=1 "+sql_condition.toString();
//        Object[] obj = qr.query(total_sql, new ArrayHandler());
//        int totalcount = Integer.parseInt(String.valueOf(obj[0]));
//        List<EmpVo> list = qr.query(sql.toString(), new BeanListHandler<EmpVo>(EmpVo.class));
//        pd.setPageindex(pageindex);
//        pd.setPagesize(pagesize);
//        pd.setTotalrecords(totalcount);
//        int pagecount = totalcount % pagesize == 0 ? totalcount / pagesize
//                : totalcount / pagesize + 1;
//        pd.setPagecount(pagecount);
//        pd.setList(list);
//        return pd;
//    }
//    
//    
//    public void addEmp(Emp emp) throws Exception{
//        String sql = "insert into emp(email,name,telphone,deptid,regdate,imgurl) values(?,?,?,?,?,?)";
//        qr.update(sql, emp.getEmail(),emp.getName(),emp.getTelphone(),emp.getDeptid(),emp.getRegdate(),emp.getImgurl());
//    }
//    
//    public void deleteById(Integer id) throws Exception{
//        String sql = "delete from emp where id=?";
//        qr.update(sql,id);
//    }
//    
//    public List<Dept> findDepts() throws Exception{
//        
//        String sql = "select deptid,deptname from dept";
//        
//        List<Dept> list = qr.query(sql, new BeanListHandler<Dept>(Dept.class));
//        
//        return list;
//    }
//    public void addDept(Dept dept) throws Exception{
//        
//        String sql = "insert into dept(deptid,deptname) values(?,?)";
//        
//        qr.update(sql, dept.getDeptid(),dept.getDeptname());
//        
//    }
//    
//    public Object[] testArrayListHandler() throws Exception{
//        
//        String total_sql = "select count(*) from emp";
//        
//        Object[] obj = qr.query(total_sql, new ArrayHandler());
//        
//        return obj;
//    }
//    
//}
