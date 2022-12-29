
<jsp:include page="header.jsp"></jsp:include>

<%
String removes[]={"idiot","stupid","prick","shit ","crazy","clown","nerd ","creepy","cheesy","bimbo","show off"};
String removeu[]=new String[removes.length];
for(int i=0;i<removes.length;i++)
{
	removeu[i]=removes[i].toUpperCase();
}

%>
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
							<p>from Tweets, Retweets, and Retweeters
			</p>
							
						</section>
					
					</div>
					<div style="height:500px;width:1200px;border:solid 2px orange;overflow:scroll;overflow-x:hidden;overflow-y:scroll;">
									
									<%
String username=""; 
if(session.getAttribute("username")!=null){
username=(String)session.getAttribute("username");		
out.print("<font style='color:navy'>Welcome <p>   <font color=red>"+username+"</font></font>");
}
out.print("<font style='color:navy'><br><a href='addOpinion.jsp'>New Openion</a></p>");

//if(request.getAttribute("delete")!=null){
//String delete=(String)session.getAttribute("username");		
//out.print("<font style='color:navy'>"+delete+"</font>");

%>
  <div>

<table BORDER="1" BGCOLOR="#ffffff" CELLSPACING="0" width="1162">
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

PreparedStatement psc=con.prepareStatement("select distinct(domainname) from opinions order by domainname");
//psc.setString(1,username);
ResultSet crs=psc.executeQuery();

while(crs.next())
{
String cat=crs.getString(1);
PreparedStatement ps1=con.prepareStatement("select count(*)  from opinions where domainname= ?");
ps1.setString(1,cat);
ResultSet rs=ps1.executeQuery();
int count=0,pcount=0,ncount=0;
String status="";
if(rs.next())
count=rs.getInt(1);

ps1=con.prepareStatement("select count(*)  from opinions where domainname= ? and pStatus='Positive'");
ps1.setString(1,cat);
rs=ps1.executeQuery();

if(rs.next())
pcount=rs.getInt(1);

ps1=con.prepareStatement("select count(*)  from opinions where domainname= ? and pStatus='Nagative'");
ps1.setString(1,cat);
rs=ps1.executeQuery();

if(rs.next())
ncount=rs.getInt(1);

float pscore=(pcount*100/count); 
float nscore=(ncount*100/count);
 float score;
if(pscore>=nscore)
{
	status="Positive";
	score=pscore;
}
else
{
	status="Nagative";
	score=nscore;
}

if(score>=100)score=100;
//if(nscore>=100)nscore=100;

ps1=con.prepareStatement("select *  from Opinions where domainname= ?");

ps1.setString(1,cat);
//ps1.setString(2,username);

rs=ps1.executeQuery();
%>
<tr bgcolor='gray'>
<th  width=400 align="LEFT"><font color=white><%=cat%>-<font color=yellow style=normal>(<%=count%>)</font> </font></th>

<th  width=200 align="LEFT"> <font size=3><%=status%>(<%=score%> %)</font></th>
<th  width=1000 align="LEFT"></th>

</tr>

<%
while(rs.next())
{

int tid=rs.getInt(1);

//String to=rs.getString(2);
String from=rs.getString(2);

//String msg=rs.getString(4);
String date=rs.getString(5);
String sub=rs.getString(3);
String des=rs.getString(4);
String op=rs.getString(7);

for(int i=0;i<removes.length;i++)
{
des=des.replaceAll(removes[i],"<font color=red>...</font>");
des=des.replaceAll(removeu[i],"<font color=red>...</font>");
}
%>
  <tr VALIGN="TOP">
 <td BORDERCOLOR="#c0c0c0" ALIGN="RIGHT" width="46">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"></font>&nbsp;</td>

    <td BORDERCOLOR="#c0c0c0" width="56">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="blue">
   <%--<a href="viewOpinion.jsp?tid=<%=tid%>&des=<%=des%>&sub=<%=sub%>><%=sub%></a>--%>
	<%=from%>
</font>&nbsp;</td>
    <td BORDERCOLOR="#c0c0c0" width="464">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"><%=des%></font>&nbsp;</td>
 <td BORDERCOLOR="#c0c0c0" width="64">
    <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="#000000"><%=op%></font>&nbsp;</td>
   
    <td BORDERCOLOR="#c0c0c0" width="264">
  <font style="FONT-SIZE:10pt" FACE="Arial" COLOR="blue">
   <%--<a href="viewOpinion.jsp?tid=<%=tid%>&des=<%=des%>&sub=<%=sub%>><%=sub%></a>--%>
	<%=date%>
</font>&nbsp;</td>
    
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

<div>
</body>

</html>