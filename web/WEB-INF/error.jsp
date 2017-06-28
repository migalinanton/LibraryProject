<%@ page isErrorPage="true" import="java.io.*"%>

<% String message = exception.getMessage();%>
<script type="text/javascript">
    var msg = "<%=message%>";
    if (msg!="null") {
        alert(msg);
        window.location = "/list";
    }
</script>