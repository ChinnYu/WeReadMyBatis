package com.jason.action;

import com.jason.dao.BookDao;
import com.jason.dao.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //設置編碼
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //獲得action類型
        String act = request.getParameter("act");
        if(act.equals("delete")){
            //獲得URL中要刪除的圖書編號
            int id = Integer.parseInt(request.getParameter("id"));
            BookDao dao = new BookDaoImpl();
            if(dao.deleteById(id)>0){//執行刪除並成功
                request.setAttribute("msg","刪除成功!");
            }else {
                request.setAttribute("msg","刪除失敗!");
            }
            //轉發到index.jsp頁面
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if(act.equals("edit")){


        }else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
