<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Map> products = (List)request.getAttribute("product");
    List<Map> brands = (List)request.getAttribute("listbrand");
    List<Map> persons = (List)request.getAttribute("listperson");

%>
<!doctype html>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
    <link href="/css/admin-main.css" type="text/css" rel="stylesheet">
    <style>
        .content .title-bold{
            margin-bottom: 20px;
        }
        .form-inline .form-group{
            margin-bottom: 0;
            float: left;
        }
        .form-inline .form-group:not(:last-child){
            margin-right: 10px;
        }
        .picture-gallery-content > .row{
            margin: 0 -5px;
        }
        .picture-gallery-content > .row > div{
            padding: 0 5px;
        }
        .picture-gallery-content .cancel{
            width: inherit;
            height: inherit;
            position: absolute;
            z-index: 5;
        }
        .picture-gallery > .cancel > span {
            line-height: inherit;
            font-size: 70px;
            opacity: 0;
        }
        .picture-gallery > .cancel:hover>span {
            opacity: 0.8;
        }
        .picture-gallery-content .cancel img{
            width: 100%;
            left: 0;
            position: absolute;
        }
        .picture-gallery {
            text-align: center;
            position: relative;
            width: 100%;
            height: 110px;
            background-color: #F3F3F3;
            overflow: hidden;
        }
        .picture-gallery input[type="file"] {
            padding: 0;
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: inherit;
            opacity: 0;
            z-index: 1;
            display: block;
        }
        .picture-gallery > span {
            line-height: inherit;
            font-size: 70px;
            opacity: 0.3;
        }
        .picture-gallery:hover > span {
            opacity: 0.8;
        }
        .textarea-product-detail{
            width: 100%;
            height: 300px
        }
    </style>
</head>
<body>
    <div class="right-col" id="right-col">
        <jsp:include page="/WEB-INF/partials/admin-navbar.jsp" />
        <div class="content">
            <% 
                if(products.isEmpty()){
                    %>
                    <h2>Not Found</h2>
                    <%
                }else{
            %>
            <div class="main-title" style="float: none;">
                <div class="title-bold">
                    <span>Product Detail</span>
                </div>
            </div>
            <% for(Map product : products){ 
                Integer id = (Integer)product.get("product_id");
                String name = (String)product.get("product_name");
                String detail = (String)product.get("product_detail");
                List images = (List)product.get("product_img");
                String product_brand = (String)product.get("brand_name");
                String product_person = (String)product.get("person_name");
                Double price = (Double)product.get("product_price");
                Integer quantity = (Integer)product.get("product_quantity");
            %>
            <div class="product-form">
                <form action="" method="POST" id="target-form" onsubmit="return false">
                    <input type="hidden" name="product-id" id="product-id" value="<%= id %>">
                    <div  class="form-group">
                        <div class="grid-2">
                            <div class="form-lable">
                                <lable>Product Name : </lable>
                            </div>
                        </div>
                        <div class="grid-10">
                            <input type="text" class="form-input" name="product-name" id="product-name" value="<%= name %>">
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
                                <input type="text" class="form-input" name="product-price" id="product-price" value="<%= price %>">
                            </div>


                            <div class="grid-2">
                                <div class="form-lable">
                                    <lable>Quantity : </lable>
                                </div>
                            </div>
                            <div class="grid-4">
                                <input type="text" class="form-input" name="product-quantity" id="product-quantity" value="<%= quantity %>">
                            </div>
                        </div>
                    </div>
                    <div  class="form-group">
                        <div  class="form-inline">
                            <div class="grid-2">
                                <div class="form-lable">
                                    <lable>Brand : </lable>
                                </div>
                            </div>
                            <div class="grid-4">
                                <select class="form-input" name="product-brand" id="product-brand">
                                    <% for(Map brand : brands){ %>
                                    <option value="<%= brand.get("brand_id") %>" <%= (product_brand.equals(brand.get("brand_id")))? "selected" : "" %>><%= brand.get("brand_name") %></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="grid-2">
                                <div class="form-lable">
                                    <lable>Person : </lable>
                                </div>
                            </div>
                            <div class="grid-4">
                                <select class="form-input" name="product-person" id="product-person">
                                    <% for(Map person : persons){ %>
                                        <option value="<%= person.get("person_id") %>" <%= (product_person.equals(person.get("person_id")))? "selected" : "" %>><%= person.get("person_name") %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div  class="form-group">
                        <div  class="picture-gallery-content">
                            <div class="row" id="gallery">
                                <% for(int i=0;i<6;i++){ %>
                                <div class="grid-2">
                                    <div class="picture-gallery">
                                        <input type="file" class="n-text" name="product-picture[]" id="picture-gallery">
                                        <%if(i < images.size()){ %>
                                        <div class="cancel" id="cancel">
                                            <img src="/img/<%= images.get(i).toString() %>" id="product-picture">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </div>
                                        <% } %>
                                        <span class="glyphicon glyphicon-picture"></span>
                                    </div>
                                </div>  
                                <% } %>
                            </div>
                        </div>
                    </div>
                    <div  class="form-group">
                        <div class="grid-2" style="height: 5px;">
                            <span> </span>
                        </div>
                        <div class="grid-10">
                            <textarea class="textarea-product-detail" name="product-detail" id="product-detail"><%= detail %></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="grid-2 right">
                            <input type="submit" class="form-submit"/>
                        </div>
                    </div>
                </form>
            </div>
            <% } %>
            <% } %>
        </div>
    </div>
    <script type='text/javascript'>
        $("#gallery").on("click","#cancel", function(){
            $(this).parent().children('input[type="file"]').val("");
            $(this).remove();
        })
        $("#gallery").on("change", '#picture-gallery', function(event){
            var tag = $(this);
            var img = event.target.files;
            var reader = new FileReader();
            reader.readAsDataURL(img[0]);
            reader.onload = function(e){
                tag.after(	'<div class="cancel" id="cancel">'+
                                '<img src="'+e.target.result+'" id="product-picture">'+
                                '<span class="glyphicon glyphicon-remove"></span>'+
                            '</div>');
            }
        })
        /*$("#target-form").submit(function( event ) {
            var id = $("[id=product-id]").val();
            var name = $("[id=product-name]").val();
            var price = $("[id=product-price]").val();
            var quantity = $("[id=product-quantity]").val();
            var brand = $("[id=product-brand]").val();
            var person = $("[id=product-person]").val();
            var picture = $("[id=product-picture]");
            var detail = $("[id=product-detail]").val();
            var param = {};
            param["product-id"] = id;
            param["product-name"] = name;
            param["product-price"] = price;
            param["product-quantity"] = quantity;
            param["product-brand"] = brand;
            param["product-person"] = person;
            param["product-detail"] = detail;
            param["product-picture[]"] = [];
            $.each( picture, function( key, value ) {
                //console.log(value);
                param["product-picture[]"].push($(value).attr("src"));
                //alert( key + ": " + value );
            });
            jQuery.ajax({
                type: "POST",
                url: $("#target-form").attr("action"), 
                data: param, 
                success: function(data) {
                    console.log(data); 
                }
            });
            console.log(param);
        })*/
    </script>
    <jsp:include page="/WEB-INF/partials/admin-slide-menu.jsp" />
</body>
</html>
