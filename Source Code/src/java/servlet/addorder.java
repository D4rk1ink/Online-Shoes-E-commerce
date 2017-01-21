package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import warehouses.inventory.Inventory;
import webstore.searchengines.SearchEngines;
import webstore.shoppingcart.ShoppingCart;

public class addorder extends HttpServlet {
    private final String view = "/WEB-INF/blank.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "{ message : 'fail'}";
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "{ \"message\" : \"fail\"}";
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("user") == null){ response.getWriter().write(message); return; }
            List user = (List)session.getAttribute("user");
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer color = Integer.parseInt(request.getParameter("color"));
            Integer size = Integer.parseInt(request.getParameter("size"));
            Inventory inv = new Inventory();
            SearchEngines seg = new SearchEngines();
            List<Map> data_product = (List)inv.selectProductById(id);
            List<Map> data_color = (List)inv.selectColorById(color);
            List<Map> data_size = (List)inv.selectSizeById(size);
            if(data_product.size() != 1 && data_product.size() != 1 && data_product.size() != 1) return;
            ShoppingCart cart = (ShoppingCart)user.get(1);
            cart.addOrder((Integer)data_product.get(0).get("product_id"), (Integer)data_color.get(0).get("color_id"), (Integer)data_size.get(0).get("size_id"));
            user.set(1, cart);
            session.setAttribute("user", user);
            message = "{ \"message\" : \"success\"}";
        }catch(Exception ex){
            
        }
        response.getWriter().write(message);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
