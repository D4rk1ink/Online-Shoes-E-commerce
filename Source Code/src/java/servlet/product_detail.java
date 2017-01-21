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

public class product_detail extends HttpServlet {
    private final String view = "/WEB-INF/product/product_detail.jsp";
    
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
            Integer id = Integer.parseInt(m.group(1));
            Inventory inv = new Inventory();
            SearchEngines seg = new SearchEngines();
            List listproduct = seg.viewProduct(inv.selectProductById(id));
            List recommend = seg.viewProduct(inv.selectProductLimit(5));
            List person = seg.viewBrand(inv.selectPerson());
            List color = seg.viewBrand(inv.selectColor());
            List size = seg.viewBrand(inv.selectSize());
            request.setAttribute("listperson", person);
            request.setAttribute("listcolor", color);
            request.setAttribute("listsize", size);
            request.setAttribute("listproduct", listproduct);
            request.setAttribute("recommend", recommend);
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
