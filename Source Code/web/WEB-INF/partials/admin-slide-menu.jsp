<script>
    function sideEvent() {
        if($("#mySidenav").hasClass("sideOff")){
            $("#mySidenav").removeClass("sideOff").addClass("sideOn");
            $(".sidenav-on").removeClass("sidenav-hided");
            document.getElementById("right-col").style.marginLeft  = "200px";
            document.getElementById("mySidenav").style.width = "200px";
        }else{
            $("#mySidenav").removeClass("sideOn").addClass("sideOff");
            $(".sidenav-on").addClass("sidenav-hided");
            document.getElementById("right-col").style.marginLeft  = "50px";
            document.getElementById("mySidenav").style.width = "50px";
        }
    }
</script>
<div class="left-col sideOff" id="mySidenav">
    <div class="sidenav">
        <div class="sidenav-on sidenav-hided">
            <ul class="list-unstyled">
                <li><a href="#">Dashboard</a></li>
            </ul>
            <ul class="list-unstyled">
                <li><a href="#">Manage Product</a></li>
                <li><a href="#">Add Product</a></li>
            </ul>
            <ul class="list-unstyled">
                <li><a href="#">Manage Order</a></li>
            </ul>

        </div>
        <div class="sidenav-off">
            <ul class="list-unstyled" >
                <li><a href="/admin"><span class="glyphicon glyphicon-home"></span></a></li>
            </ul>
            <ul class="list-unstyled">
                <li><a href="/admin/product"><span class="glyphicon glyphicon-list-alt"></span></a></li>
                <li><a href="/admin/product/add"><span class="glyphicon glyphicon-plus"></span></a></li>
            </ul>
            <ul class="list-unstyled">
                <li><a href="/admin/order"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
            </ul>

        </div>
    </div>
</div>
