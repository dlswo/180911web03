<%@ page import="org.aram.dao.BillsDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.aram.domain.BillsVO" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="org.aram.domain.OrderVO" %><%--
  Created by IntelliJ IDEA.
  User: BIT03-02
  Date: 2018-09-10
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%
    BillsDAO dao = new BillsDAO();
    BillsVO vo = new BillsVO();
    String[] values = request.getParameterValues("cnt");
    System.out.println(Arrays.toString(values));


    //DB에서 주문번호를 채번
    int orderNum = dao.getOrderNum();





%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for(String str: values){

        String[] arr = str.split("_");

        if(arr[1].equals("0")){
            continue;
        }

        String mnoStr = arr[0];
        String qtyStr = arr[1];

        OrderVO orderVO = new OrderVO();
        orderVO.setOno(orderNum);
        orderVO.setMnum(Integer.parseInt(mnoStr));
        orderVO.setQty(Integer.parseInt(qtyStr));

        dao.addBills(orderVO);
    }
    List<OrderVO> result = dao.calcBills(orderNum);
    int totalPrice = 0;
%>
  <h1><%=orderNum%>번으로 주문되었습니다.</h1>
<h1>==============================영수증===============================</h1>
<% for(OrderVO lastvo : result) {
    totalPrice += lastvo.getSumprice();
%>
<h1><%=lastvo.getMname()%>/<%=lastvo.getQty()%>/<%=lastvo.getMprice()%>/<%=lastvo.getSumprice()%></h1>

<% } %>
<h1>===================================================================</h1>

<h1>총합계                                     <%=totalPrice%></h1>

</body>
</html>
