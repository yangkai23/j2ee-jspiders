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
String tid=request.getParameter("tid");


Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","email","email");

PreparedStatement ps1=con.prepareStatement("select *  from topics  where tid=?");

ps1.setString(1,tid);
ResultSet rs=ps1.executeQuery();

%>
<tr bgcolor='gray'><th width="400"><font color=white></font></th></tr>
<%
while(rs.next())
{

tid=rs.getString(1);
String sub=rs.getString(2);
String des=rs.getString(3);
%>

<tr bgcolor='gray'>

    <td BORDERCOLOR="#c0c0c0" width="56">
    <font style="FONT-SIZE:20pt" FACE="Arial" COLOR="#000000" align="LEFT">
   </font><font color='white'> Topic View</font><td bgcolor='white' BORDERCOLOR="gray" width="86"><a href=topics.jsp>Add Openion</a></td>
<td></tr>

<tr bgcolor='lightgray'>

    <td BORDERCOLOR="#c0c0c0" width="56">
    <font style="FONT-SIZE:20pt" FACE="Arial" COLOR="#000000" align="LEFT">
   </font><font color='blue'> <%=sub%></font>&nbsp;</td>
</tr>
<tr>
<td><font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000" align="TOP">
Description :<textarea name="des" rows="10" cols="80"> <%=des%></textarea></font>&nbsp;</td>
<tr bgcolor='lightgray'>

    <td BORDERCOLOR="#c0c0c0" width="56">
<a href=topics.jsp>Back</a></td>
    
 </tr>
  <%
  }}catch(Exception exx){out.println(exx.getMessage());}
  %>
  
  <tfoot>
  </tfoot>
</table>

</body>

</html>