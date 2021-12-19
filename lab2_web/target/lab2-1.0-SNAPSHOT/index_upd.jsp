<%@ page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%
        ServletContext context = request.getServletContext();
        JspWriter pw = out;

        if ((Integer) context.getAttribute("t") != 2) {
            request.getRequestDispatcher("clear_btn.jsp").include(request,response);
        }
    %>


<table id="table-result">
    <thead>
    <tr>
        <th>№</th>
        <th>Точка в зоне</th>
        <th>R</th>
        <th>X</th>
        <th>Y</th>
        <th>Время обработки</th>
    </tr>
    </thead>
    <tbody>

    <%
        LinkedList<String> answer = (LinkedList<String>) context.getAttribute("answer");
        for (String s : answer) {
            pw.println(s);
        }
    %>

    </tbody>
</table>
%>
