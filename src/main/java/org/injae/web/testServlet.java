package org.injae.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "testServlet", urlPatterns = "/test")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); //post방식으로 한글을 가져올때 필수.

        Enumeration<String> names = request.getParameterNames(); //파라미터의 이름을 모를때 쓴다.

        while(names.hasMoreElements()) {
            String name = names.nextElement();

            System.out.println(name);

            String[] values = request.getParameterValues(name);

            System.out.println(Arrays.toString(values));
        }


    }
}
