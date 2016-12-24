package org.lanqiao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInteceptor implements HandlerInterceptor{

    /**
     * 请求到达controller之前.preHandle在业务处理器处理请求之前被调用
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        boolean flag = true;
        HttpSession session = request.getSession();
        Object loginObj = session.getAttribute("loginUser");
        String requestURI = request.getRequestURI();
        if(!(request.getServletContext().getContextPath()+"/view/login").equals(requestURI)){
            if(loginObj == null){
                flag = false; 
                response.sendRedirect(request.getServletContext().getContextPath()+"/view/login");
            }
        }
        return flag;
    }
    /**
     * 请求到达controller之后.postHandle在业务处理器处理请求执行完成后,生成视图之前执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        System.out.println("postHandle");
        
    }
    /**
     * 视图渲染之后.afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
    }

}
