package org.lanqiao.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lanqiao.entity.Condition;
import org.lanqiao.entity.Majornote;
import org.lanqiao.entity.Replynote;
import org.lanqiao.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoteController {
    int i = 1;
    @Autowired
    private NoteServiceImpl noteServiceImpl ;
    
    @RequestMapping("/findAllNote")
    public String findAllNote(Model model,HttpServletRequest request){
        String  title = request.getParameter("title");
        String  author = request.getParameter("author");
        String  content = request.getParameter("content");
        String  time_start = request.getParameter("time_start");
        String  time_end = request.getParameter("time_end");
        //Majornote majornote = new Majornote();
        Condition condition = new Condition();
        if("".equals(title)){
            condition.setTitle(null);
        }else{
            condition.setTitle(title);
        }
        if("".equals(author)){
            condition.setAuthor(null);
        }else{
            condition.setAuthor(author);
        }
        if("".equals(content)){
            condition.setContent(null);
        }else{
            condition.setContent(content);
        }
        if("".equals(time_start)){
            condition.setTime_start(null);
        }else{
            condition.setTime_start(time_start);
        }
        if("".equals(time_end)){
            condition.setTime_end(null);
        }else{
            condition.setTime_end(time_end);
        }
        List<Majornote> list = noteServiceImpl.findAllNote(condition);
        model.addAttribute("majorlists", list);
        
        return "note";
    }
    
/*    @RequestMapping(value="/findAllReplyById",produces="text/html;charset=UTF-8")
    @ResponseBody
    public Object findAllReplyById(Integer id){
        System.out.println("findAllReplyById");
        List<Replynote> list = noteServiceImpl.findAllReplyById(id);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        
        return json;
    }*/
    @RequestMapping(value="/findAllReplyById")
    public String findAllReplyById(Integer id,Model model){
        System.out.println("findAllReplyById");
        List<Replynote> list = noteServiceImpl.findAllReplyById(id);
        model.addAttribute("lists", list);
        
        return "reply";
    }
    @RequestMapping(value="/findNoteAndReplyById")
    public String findNoteAndReplyById(Integer id,Model model){
        System.out.println("findAllReplyById");
        List<HashMap> list = noteServiceImpl.findNoteAndReplyById(id);
        model.addAttribute("lists", list);
        model.addAttribute("id", id);
        
        return "reply";
    }
    @RequestMapping("/addReply")
    public String addReply(String content,Integer id,Model model){
        //向数据库插入回复内容
        Replynote replynote = new Replynote();
        replynote.setContent(content);
        replynote.setReplytime(new Date());
        replynote.setMajornoteid(id);
        replynote.setUsername("路人"+i);
        noteServiceImpl.addReply(replynote);
        
        //添加完后把数据返回
        List<HashMap> list = noteServiceImpl.findNoteAndReplyById(id);
        model.addAttribute("lists", list);
        model.addAttribute("id", id);
        
        return "reply";
    }
    
    @RequestMapping(value="/deleteNotes",produces="text/html;charset=utf-8")
    @ResponseBody
    public Object deleteNotes(String[] ids){
        noteServiceImpl.deleteNotes(ids);
        System.out.println(ids);
        return "删除成功";
    }
    
    @RequestMapping("/addNote")
    public String addNote(Majornote majornote){
        
        majornote.setAuthor("恩泽瑞尔");
        majornote.setPublishtime(new Date());
        noteServiceImpl.addNote(majornote);
        
        
        return "redirect:findAllNote";
    }
    @RequestMapping("/addCount")
    @ResponseBody
    public Object addCount(Integer id){
        int _id = noteServiceImpl.getCountById(id);
        noteServiceImpl.addCount(id, _id+1);
        
        
        return _id+1;
    }
    
    
}
