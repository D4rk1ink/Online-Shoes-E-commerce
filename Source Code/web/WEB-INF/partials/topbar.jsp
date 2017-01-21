<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%
    List user = null;
    String email = null;
    if(session.getAttribute("user") != null){
        user = (List)session.getAttribute("user");
        email = ((Map)user.get(0)).get("email").toString();
    }
%>
<% if(user != null){ %>
<div class="user-menu">
    <ul>
        <li id="target-cart"><a href="/shopcart"><span class="glyphicon glyphicon-shopping-cart" ></span><span class="title-menu"> Shopping Cart</span></a></li>
        <li><a href="/shopcart/history"><span class="glyphicon glyphicon-list-alt"></span><span class="title-menu"> History</span></a></li>
        <li><span class="glyphicon glyphicon-log-out"></span><span class="title-menu"> Shopping Cart</span></li>
    </ul>
</div>
<% } %>
<div class="topbar">
    <div class="contrainer">
        <div class="b-topbar-head">
            <div class="topbar-head">
                <% if(user != null){ %>
                <ul>
                    <li><a href="#"><%= email %></a></li>
                    <li><a href="/auth/event/logout">Logout</a></li>
                </ul>
                <% }else{ %>
                <ul>
                    <li><a href="/auth/login">Login</a></li>
                    <li><a href="/auth/register">Register</a></li>
                </ul>
                <% } %>
            </div>
        </div>
        <div class="b-topbar-content">
            <div class="topbar-content">
                <a href="/home">
                    <div class="topbar-logo">
                        <img src="/img/logo/logo.jpg"/>
                    </div>
                </a>
                <div class="topbar-item">
                    <ul>
                        <%
                            List<Map> persons = (List)request.getAttribute("listperson");
                            for(Map  person : persons){
                                Integer person_id = (Integer)person.get("person_id");
                                String person_name = person.get("person_name").toString();
                            
                        %>
                        <li><a href="/p/<%= person_name.toLowerCase() %>/<%= person_id %>"><%= person_name.toUpperCase() %></a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
