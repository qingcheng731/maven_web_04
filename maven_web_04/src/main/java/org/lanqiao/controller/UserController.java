//package org.lanqiao.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.lanqiao.entity.Dept;
//import org.lanqiao.entity.Emp;
//import org.lanqiao.entity.User;
//import org.lanqiao.service.impl.EmpServiceImpl;
//import org.lanqiao.vo.Condition;
//import org.lanqiao.vo.EmpVo;
//import org.lanqiao.vo.PageData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.google.gson.Gson;
//
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    
//    @Autowired
//    EmpServiceImpl empServiceImpl ;
//    @RequestMapping("/findUser")
//    public String findUser(HttpServletRequest request,HttpSession session,Model model){
//        List<EmpVo> list = null;
//        try {
//            list = empServiceImpl.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(list != null){
//            model.addAttribute("lists", list);
//        }
//        
//        
//        return "main";
//    }
//    @RequestMapping("/findUserByPagination")
//    public String findUserByPagination(Integer cpage,HttpServletRequest request,HttpSession session,Model model){
//        
//        PageData<EmpVo> pd = null;
//        try {
//            if(cpage==null){
//                cpage=1;
//            }
//            pd = empServiceImpl.findAllByPagination(5,cpage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(pd != null){
//            model.addAttribute("pd", pd);
//        }
//        
//        
//        return "main1";
//    }
//    
//    
//    @RequestMapping("/ajaxFindUser")
//    @ResponseBody
//    public Object ajaxFindUser(Model model){
//        List<EmpVo> list = null;
//        try {
//            list = empServiceImpl.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    @RequestMapping(value="/ajaxFindDepts",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public Object ajaxFindDepts() throws Exception{
//        System.out.println("ajaxFindDepts");
//        List<Dept> list = empServiceImpl.findDepts();
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        return json;
//    }
//    
//    @RequestMapping("/validUsername")
//    @ResponseBody
//    public Object validUsername(String param){
//        
//        System.out.println("/validUsername");
//        System.out.println(param);
//        
//        // {"info": "demo info","status": "y"}
////        return    "y";
//        return "  {  \"info\": \"此用户名可以使用\",\"status\": \"y\"}  ";
//    }
//    /**
//     * 
//     * @Description 添加雇员
//     * @param uplodFile
//     * @param selectDept
//     * @param model
//     * @param username
//     * @param tel
//     * @param email
//     * @param deptName
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value="/addEmp")
//    public String addEmp(Integer cpage ,HttpServletRequest request,@RequestParam MultipartFile[]  uplodFile,Integer selectDept,Model model,String username,String tel,String email,String deptName) throws Exception{
//        //处理头像文件的
//        String   fullpath = null;
//        if(uplodFile!=null){
//            //获取容器所在的绝对路径
//            String webpath  = "file:\\"+request.getServletContext().getRealPath("/");
//            File  file=new File(webpath+"/upload/");
//            if(!file.exists()){
//                file.mkdir();
//            }
//            for(int i=0;i<uplodFile.length;i++){
//                String filename =uplodFile[i].getOriginalFilename();
//                //更换名称  时间字符串  作为  新的文件名字
//                fullpath = filename;
//                File  imagefile=new File(webpath+"/upload/"+filename);
//                try {
//                    uplodFile[i].transferTo(imagefile);
//                } catch (IllegalStateException | IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        
//        Emp emp = new Emp();
//        if(fullpath!=null){
//            emp.setImgurl(fullpath);
//        }
//        emp.setDeptid(selectDept);
//        emp.setEmail(email);
//        emp.setName(username);
//        emp.setTelphone(tel);
//        emp.setRegdate(new Date());
//        
//        empServiceImpl.addEmp(emp);
//        
//        PageData<EmpVo> pd = null;
//        try {
//            if(cpage==null){
//                cpage=1;
//            }
//            pd = empServiceImpl.findAllByPagination(5,cpage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(pd != null){
//            model.addAttribute("pd", pd);
//        }
//        
//        return "main1";
//    }
//    @RequestMapping(value="/deleteUser")
//    public Object deleteUser(Integer cpage,Integer id,Model model) throws Exception{
//       System.out.println("deleteUser");
//       empServiceImpl.deleteById(id);
//      
//       //重新把数据传过去
//       PageData<EmpVo> pd = null;
//       try {
//           if(cpage==null){
//               cpage=1;
//           }
//           pd = empServiceImpl.findAllByPagination(5,cpage);
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//       if(pd != null){
//           model.addAttribute("pd", pd);
//       }
//       
//       
//        return "main1";
//    }
//    @RequestMapping(value="/updateUser")
//    public Object updateUser() throws Exception{
//        System.out.println("updateUser");
//        
//        return "main";
//    }
//    
//    @RequestMapping(value="/page")
//    public String  page(String cpage,Model model) throws Exception{
//        if(cpage==null){
//            cpage="1";
//        }
//        
//        model.addAttribute("cpage", Integer.parseInt(cpage));
//        return "main";
//    }
//    
//    /**
//     * 添加一个雇员 （头像）
//     * @param emp
//     * @param uplodFile
//     * @return
//     */
//    @RequestMapping("/addupload")
//    public  String   addUpload(Emp emp, @RequestParam MultipartFile[]  uplodFile,HttpServletRequest request){
//        //插入数据库 Emp
//        if(uplodFile!=null){
//            //获取容器所在的绝对路径
//            String   webpath  = request.getServletContext().getRealPath("/");
//            System.out.println("webpath:"+webpath);
//            File  file=new File(webpath+"/upload/");
//            if(!file.exists()){
//                file.mkdir();
//            }
//            //设置一个数组装  图片
//            List<String> images=new  ArrayList<String>();
//            
//            for(int i=0;i<uplodFile.length;i++){
//                String filename =uplodFile[i].getOriginalFilename();
//                //更换名称  时间字符串  作为  新的文件名字
//                File  imagefile=new File(webpath+"/upload/"+filename);
//                try {
//                    uplodFile[i].transferTo(imagefile);
//                    images.add("upload/"+filename);
//                } catch (IllegalStateException | IOException e) {
//                    e.printStackTrace();
//                }
//                
//            }
//            // 把文件的名称或者是新名称  插入到数据库
//            request.setAttribute("images", images);
//        }
//        return "main2";
//    }
//    /**
//     * 
//     * @Description 使用ajax上传文件
//     * @param emp
//     * @param uplodFile
//     * @param request
//     * @return
//     */
//    @RequestMapping("/ajaxUpload")
//    @ResponseBody
//    public  Object ajaxUpload(Emp  emp, @RequestParam MultipartFile[]  uplodFile,HttpServletRequest request){
//        //插入数据库 Emp
//        if(uplodFile!=null){
//            //获取容器所在的绝对路径
//            String   webpath  = request.getServletContext().getRealPath("/");
//            System.out.println("webpath:"+webpath);
//            File  file=new File(webpath+"/upload/");
//            if(!file.exists()){
//                file.mkdir();
//            }
//            //设置一个数组装  图片
//            List<String> images=new  ArrayList<String>();
//            
//            for(int i=0;i<uplodFile.length;i++){
//                String filename =uplodFile[i].getOriginalFilename();
//                //更换名称  时间字符串  作为  新的文件名字
//                File  imagefile=new File(webpath+"/upload/"+filename);
//                try {
//                    uplodFile[i].transferTo(imagefile);
//                    images.add("upload/"+filename);
//                } catch (IllegalStateException | IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 把文件的名称或者是新名称  插入到数据库
//            request.setAttribute("images", images);
//        }
//        //String json = {"info":"success"}
//        return " {\"info\":\"success\"} ";
//    }
//    
//    @RequestMapping("/advancedSearch")
//    public String advancedSearch(Model model,@RequestParam(defaultValue="1")Integer cpage, String name,String email,String tel,String deptname) throws Exception{
//        System.out.println("advancedSearch");
//        
//        Condition condition = new Condition();
//        
//        if(name !=null &&email !=null&&tel !=null&&deptname !=null ){
//            
//            if(!"".equalsIgnoreCase(name.trim())||!"".equalsIgnoreCase(email.trim())
//                    ||!"".equalsIgnoreCase(tel.trim())||!"".equalsIgnoreCase(deptname.trim())){
//                cpage=1;
//            }
//        }
//        if(name !=null){
//            if(!"".equalsIgnoreCase(name.trim())){
//                condition.setUsername(name);
//            }
//        }
//        if(email !=null){
//            if(!"".equalsIgnoreCase(email.trim())){
//                condition.setEmail(email);
//            }
//        }
//        if(tel !=null){
//            if(!"".equalsIgnoreCase(tel.trim())){
//                condition.setTel(tel);
//            }
//        }
//        if(deptname !=null){
//            if(!"".equalsIgnoreCase(deptname.trim())){
//                condition.setDeptname(deptname);
//            }
//        }
//        
//        PageData<EmpVo> pd = null;
//        try {
//            pd = empServiceImpl.findAllByPagination_condition(condition, 5, cpage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(pd != null){
//            model.addAttribute("pd", pd);
//        }
//        
//        return "main1";
//        //return "redirect:findUser";
//    }
//    
//    @RequestMapping("/testAjax")
//    public void testAjax(HttpServletRequest request,HttpServletResponse response) throws Exception{
//        String json = " {\"test\":\"testvalue\"} ";//{"test":"testvalue"}
//        response.getWriter().write(json);
//    }
//    
//    @RequestMapping(value="/login")
//    public String login(User user,HttpSession session){
//        if(user != null){
//            session.setAttribute("loginUser", user);
//            return "main";
//        }
//        return "login";
//    }
//}
