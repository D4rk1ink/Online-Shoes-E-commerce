
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
            border-right: 1px solid #ECECEC;
        }
        .title-product{
            margin-left: 20px; 
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
        .cart-add-button input[type="submit"]{
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
    </style>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="title-product">
            <span>Shopping Cart</span>
        </div>
        <div class="order-detail">
            <div class="order-detail-content">
                <form action="" method="POST" id="target-form" enctype="multipart/form-data">
                    <div  class="form-group">
                        <div class="grid-2">
                            <div class="form-lable">
                                <lable>Product Name : </lable>
                            </div>
                        </div>
                        <div class="grid-10">
                            <input type="text" class="form-input" name="product-name" id="product-name">
                        </div>
                    </div>
                    <div  class="form-group">
                        <div  class="form-inline">
                            <div class="grid-2">
                                <div class="form-lable">
                                    <lable>Price : </lable>
                                </div>
                            </div>
                            <div class="grid-4">
                                <input type="text" class="form-input" name="product-price" id="product-price">
                            </div>


                            <div class="grid-2">
                                <div class="form-lable">
                                    <lable>Quantity : </lable>
                                </div>
                            </div>
                            <div class="grid-4">
                                <input type="text" class="form-input" name="product-quantity" id="product-quantity">
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="grid-2 right">
                            <input type="submit" class="form-submit"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
    </div>
    <script>
        $("#target-form").submit(function(){
            var id = $("#id").val();
            var color = $("#color").val();
            var size = $("#size").val();
            var param = { "id" : id, "color" : color, "size" : size };
            jQuery.ajax({
                type: "POST",
                url: $("#target-form").attr("action"), 
                data: param, 
                success: function(data) {
                    console.log(data); 
                }
            });
        })
    </script>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</head>
