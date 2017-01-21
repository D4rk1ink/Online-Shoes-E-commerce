package servlet;

import dashboard.management.warehouses.WarehousesManagement;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static service.service.getImages;
import static service.service.getPath;
import warehouses.inventory.Inventory;

@MultipartConfig(fileSizeThreshold=1024*1024*10, 
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*10,
                 location="/img")
public class admin_product_add extends HttpServlet {
    private final String view = "/WEB-INF/admin/product_add.jsp";
    
    private String encodeFileName(){
        String time = String.valueOf(new Date().getTime());
        String uuid = UUID.randomUUID().toString();
        return "";
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
            Inventory inv = new Inventory();
            WarehousesManagement pdm = new WarehousesManagement();
            List brands = pdm.viewBrand(inv.selectBrand());
            List person = pdm.viewBrand(inv.selectPerson());
            List color = pdm.viewBrand(inv.selectColor());
            List size = pdm.viewBrand(inv.selectSize());
            request.setAttribute("listbrand", brands);
            request.setAttribute("listperson", person);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getSession().getAttribute("admin") == null){ response.sendRedirect("/admin/login"); return; }
            String name = request.getParameter("product-name");
            String detail = request.getParameter("product-detail");
            Double price = Double.parseDouble(request.getParameter("product-price"));
            Integer quantity = Integer.parseInt(request.getParameter("product-quantity"));
            Integer brand = Integer.parseInt(request.getParameter("product-brand"));
            Integer person = Integer.parseInt(request.getParameter("product-person"));
            String[] _images = request.getParameterValues("product-picture[]");
            List images = getImages(request);
            String path = getPath(request,"img");
            /*List image = new ArrayList();
            for(String img : _images){
                image.add(img);
            }*/
            
            Inventory inv = new Inventory();
            WarehousesManagement pdm = new WarehousesManagement();
            Map product = inv.compressDataProduct(null, name, detail, (List)images.get(1), brand, person, price, quantity);
            if(pdm.addProduct((List)images.get(0),(List)images.get(1),path,inv.insertProduct(product))){
                inv.addComfirm();
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        response.sendRedirect(request.getRequestURL().toString());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
