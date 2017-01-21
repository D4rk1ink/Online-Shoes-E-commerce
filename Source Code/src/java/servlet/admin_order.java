package servlet;

import dashboard.management.order.OrderManagement;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ordering.payment.Payment;

public class admin_order extends HttpServlet {
    private final String view = "/WEB-INF/admin/order.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
        Payment payment = new Payment();
        OrderManagement odm = new OrderManagement();
        List<Map> listpayment = odm.viewOrder(payment.selectPayment());
        request.setAttribute("listpayment", listpayment);
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
