package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ordering.payment.Payment;
import warehouses.inventory.Inventory;
import webstore.searchengines.SearchEngines;

public class history extends HttpServlet {
    private final String view = "/WEB-INF/shoppingcart/history.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("user") == null){
                response.sendRedirect("/auth/login");
                return ;
            };
            Inventory inv = new Inventory();
            SearchEngines seg = new SearchEngines();
            Payment payment = new Payment();
            List listproduct = seg.viewProduct(inv.selectProduct());
            List brands = seg.viewBrand(inv.selectBrand());
            List person = seg.viewBrand(inv.selectPerson());
            List<Map> user = (List)session.getAttribute("user");
            Integer accid = (Integer)user.get(0).get("id");
            List<Map> listpayment = payment.selectPaymentByAccountId(accid);
            request.setAttribute("listpayment", listpayment);
            request.setAttribute("listperson", person);
            request.setAttribute("listproduct", listproduct);
        }catch(Exception ex){
            
        }
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
