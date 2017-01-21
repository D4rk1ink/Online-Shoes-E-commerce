package servlet;

import dashboard.management.warehouses.WarehousesManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static service.service.getPath;
import warehouses.inventory.Inventory;

public class admin_product_event_update extends HttpServlet {
    private final String view = "/WEB-INF/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            /*Integer id = Integer.parseInt(request.getParameter("product-id"));
            String name = request.getParameter("product-name");
            String detail = request.getParameter("product-detail");
            Double price = Double.parseDouble(request.getParameter("product-price"));
            Integer quantity = Integer.parseInt(request.getParameter("product-quantity"));
            Integer brand = Integer.parseInt(request.getParameter("product-brand"));
            Integer person = Integer.parseInt(request.getParameter("product-person"));
            String[] _picture = request.getParameterValues("product-picture[]");
            List images = getImages(request);
            String path = getPath(request,"img");
            
            Inventory inv = new Inventory();
            WarehousesManagement pdm = new WarehousesManagement();
            Map product = inv.compressDataProduct(null, name, detail, (List)images.get(1), brand, person, price, quantity);
            pdm.addProduct((List)images.get(0),(List)images.get(1),path,inv.insertProduct(product));*/
            
            String[] _picture = request.getParameterValues("product-picture[]");
            
            for(String g : _picture){
                System.out.print(g);
            }
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //request.getRequestDispatcher(view).forward(request, response);
        response.sendRedirect(request.getRequestURL().toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
