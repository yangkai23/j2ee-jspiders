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
						
						<section>
							<h2>Removing Irrelevant Comments On Social Media</h2>
							<p>Tweet Segmentation and Its Application to Named Entity Recognition
			</p>
							
						</section>
					
					</div>
					<div class="4u">
									
									<%
String username=""; 
if(session.getAttribute("username")!=null){
username=(String)session.getAttribute("username");		
out.print("<font style='color:navy'>Welcome <p>   <font color=red>"+username+"</font></font>");
}
out.print("<font style='color:navy'><br><a href='addTopic.jsp'>Add Topic</a></p>");

//if(request.getAttribute("delete")!=null){
//String delete=(String)session.getAttribute("username");		
//out.print("<font style='color:navy'>"+delete+"</font>");

%>

<table BORDER="1" BGCOLOR="#ffffff" CELLSPACING="0" width="662">
<!--  <caption>
  <font color="#FFFF00" face="Arial"><b><font color="#000000">: <%=username%>  :</font> <font color="#000000"></font></b></font>
</caption>
  -->
  <thead>
    <tr>
      <th BGCOLOR="#c0c0c0" BORDERCOLOR="#000000" width="46">
      <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"></font></th>
      <th BGCOLOR="#c0c0c0" BORDERCOLOR="#000000" width="56"></th>
      <th BGCOLOR="#c0c0c0" BORDERCOLOR="#000000" width="264">
      <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">Description</font></th>
      <th BGCOLOR="#c0c0c0" BORDERCOLOR="#000000" width="47">
      <th BGCOLOR="#c0c0c0" BORDERCOLOR="#000010" width="146">
      <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"></font></th>
    </tr>
  </thead>
  
<%@page import='java.sql.*'%>
<%
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","email","email");

PreparedStatement psc=con.prepareStatement("select distinct(Subject) from topics");
//psc.setString(1,username);
ResultSet crs=psc.executeQuery();

while(crs.next())
{
String cat=crs.getString(1);
PreparedStatement ps1=con.prepareStatement("select count(*)  from opinions where subject= ?");
ps1.setString(1,cat);
ResultSet rs=ps1.executeQuery();
int count=0;
if(rs.next())
count=rs.getInt(1);

ps1=con.prepareStatement("select *  from Opinions where subject= ?");

ps1.setString(1,cat);
//ps1.setString(2,username);

rs=ps1.executeQuery();
%>
<tr bgcolor='gray'><th width="400"><font color=white><%=cat%> <font color=yellow style=normal>(<%=count%>)</font></th><td>
<td align="right" bgcolor='white' BORDERCOLOR="gray" width="400"><a href=addOpinion.jsp?subject=<%=cat%>>Add Openion</a></td></tr>
<%
while(rs.next())
{

int tid=rs.getInt(1);

//String to=rs.getString(2);
//String from=rs.getString(3);

//String msg=rs.getString(4);
String date=rs.getString(5);
String sub=rs.getString(2);
String des=rs.getString(4);


%>
  <tr VALIGN="TOP">
 <td BORDERCOLOR="#c0c0c0" ALIGN="RIGHT" width="46">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"></font>&nbsp;</td>

    <td BORDERCOLOR="#c0c0c0" width="56">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
   <a href="viewTopic.jsp?tid=<%=tid%>&des=<%=des%>&sub=<%=sub%>"><%=sub%></a></font>&nbsp;</td>
    <td BORDERCOLOR="#c0c0c0" width="264">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"><%=des%></font>&nbsp;</td>
    <td BORDERCOLOR="#c0c0c0" width="147">
    
   <td BORDERCOLOR="#c0c0c0" width="71">
    
   <!-- <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000">
<a href='delete.jsp?val="+mid+"'> Delete</a>
-->
</td>
  </tr>
  <%
  }}}catch(Exception exx){out.println(exx.getMessage());}
  %>
  
  <tfoot>
  </tfoot>
</table>

</body>

</html>