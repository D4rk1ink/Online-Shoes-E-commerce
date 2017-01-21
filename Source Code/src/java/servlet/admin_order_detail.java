package servlet;

import dashboard.management.order.OrderManagement;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ordering.order.Order;
import ordering.payment.Payment;

public class admin_order_detail extends HttpServlet {
    private final String view = "/WEB-INF/admin/order_detail.jsp";
    
    private Integer getIdFromPath(String path){
        String strint = path.replace("/","").replace("?", "");
        return Integer.parseInt(strint);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
            Integer id = getIdFromPath(request.getPathInfo());
            Payment payment = new Payment();
            OrderManagement odm = new OrderManagement();
            Order order = new Order();
            List<Map> listorder = odm.viewOrder(order.selectOrderByPaymentId(id));
            List<Map> listpayment = odm.viewOrder(payment.selectPaymentById(id));
            List<Map> liststatus = payment.selectDeliveryStatus();
            request.setAttribute("liststatus", liststatus);
            request.setAttribute("listorder", listorder);
            request.setAttribute("listpayment", listpayment);
        }catch(Exception ex){
            
        }
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
            Integer payment_id = Integer.parseInt(request.getParameter("payment_id"));
            Integer status_id = Integer.parseInt(request.getParameter("status_id"));
            Payment payment = new Payment();
            payment.updatePaymentStatus(payment_id, status_id);
        }catch(Exception ex){
            System.out.println(ex);
        }
        response.sendRedirect("/admin/order");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
