package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ordering.order.Order;
import ordering.payment.Payment;
import warehouses.inventory.Inventory;
import webstore.searchengines.SearchEngines;
import webstore.shoppingcart.ShoppingCart;

public class payment extends HttpServlet {
    //private final String view = "/WEB-INF/shoppingcart/shopcart.jsp";
    private Integer calculateTotal(Inventory inv, List<Map>orders){
        Double total = 0d;
        if(!orders.isEmpty()){  
            for(Map _order : orders){
                List<Map> data_product = (List)inv.selectProductById((Integer)_order.get("id"));
                List<Map> data_color = (List)inv.selectColorById((Integer)_order.get("color"));
                List<Map> data_size = (List)inv.selectSizeById((Integer)_order.get("size"));  
                total += (Double)data_product.get(0).get("product_price")*(Integer)_order.get("amount");
            }
        }else{
            return -1;
        }
        return total.intValue();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("user") == null){
                response.sendRedirect("/auth/login");
                return ;
            };

            String token = request.getParameter("omiseToken");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Integer amount = Integer.parseInt(request.getParameter("amount"));

            List<Map> user = (List)session.getAttribute("user");
            Integer account_id = (Integer)user.get(0).get("id");
            Inventory inv = new Inventory();
            SearchEngines seg = new SearchEngines();
            ShoppingCart cart = (ShoppingCart)user.get(1);
            Order order = new Order();
            Payment payment = new Payment();
            List<Map> orders = cart.getOrders();
            Integer total = calculateTotal(inv, orders);
            Boolean resultOrder = true;
            if(amount == total.intValue()){
                
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                String date = simpleDateFormat.format(new Date());
                Integer id = payment.insertPayment(
                        payment.compressDataProduct(
                                null, 
                                total.intValue(), 
                                account_id, 
                                date,
                                name,
                                address)
                );
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                if(id != -1){
                    for(Map _order : orders){
                        if(!order.insertOrder(
                                order.compressDataProduct(null, 
                                    id, 
                                    (Integer)_order.get("id"), 
                                    (Integer)_order.get("amount"), 
                                    (Integer)_order.get("color"), 
                                    (Integer)_order.get("size"))
                        )){
                            resultOrder = false;
                            break;
                        }
                        
                    }
                    System.out.println(resultOrder);
                    if(resultOrder && cart.pay(token,total.intValue())){
                        payment.payComfirm();
                        cart.clearOrders();
                        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssss");
                        response.sendRedirect("/shopcart/history");
                        return ;
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        response.sendRedirect("/shopcart");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
