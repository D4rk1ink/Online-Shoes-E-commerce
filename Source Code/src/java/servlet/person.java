package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import warehouses.inventory.Inventory;
import webstore.searchengines.SearchEngines;

public class person extends HttpServlet {
    private final String view = "/WEB-INF/product/product_list.jsp";
    
    private Matcher pathPattern(String pattern, String pathUrl){
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pathUrl);
        return m;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            Matcher m = pathPattern("\\/(.*)\\/(.*)",request.getPathInfo());
            if(!m.find()) return ;
            Integer id = Integer.parseInt(m.group(2));
            String search = request.getParameter("search");
            String brand_id = request.getParameter("brand_id");
            
            Inventory inv = new Inventory();
            SearchEngines seg = new SearchEngines();
            List listproduct = null;
            
            if(brand_id != null){
                Integer _brand_id = Integer.parseInt(brand_id);
                listproduct = seg.viewProduct(inv.selectProductByPersonBrand(id, _brand_id));
            }else if(search != null){
                listproduct = seg.viewProduct(inv.selectProductByName(id, search));
            }else{
                listproduct = seg.viewProduct(inv.selectProductByPerson(id));
            }
            List brands = seg.viewBrand(inv.selectBrand());
            List person = seg.viewPerson(inv.selectPerson());
            List personnow = seg.viewPerson(inv.selectPersonById(id));
            request.setAttribute("personnow", personnow);
            request.setAttribute("listperson", person);
            request.setAttribute("listbrand", brands);
            request.setAttribute("listproduct", listproduct);
            System.out.println(listproduct.size());
            
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
