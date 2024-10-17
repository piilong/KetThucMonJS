<%-- 
    Document   : Left
    Created on : Sep 28, 2023, 12:08:09 PM
    Author     : KHOACNTT
--%>
<%@page import="model.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.LoaiDAO"%>
<%
        LoaiDAO loaiDAO = new LoaiDAO();
        ArrayList<Loai> dsLoai = loaiDAO.getAll();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-3">
    <h3 class="card-header">Danh mục Loại</h3>  
        <ul class="list-group list-group-flush">
            <%
                for(Loai x: dsLoai)
                {
            %>
            <li class="list-group-item list-group-item-action"><a class="text-decoration-none" href="product.jsp?maLoai=<%=x.getMaloai() %>"><%=x.getTenloai() %></a></li>
            <% }%>
        </ul>   
</div>
