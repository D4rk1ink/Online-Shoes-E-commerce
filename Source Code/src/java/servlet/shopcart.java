package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class shopcart extends HttpServlet {
    private final String view = "/WEB-INF/shoppingcart/shopcart.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("/auth/login");
            return ;
        };
        Inventory inv = new Inventory();
        SearchEngines seg = new SearchEngines();
        
        List user = (List)session.getAttribute("user");
        ShoppingCart cart = (ShoppingCart)user.get(1);
        List<Map> orders = cart.getOrders();
        List orderAll = new ArrayList();
        for(Map order : orders){
            List<Map> data_product = (List)inv.selectProductById((Integer)order.get("id"));
            List<Map> data_color = (List)inv.selectColorById((Integer)order.get("color"));
            List<Map> data_size = (List)inv.selectSizeById((Integer)order.get("size"));
            Map order_group = new HashMap();
            order_group.putAll(data_product.get(0));
            order_group.putAll(data_color.get(0));
            order_group.putAll(data_size.get(0));
            order_group.put("amount", (Integer)order.get("amount"));
            orderAll.add(order_group);
        }
        request.setAttribute("listorder", orderAll);
        List person = seg.viewBrand(inv.selectPerson());
        request.setAttribute("listperson", person);
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
