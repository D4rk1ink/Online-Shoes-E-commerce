<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> brands = (List)request.getAttribute("listbrand");
    List<Map> products = (List)request.getAttribute("listproduct");
    String personname = ((List<Map>)request.getAttribute("personnow")).get(0).get("person_name").toString();
%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <style>
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="sidebar">
            <div class="sidebar-content">
                <div class="menu-group">
                    <div class="title-bold">
                        <span>CATEGORY</span>
                    </div>
                    <ul>
                        <% for(Map brand : brands){ %>
                        <li><a href="?brand_id=<%= brand.get("brand_id") %>&brand_name=<%= brand.get("brand_name") %>"><%= brand.get("brand_name") %></a></li>
                        <% } %>
                    </ul>
                </div>
                
            </div>
        </div>
        <div class="main">
            <div class="main-content">
                <div class="main-head">
                    <div class="main-title">
                        <div class="title-bold">
                            <span><%= personname.toUpperCase() %></span>
                        </div>
                    </div>
                    <div class="product-filter">
                        <div class="form-search">
                            <form action="" method="GET">
                                <input type="text" name="search">
                                <button><i class="glyphicon glyphicon-search"></i></button>
                            </form>
                        </div>
                        <div class="sort-by">
                            <select>
                                <option>A-Z</option>
                                <option>Z-A</option>
                                <option>0-9</option>
                                <option>9-0</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="main-product-list">
                    <% 
                        if(products.size() != 0){
                        int i = 0;
                        boolean breakloop = false;
                        for(int r=0;r<5;r++){ %>
                        <div class="row">
                            <% for(int c=0;c<5;c++){ 
                                if(i >= products.size()){
                                    breakloop = true;
                                    break;
                                }
                                Map product = products.get(i++);
                                System.out.println(product);
                                Integer id = Integer.parseInt(product.get("product_id").toString());
                                String name = product.get("product_name").toString();
                                Double price = Double.parseDouble(product.get("product_price").toString());
                                List images = (List)product.get("product_img");
                                
                                %>
                                <div class="grid-20p">
                                    <div class="product-item">
                                        <a href="/product/<%= id %>/<%= name %>">
                                            <div class="product-item-img">
                                                <img src="/img/<%= images.get(0).toString() %>" />
                                            </div>
                                            <div class="product-item-detail">
                                                <div class="product-item-describe">
                                                    <span><%= name %></span>
                                                </div>
                                                <div class="product-item-price">
                                                    <span>price : <%= price %></span>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            <% } %>
                        </div>
                    <% 
                        if(breakloop)break;
                        }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
