<%-- 
    Document   : Left
    Created on : Sep 28, 2023, 12:08:09 PM
    Author     : KHOACNTT
--%>

<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%SanPhamDAO sanPhamDAO = new SanPhamDAO();
    ArrayList<SanPham> dsSP = sanPhamDAO.getAll();
%>
<div class="card mb-3">
    <h3 class="card-header">Category</h3>  
        <ul class="list-group list-group-flush">
        <% for (SanPham x : dsSP) {
        %>
        <li class="list-group-item"> <a style="text-decoration: none" href="san-pham.jsp?maloai=<%=x.getMaloai() %>">
                <%=x.getTensp()%>
            </a>
        </li>
        <%}%>
    </ul>  
</div>
