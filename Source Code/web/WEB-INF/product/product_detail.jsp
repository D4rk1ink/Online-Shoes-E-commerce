<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> colors = (List)request.getAttribute("listcolor");
    List<Map> sizes = (List)request.getAttribute("listsize");
    List<Map> recommends = (List)request.getAttribute("recommend");
    Map product = (Map)((List)request.getAttribute("listproduct")).get(0);
    Integer id = (Integer)product.get("product_id");
    String name = (String)product.get("product_name");
    String detail = (String)product.get("product_detail");
    List<String> images = (List)product.get("product_img");
    String product_brand = (String)product.get("brand_name");
    String product_person = (String)product.get("person_name");
    Double price = (Double)product.get("product_price");
    Integer quantity = (Integer)product.get("product_quantity");
%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <style>
        .product-detail{
            width: 900px;
            float: left;
        }
        .product-cart{
            width: 300px;
            float: left;
        }
        .product-detail-content{
            border-right: 1px solid #ECECEC;
        }
        .title-product{
            font-size: 20px;
        }
        .show-product-detail-img{
            width: 100%;
            height: 400px;
            overflow: hidden;
            border-bottom: 1px solid #ECECEC;
        }
        .show-subimg-product{
            width: 150px;
            height: 100%;
            float: left;
            border-right: 1px solid #ECECEC;
        }
        .show-subimg-product-content{

        }
        .subimg-product-item{
            margin: 0 auto;
            width: 75%;
            max-height: 90px;
            overflow: hidden;
        }
        .subimg-product-item img{
            width: 100%;
        }
        .show-mainimg-product{
            padding: 0 50px;
            width: 749px;
            float: left;
        }
        .show-mainimg-product-content{
            width: 80%;
            margin: 0 auto;
            overflow: hidden;
        }
        .product-detail-show-recommend-products,
        .show-product-infomatail{
            width: 100%;
            margin-top: 20px;
            padding: 0 20px;
            padding-bottom: 20px;
            border-bottom: 1px solid #ECECEC;
        }
        .product-detail-show-recommend-products{
            border-bottom: 0;
        }
        .show-product-infomatail .title-bold{
            font-size: 15px;
            margin-bottom: 20px;
        }
        .product-cart-content{
            padding: 0 40px;
            height: 400px;
            overflow: hidden;
            background-color: #F7F7F7;
            border-bottom: 1px solid #ECECEC;
        }
        .product-cart-price{
            color: #3498db;
            font-family: "Glober Bold";
            font-size: 40px;
            text-align: center;
            margin: 40px 0;
        }
        .product-cart-add-button,
        .product-cart-choose-size,
        .product-cart-choose-color {
            text-align: center;
            margin-bottom: 40px;
        }
        .product-cart-add-button input[type="submit"]{
            border: 0px !important;
            height: 40px;
            line-height: 35px;
            background-color: #FF5D00;
            color: #FFF;
            font-family: "Glober Bold";
        }
    </style>
<body>
    <jsp:include page="/WEB-INF/partials/topbar.jsp" />
    <div class="content">
        <div class="product-detail">
            <div class="product-detail-content">
                <div class="show-product-detail-img">
                    <div class="show-subimg-product">
                        <div class="show-subimg-product-content">
                            <% for(String image : images){ %>
                            <div class="subimg-product-item">
                                <img src="/img/<%= image %>"/>
                            </div>
                            <% } %>
                        </div>
                    </div>
                    <div class="show-mainimg-product">
                        <div class="title-product">
                            <span><%= name %></span>
                        </div>
                        <div class="show-mainimg-product-content">
                            <img src="/img/<%= images.get(0).toString() %>"/>
                        </div>
                    </div>
                </div>
                <div class="show-product-infomatail">
                    <div class="title-bold">
                        <span>Product Information</span>
                    </div>
                    <span><%= detail %></span>
                </div>
                <div class="product-detail-show-recommend-products">
                    <div class="title-show-recommend-products">
                        <span>You May Also Like</span>
                    </div>
                    <div class="recommend-products-list">
                        <% for(Map recommend : recommends){ 
                            Integer re_id = (Integer)recommend.get("product_id");
                            String re_name = (String)recommend.get("product_name");
                            List re_images = (List)recommend.get("product_img");
                        %>
                            <div class="grid-20p">
                                <div class="new-product-item">
                                    <a href="/product/<%= re_id %>/<%= re_name %>">
                                        <div class="new-product-item-img">
                                            <img src="/img/<%= re_images.get(0).toString() %>" />
                                        </div>
                                        <div class="new-product-item-detail">
                                            <span><%= re_name %></span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <form action="/addorder" onsubmit="return false;" id="target-form">
        <div class="product-cart">
            <div class="product-cart-content">
                <input type="hidden" value="<%= id %>" name="id" id="id">
                <div class="product-cart-price">
                    <span>THB<%= price %></span>
                </div>
                <div class="product-cart-choose-color">
                    <select name="color" id="color" required>
                        <option value="" selected>--Choess Color--</option>
                        <% for(Map color : colors){ %>
                        <option value="<%= color.get("color_id").toString() %>"><%= color.get("color_name").toString().toUpperCase() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="product-cart-choose-size">
                    <select name="size" id="size" required>
                        <option value="" selected>--Choess Size--</option>
                        <% for(Map size : sizes){ %>
                        <option value="<%= size.get("size_id").toString() %>"><%= size.get("size_name").toString().toUpperCase() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="product-cart-add-button">
                    <input type="submit" class="form-submit" value="ADD TO CART"/>
                </div>
            </div>
        </div>
        </form>
    </div>
    <script>
        function toCart(){
            $( "#target-cart" ).animate({
                "margin-left": "-150px"
            }, 800, function(){
                $( "#target-cart" ).animate({
                    "margin-left": "0px"
                }, 800, function(){
                    $(this).css({ "margin-left" : "" })
                });
            });
        }
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
                    data = $.parseJSON(data);
                    if(data.message == "success") toCart();
                },
            });
        })
    </script>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</head>
