package com.hut.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
@ResponseBody
public class ApiController {
    @Autowired
    private ServletContext servletContext;
    public void data(HttpServletResponse response,
                     HttpServletRequest request,
                     HttpSession session) {
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();


    }
}
