
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> products = (List)request.getAttribute("listproduct");
%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <link href="/css/admin-main.css" type="text/css" rel="stylesheet">
    <style>
        .product-table tr td:first-child{
            padding: 10px !important;
        }
        .product-table-img{
            width: 100%;
            height: 100px;
            padding: 0 10px;
            overflow: hidden;
        }
        .product-table-img img{
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="right-col" id="right-col">
        <jsp:include page="/WEB-INF/partials/admin-navbar.jsp" />
        <div class="content">
            <div class="main-title" style="float: none;">
                <div class="title-bold">
                    <span>Manage Product</span>
                </div>
            </div>
            <div class="product-table">
                <table>
                    <tr class="table-header title-bold">
                        <th>Image</th><th width="50%">Product Name</th><th width="15%">Price</th><th width="15%">Brand</th>
                    </tr>
                    <% for(Map product : products){ 
                        Integer id = (Integer)product.get("product_id");
                        String name = (String)product.get("product_name");
                        String detail = (String)product.get("product_detail");
                        List picture = (List)product.get("product_img");
                        String brand = (String)product.get("brand_name");
                        String person = (String)product.get("person_name");
                        Double price = (Double)product.get("product_price");
                        Integer quantity = (Integer)product.get("product_quantity");
                    %>
                        <tr data-href="/admin/product/detail/<%= id %>" id="clickable-row">
                            <td>
                                <div class="product-table-img">
                                    <img src="/img/<%= picture.get(0) %>">
                                </div>
                            </td>
                            <td><%= name %></td>
                            <td><%= price %></td>
                            <td><%= brand %></td>
                        </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </div>
    <script>
        $("#clickable-row").click(function() {
            window.document.location = $(this).data("href");
        });
    </script>
    <jsp:include page="/WEB-INF/partials/admin-slide-menu.jsp" />
</body>
</html>
