package org.lanqiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/{url}")
    public String view(@PathVariable("url") String viewName) {
        return viewName;
    }

    @RequestMapping("/inc/{url}")
    public String view2(@PathVariable("url") String viewName) {
        return viewName;
    }

    @RequestMapping("/errors/{url}")
    public String view3(@PathVariable("url") String viewName) {
        return viewName;
    }
}
