<%@page import="java.sql.*" %>

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
							<p>Removing irrelevent comments on social media
		</p>
							
						</section>
					
					</div>
					<div class="4u">
									
	<% 
									
	if(session.getAttribute("username")!=null)
{
String username=(String)session.getAttribute("username");		
out.print("<font style='color:navy'>Welcome "+username+"</font>");

if(request.getAttribute("delete")!=null){
String delete=(String)session.getAttribute("username");		
								out.print("<font style='color:navy'>"+delete+"</font>");
}
}
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","email","email");
PreparedStatement ps=con.prepareStatement("Select * from INBOX6 where RECIEVER=? ");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
%>
			<div id='bottom'></div>
			<hr>
<table border=1 width='600px'>
<tr>
<td><td>
<td><td>
<td><td>
<td><td>
<td><td>

<tr>
<td><td>Subject
<td><td>SENDER
<td><td>Cluster
<td><td>DATE OF RECIEVING
<td><td>Delete
</tr>
<%
			while(rs.next()){
				int id=rs.getInt(1);
				System.out.print(id);
%>
<tr>
<td><td><%=rs.getString(6)%></td>
<td><td><%=rs.getString(3)%></td>
<td><td><%=rs.getString(7)%></td>
<td><td><%=rs.getString(5)%></td>
<td><a href='delete.jsp?val="+id+"'> Delete</a></td>
</tr>
<%
}
			out.print("</table>");
			out.print("<table align='right'width='40%'>");
			//out.print("<tr><td><a href='DeleteServlet'>Delete</a></td></tr>");
			
			out.print("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
								
								
								
								else{
								request.setAttribute("Error1","Plz Do login First");
								%>

								<jsp:forward page="index.jsp"></jsp:forward>
									<%
									
									}
								%>
								
								
								</div>
					</div>
			
				</div>
				
			</div>
		</div>

<jsp:include page="footer.html"></jsp:include>