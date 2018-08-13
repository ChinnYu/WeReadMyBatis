<%@ page import="com.jason.dao.BookDao" %>
<%@ page import="com.jason.dao.BookDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jason.model.Book" %>

<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/8/12
  Time: 下午 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  BookDao dao = new BookDaoImpl();
  List<Book> books = dao.getAllBooks();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>圖書列表</title>
    <style>
      body{
          font-size: 14px;
      }
      #tabBooks{
          width: 80%;
      }
      #tabBooks,#tabBooks td{
          border-collapse: collapse;
      }
      .red{
          color: red;
      }
      .green{
          color: green;
      }
    </style>
  </head>
  <body>
    <h2>圖書列表</h2>
    <table border="1" id="tabBooks">
      <tr>
        <td>
          <input type="checkbox" id="chbAll">
        </td>
        <td>序號</td>
        <td>書名</td>
        <td>價格</td>
        <td>類型</td>
        <td>狀態</td>
        <td>操作</td>
      </tr>
      <%for (int i=0;i<books.size();i++){%>
      <tr>
        <td>
          <input type="checkbox" name="id" value=""/>
        </td>
        <td><%=i+1%></td>
        <td><%=books.get(i).getBook_title()%></td>
        <td><%=books.get(i).getBook_price()%></td>
        <td><%=books.get(i).getBook_typename()%></td>
        <td class="<%=books.get(i).getBook_state().equals("未借出")?"green":"red"%>">
          <%=books.get(i).getBook_state()%>
        </td>
        <td>
          <a href="BookServlet?act=delete&id=<%=books.get(i).getBook_Id()%>" class="delete" >刪除</a>
        </td>
      </tr>
      <%}%>
    </table>
  <script>
    var items = document.querySelectorAll(".delete");
    for(var i = 0;i<items.length;i++){
        items[i].onclick = function () {
            return confirm("你確定要刪除嗎?");
        }
    }
  </script>
  </body>
</html>
