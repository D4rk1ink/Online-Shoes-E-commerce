
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> listpayment = (List)request.getAttribute("listpayment");
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
                        <th>Order Id</th><th width="40%">Address</th><th width="15%">Amount</th><th width="15%">Date</th><th width="10%">Status</th>
                    </tr>
                    <% for(Map payment : listpayment){ 
                        String id = payment.get("payment_id").toString();
                        String address = payment.get("payment_address").toString();
                        String amount = payment.get("payment_amount").toString();
                        String date = payment.get("payment_date").toString();
                        String status = payment.get("status_name").toString();
                        String color = ((Integer)payment.get("delivery_status") == 1)? "darkred" : "darkgreen";
                    %>
                    <tr data-href="/admin/order/detail/<%= id %>" id="clickable-row">
                        <td><%= id %></td><td><%= address %></td><td><%= amount %></td><td><%= date %></td><td style="color:<%= color %>"><%= status %></td>
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
