
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
    <title>Shopping History</title>
    <script>
        function assignFormDelivery(){
            var form = $("#delivery-form").serializeArray();
            for(var i=0;i<form.length;i++){
                console.log(form[i].name); 
                $("#form_"+form[i].name).val(form[i].value);
            }
        }
        function emptyDelivery(){
            var form = $("#delivery-form").serializeArray();
            if(form.length == 0)return true;
            for(var i=0;i<form.length;i++){
                if(form[i].value == "")return true;
            }
            return false;
        }
    </script>
    <style>
        .order-detail{
            width: 900px;
            float: left;
        }
        .order-cart{
            width: 300px;
            float: left;
        }
        .order-detail-content{
            padding: 0 20px;
        }
        .title-product{
            margin-left: 20px; 
            font-size: 20px;
        }
        .title-delivery{
            font-size: 20px;
        }
        .cart-content{
            padding: 0 40px;
            height: 200px;
            overflow: hidden;
            background-color: #F7F7F7;
            border-bottom: 1px solid #ECECEC;
        }
        .cart-item{
            color: #3498db;
            font-family: "Glober Bold";
            font-size: 20px;
            text-align: center;
            margin: 20px 0;
        }
        .cart-price{
            color: #3498db;
            font-family: "Glober Bold";
            font-size: 20px;
            text-align: center;
            margin: 20px 0;
        }
        .cart-item::after,
        .cart-price::after{
            content: "";
            clear: both;
            display: table;
        }

        .h_item{
            float: left;
        }
        .h_value{
            float: right;
        }
        .cart-add-button,
        .cart-choose-size,
        .cart-choose-color {
            text-align: center;
            margin-bottom: 40px;
        }
        .cart-add-button button{
            border: 0px !important;
            height: 40px;
            line-height: 35px;
            background-color: #FF5D00;
            color: #FFF;
            font-family: "Glober Bold";
        }
        .order_table_h{
            margin-bottom: 10px;
            width: 100%;
        }
        .order_table_s{
            width: 100%;
        }
        .order_li_s,
        .order_li_h{
            width: 100%;
            padding: 5px 0;
            height: 40px;
 
            background-color: #F7F7F7;
            border: 1px solid #ECECEC;
        }
        .order_li_h{
            font-family: "Glober Bold";
        }
        .order_li_s > span,
        .order_li_h > span{
            padding: 0 10px;  
            line-height: 30px;
            text-align: center;
        }
        .order_li_s:hover{
            background-color: #FEFEFE;
        }
        .h_payment,.h_price,.h_date,.h_address,.h_status,.h_amount,.h_total{
            padding: 0 10px;  
        }
        .s_order{
            padding-left: 20px !important;;
            text-align: left !important;
        }
        .s_payment,
        .h_payment{
            width: 12%;
        }
        .s_price,
        .h_price{
            width: 12%;
        }
        .s_date,
        .h_date{
            width: 12%;
        }
        .s_address,
        .h_address{
            width: 52%;
        }
        .s_status,
        .h_status{
            width: 12%;
        }
        .s_amount,
        .h_amount{
            width: 12%;
        }
        .s_total,
        .h_total{
            width: 12%;
        }
        .s_remove,
        .h_remove{
            width: 7%;
        }
        .delivery-form{
            margin-top: 40px;
        }
        .delivery-form .form-lable{
            float: left;
        }
    </style>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="title-product">
            <span>Shopping History</span>
        </div>
        <div class="order-detail">
            <div class="order-detail-content">
                <div class="show-order-content">
                    <ul class="order_table_h">
                        <li class="order_li_h">
                            <span class="h_payment">Payment</span>
                            <span class="h_address">Address</span>
                            <span class="h_price">Price</span>
                            <span class="h_date">Date</span>
                            <span class="h_status">Status</span>
                        </li>
                    </ul>
                    <% 
                        for(Map payment : listpayment){ 
                        %>
                    <ul class="order_table_s">
                        <li class="order_li_s">
                            <span class="s_payment"><%= payment.get("payment_id").toString() %></span>
                            <span class="s_address"><%= payment.get("payment_address").toString() %></span>
                            <span class="s_price"><%= payment.get("payment_amount").toString() %></span>
                            <span class="s_date"><%= payment.get("payment_date").toString() %></span>
                            <span class="s_status"><%= payment.get("status_name").toString() %></span>
                        </li>
                    </ul>
                    <% } %>
                </div>
            </div>
        </div>
        
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</head>
