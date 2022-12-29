<jsp:include page="header.jsp"></jsp:include>
<head>
<script>

var request;
function viewAll(name)
{
var v=name;
var url="delete.jsp?val="+v;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getAllInfo;
request.open("GET",url,true);
request.send();
}
catch(e){alert("Unable to connect to server");}
}

function getAllInfo(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('bottom').innerHTML=val;
}
}

</script>
</head>
<div id="main">
			<div class="5grid">
				<div class="main-row">
					<div class="4u-first">
						
						&gt;<section>
							<h2>Removing Irrelevant Comments On Social Media</h2>
							<p>Tweet Segmentation and Its Application to Named Entity Recognition		</p>
							
						</section>
					
					</div>
					<div class="4u">
									
									<%
String username=""; 
if(session.getAttribute("username")!=null){
username=(String)session.getAttribute("username");		
out.print("<font style='color:navy'>Welcome"+username+"</font>");
if(request.getAttribute("delete")!=null){
String delete=(String)session.getAttribute("username");		
out.print("<font style='color:navy'>"+delete+"</font>");
}
}
%>

<table BORDER="1" BGCOLOR="#ffffff" CELLSPACING="0" width="662">
  
  <caption>
  <font color="#FFFF00" face="Arial"><b><font color="#000000">Message View : <%=username%></font> <font color="#000000"></font></b></font>
  </caption>
  
    
<%@page import='java.sql.*'%>
<%
try{
String mid=request.getParameter("mid");



Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","email","email");

PreparedStatement ps1=con.prepareStatement("select *  from INBOX6  where id=?");

ps1.setString(1,mid);
ResultSet rs=ps1.executeQuery();

%>
<tr bgcolor='gray'><th width="400"><font color=white></font></th></tr>
<%
while(rs.next())
{

String to=rs.getString(2);
String from=rs.getString(3);
String msg=rs.getString(4);
String date=rs.getString(5);
String sub=rs.getString(6);
String domain=rs.getString(7);


%>
  <tr bgcolor='gray'><td>
 <td BORDERCOLOR="#c0c0c0" ALIGN="RIGHT" width="46">
    <font style="FONT-SIZE:20pt" FACE="Arial" COLOR="white">Message View
</font>&nbsp;</td>
 <tr bgcolor='lightgray'>

    <td BORDERCOLOR="#c0c0c0" width="56">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
   Subject <td><%=sub%></font>&nbsp;</td>

<tr bgcolor='lightgray'>
    <td BORDERCOLOR="#c0c0c0" width="264">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
	From :  <td><%=from%></font>&nbsp;</td>

<tr bgcolor='lightgray'>    
<td BORDERCOLOR="#c0c0c0" width="147">
 
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
Cluster :  <td><%=domain%></font>&nbsp;</td>

<tr bgcolor='lightgray'>    
<td BORDERCOLOR="#c0c0c0" width="171">
    
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
Date<td><%=date%></font>&nbsp;</td>
<tr bgcolor='lightgray'>
<td BORDERCOLOR="#c0c0c0" width="102">
<tr bgcolor='lightgray'>
<td BORDERCOLOR="#c0c0c0" width="171" style="vertical-align:top">
<font style="FONT-SIZE:15pt" FACE="Arial" COLOR="#000000">
Message :<td><textarea name="msg" rows="10" cols="80"> <%=msg%></textarea></font>&nbsp;</td>
<tr bgcolor='lightgray'>
    <td><td BORDERCOLOR="#c0c0c0" width="102"><a href=kcenter.jsp>Back</a></td>
    
 </tr>
  <%
  }}catch(Exception exx){out.println(exx.getMessage());}
  %>
  
  <tfoot>
  </tfoot>
</table>

</body>

</html>