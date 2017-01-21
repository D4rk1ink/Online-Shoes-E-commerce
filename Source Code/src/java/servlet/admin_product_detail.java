package servlet;

import dashboard.management.warehouses.WarehousesManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import warehouses.inventory.Inventory;

public class admin_product_detail extends HttpServlet {
    private final String view = "/WEB-INF/admin/product_detail.jsp";
    
    private Integer getIdFromPath(String path){
        String strint = path.replace("/","").replace("?", "");
        return Integer.parseInt(strint);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
            Integer id = getIdFromPath(request.getPathInfo());
            Inventory inv = new Inventory();
            WarehousesManagement pdm = new WarehousesManagement();
            List listproduct = pdm.viewProduct(inv.selectProductById(id));
            List brands = pdm.viewBrand(inv.selectBrand());
            List person = pdm.viewBrand(inv.selectPerson());
            request.setAttribute("listbrand", brands);
            request.setAttribute("listperson", person);
            request.setAttribute("product", listproduct);
        }catch(Exception ex){
            
        }
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
