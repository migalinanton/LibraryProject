<%@ page isErrorPage="true" import="java.io.*"%>

<% String message = exception.getMessage();%>
<script type="text/javascript">
    var msg = "<%=message%>";
    if (msg!="null") {
        alert(msg);
        window.location = "/list";
    }
</script>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>