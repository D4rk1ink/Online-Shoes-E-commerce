<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
    List<Map> products = (List)request.getAttribute("listproduct");
%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <style>
        .baner-full img,
        .baner-half img{
            height: 100%;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="highlight-banner">
            <div class="baner-grid-4">
                <div class="b-baner-full">
                    <div class="baner-full">
                        <img src="/img/banner/full_1.jpg"/>
                    </div>
                </div>
            </div>
            <div class="baner-grid-4">
                <div class="b-baner-half">
                    <div class="baner-half">
                        <img src="/img/banner/half_1.jpg"/>
                    </div>
                </div>
                <div class="b-baner-half">
                    <div class="baner-half">
                        <img src="/img/banner/half_2.jpg"/>
                    </div>
                </div>
            </div>
            <div class="baner-grid-4">
                <div class="b-baner-half">
                    <div class="baner-half">
                        <img src="/img/banner/half_3.jpg"/>
                    </div>
                </div>
                <div class="b-baner-half">
                    <div class="baner-half">
                        <img src="/img/banner/half_4.jpg"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="show-brands">
            <div class="title-show-brands">
                <span>Top Brand</span>
            </div>
            <div class="category-brand">
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/nike.png"/>
                        </div>
                    </a>
                </div>
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/puma.png"/>
                        </div>
                    </a>
                </div>
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/adidas.png"/>
                        </div>
                    </a>
                </div>
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/new_balance.png"/>
                        </div>
                    </a>
                </div>
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/converse.png"/>
                        </div>
                    </a>
                </div>
                <div class="grid-2">
                    <a href="#">
                        <div class="logo-brand-item">
                            <img src="/img/brand/fila.png"/>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="show-new-products">
            <div class="title-show-new-products">
                <span>New Products</span>
            </div>
            <div class="new-products-list">
                <% 
                    int i = 0;
                    for(int c=0;c<5;c++){ 
                    if(i >= products.size()) break;
                    Map product = products.get(i++);
                    System.out.println(product);
                    Integer id = Integer.parseInt(product.get("product_id").toString());
                    String name = product.get("product_name").toString();
                    Double price = Double.parseDouble(product.get("product_price").toString());
                    List images = (List)product.get("product_img");

                    %>
                    <div class="grid-20p">
                        <div class="new-product-item">
                            <a href="/product/<%= id %>/<%= name %>#">
                                <div class="new-product-item-img">
                                    <img src="/img/<%= images.get(0).toString() %>" />
                                </div>
                                <div class="new-product-item-detail">
                                    <span><%= name %></span>
                                </div>
                            </a>
                        </div>
                    </div>
                <% } %>
            </div>
        </div>
        <!--
        <div class="show-recommend-products">
            <div class="title-show-recommend-products">
                <span>New Products</span>
            </div>
            <div class="recommend-products-list">
                
            </div>
        </div>
        -->
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
