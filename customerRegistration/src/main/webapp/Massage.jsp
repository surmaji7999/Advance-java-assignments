<% 
String msg= (String) session.getAttribute("MSG");
if(msg!=null){
%>
<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong><%=msg %></strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%
session.removeAttribute("MSG");
}
%>