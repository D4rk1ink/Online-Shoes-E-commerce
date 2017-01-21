
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> liststatus = (List)request.getAttribute("liststatus");
    List<Map> listpayment = (List)request.getAttribute("listpayment");
    List<Map> listorder = (List)request.getAttribute("listorder");
    String status_id = null;
    String payment_id = null;
%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <link href="/css/admin-main.css" type="text/css" rel="stylesheet">
    <style>
    </style>
</head>
<body>
    <div class="right-col" id="right-col">
        <jsp:include page="/WEB-INF/partials/admin-navbar.jsp" />
        <div class="content">
            <div class="main-title" style="float: none;">
                <div class="title-bold">
                    <span>Manage Order</span>
                </div>
            </div>
            <div class="product-table">
                <table>
                    <tr class="table-header title-bold">
                        <th width="10%">Product Id</th><th width="40%">Product Name</th><th width="15%">Brand</th><th width="15%">Color</th><th width="10%">Size</th><th width="10%">Amount</th>
                    </tr>
                    <% for(Map order : listorder){ 
                        String id = order.get("product_id").toString();
                        String name = order.get("product_name").toString();
                        String amount = order.get("payment_amount").toString();
                        String brand = order.get("brand_name").toString();
                        String color = order.get("color_name").toString();
                        String size = order.get("size_name").toString();
                    %>
                    <tr data-href="/admin/order/detail/<%= id %>" id="clickable-row">
                        <td><%= id %></td><td><%= name %></td><td><%= brand %></td><td><%= color %></td><td><%= size %></td><td><%= amount %></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <div class="" style="margin-top: 40px; margin-left: 10%">
                <div class="title-bold">
                    <span>Delivery Detail</span>
                </div>
                <% for(Map payment : listpayment){ 
                    payment_id = payment.get("payment_id").toString();
                    status_id = payment.get("delivery_status").toString();
                %>
                <div class="delivery-content">
                    <div>
                        <h3>Name :<%= payment.get("payment_name") %></h3>
                    </div>
                    <div class="delivery-content">
                        <h3>Address :<%= payment.get("payment_address") %></h3>
                    </div>
                </div>
                <% } %>
            </div>
            <div style="width: 80%; margin: 0 auto;">
                <form action="" method="POST">
                    <input type="hidden" value="<%= payment_id %>" name="payment_id">
                    <div class="grid-8">
                    </div>
                    <div class="grid-2">
                    <div class="form-group">
                        <select name="status_id" class="">
                            <% for(Map status : liststatus){ %>
                            <option value="<%= status.get("status_id") %>" <%= (status_id.equals(status.get("status_id").toString()))? "selected" : "" %>><%= status.get("status_name") %></option>
                            <% } %>
                        </select>
                    </div>
                    </div>
                    <div class="grid-2" style="padding-left: 5px">
                        <div class="form-group">
                            <input type="submit" class="form-submit" value="Update">
                        </div>
                    </div>
                </form>
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
