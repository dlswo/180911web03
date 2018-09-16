package org.aram.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Enumeration<String> names = request.getParameterNames();            //들어오는 파라미터가 뭔지 아무것도 모를 때

        while(names.hasMoreElements()){

            String name = names.nextElement();

            System.out.println(name);

            String[] values = request.getParameterValues(name);

            System.out.println(Arrays.toString(values));

        }
    }
}
