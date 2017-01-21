
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> listorder = (List)request.getAttribute("listorder");
%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
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
            /*height: 40px;*/
 
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
        .h_order,.h_price,.h_color,.h_size,.h_amount,.h_total{
            padding: 0 10px;  
        }
        .s_order{
            padding-left: 20px !important;;
            text-align: left !important;
        }
        .s_order,
        .h_order{
            width: 33%;
        }
        .s_price,
        .h_price{
            width: 12%;
        }
        .s_color,
        .h_color{
            width: 12%;
        }
        .s_size,
        .h_size{
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
            <span>Shopping Cart</span>
        </div>
        <div class="order-detail">
            <div class="order-detail-content">
                <div class="show-order-content">
                    <ul class="order_table_h">
                        <li class="order_li_h">
                            <span class="h_order">Order</span>
                            <span class="h_price">Price</span>
                            <span class="h_color">Color</span>
                            <span class="h_size">Size</span>
                            <span class="h_amount">Amount</span>
                            <span class="h_total">Total</span>
                            <span class="h_remove"></span>
                        </li>
                    </ul>
                    <% 
                        Integer _amount = 0;
                        Double total = 0d;
                        for(Map order : listorder){ 
                        Double tmp_total = (Double)order.get("product_price")*(Integer)order.get("amount");
                        total += tmp_total;
                        _amount += (Integer)order.get("amount");
                        %>
                    <ul class="order_table_s">
                        <li class="order_li_s">
                            <span class="s_order"><%= order.get("product_name").toString() %></span>
                            <span class="s_price"><%= order.get("product_price").toString() %></span>
                            <span class="s_color"><%= order.get("color_name").toString() %></span>
                            <span class="s_size"><%= order.get("size_name").toString() %></span>
                            <span class="s_amount"><%= order.get("amount").toString() %></span>
                            <span class="s_total"><%= tmp_total %></span>
                            <span class="s_remove glyphicon glyphicon-trash"></span>
                        </li>
                    </ul>
                    <% } %>
                </div>
                <% if(_amount != 0){ %>
                <div class="delivery-form">
                    <div class="title-delivery">
                        <span>Delivery Information</span>
                    </div>
                    <form id="delivery-form">
                        <div class="form-group">
                            <div class="form-lable">
                                <lable>Full Name </lable>
                            </div>
                            <div class="grid-12">
                                <input type="text" name="name" class="form-input" id="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-lable">
                                <lable>Address</lable>
                            </div>
                            <div class="grid-12">
                                <textarea rows="4" style="height:inherit;" name="address" id="address"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-lable">
                                <lable>Email Contact</lable>
                            </div>
                            <div class="grid-12">
                                <input type="text" name="email" class="form-input" id="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-lable">
                                <lable>Phone Contact</lable>
                            </div>
                            <div class="grid-12">
                                <input type="text" name="phone" class="form-input" id="phone">
                            </div>
                        </div>
                    </form>
                </div>
                <% } %>
            </div>
        </div>
        <div class="cart">
            <div class="cart-content">
                <div class="cart-item">
                    <span class="h_item">Total Item</span><span class="h_value"><%= _amount %></span>
                </div>
                <div class="cart-price">
                    <span class="h_item">Total Price</span><span class="h_value">$<%= total.intValue() %></span>
                </div>
                <div class="cart-add-button">
                <form name="checkoutForm" method="POST" action="/shopcart/payment" id="checkoutForm" onsubmit="return false;">
                    <input type="hidden" name="name" value="" id="form_name"/>
                    <input type="hidden" name="address" value="" id="form_address"/>
                    <input type="hidden" name="email" value="" id="form_email"/>
                    <input type="hidden" name="phone" value="" id="form_phone"/>
                    <input type="hidden" name="amount" value="<%= total.intValue() %>"/>
                    <input type="hidden" name="description" value="Product order THB<%= total.intValue()*100 %>" />
                    <script type="text/javascript" src="/js/card.min.js"
                      data-key="pkey_test_56cw02p8ce1vqp01n2k"
                      data-image="PATH_TO_LOGO_IMAGE"
                      data-frame-label="PAY"
                      data-button-label="Pay now"
                      data-submit-label="Submit"
                      data-location="no"
                      data-amount="<%= total.intValue()*100 %>"
                      data-currency="thb"
                      >
                    </script>
                </form>
                </div>
            </div>
        </div>
    </div>
                <!--
    <style>
        .full-pay-popup{
            position: fixed;
            width: 100%;
            height: 100%;
            left: 0;
            top: 0;
        }
        .screen-pay-popup{
            position: absolute;
            width: 100%;
            height: 100%;
            left: 0;
            top: 0;
            background-color: #000;
            opacity: 0.5;
        }
        .pay-popup{
            position: absolute;
            top: 20%;
            left: 50%;
        }
        .pay-popup-content{
            padding: 50px;
            width: 400px;
            height: 500px;
            background-color: #FFF;
            position: relative;
            top: -50%;
            left: -50%;
        }
    </style>
    
    <div class="full-pay-popup">
        <div class="screen-pay-popup">
        </div>
        <div class="pay-popup">
            <div class="pay-popup-content">
                <div class="form-group">
                    <div class="grid-12">
                        <input type="text" name="cardholder">
                    </div>
                </div>
                <div class="form-group">
                    <div class="grid-12">
                        <input type="text" name="cardholder">
                    </div>
                </div>
                <div  class="form-group">
                    <div  class="form-inline">
                        <div class="row" style="margin: 0 -5px;">
                            <div class="grid-6" style="padding: 0 5px;">
                                <input type="text" name="cardholder">
                            </div>
                            <div class="grid-6" style="padding: 0 5px;">
                                <input type="text" name="cardholder">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="grid-3">
                        <input type="text" name="cardholder">
                    </div>
                    <div class="grid-8 right">
                        You can find the security code at the back of your card.
                    </div>
                </div>
                <div class="form-group">
                    <div class="grid-2 right">
                        <input type="submit" class="form-submit"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    -->
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</head>
