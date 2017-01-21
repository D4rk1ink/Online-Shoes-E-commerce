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
import webstore.searchengines.SearchEngines;

public class home extends HttpServlet {
    private final String view = "/WEB-INF/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Inventory inv = new Inventory();
        SearchEngines seg = new SearchEngines();
        List listproduct = seg.viewProduct(inv.selectProduct());
        List brands = seg.viewBrand(inv.selectBrand());
        List person = seg.viewPerson(inv.selectPerson());
        request.setAttribute("listperson", person);
        request.setAttribute("listproduct", listproduct);
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
