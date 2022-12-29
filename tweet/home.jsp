<jsp:include page="header.jsp"></jsp:include>
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
					<div class="4u">
						
						<section>
							
							<ul class="small-image-list">
								
					<li>
									<div>
									<% 
									
								if(session.getAttribute("username")!=null){
								String username=(String)session.getAttribute("username");		
								out.print("<font style='color:navy'>Welcome "+username+"</font>");
								}
								else{
								request.setAttribute("Error1","Plz Do login First");
								%>
								<jsp:forward page="index.jsp"></jsp:forward>
									<%}
								%></div>
									
						</li>			
								
						<li>
													</span>
										 
		
							
								
							</ul>
						</section>
					<img src="compose.jpg" height="300" width="300"/></li>

					</div>
					<div class="4u">
					
						<section>
							<h2>How to reach us?</h2>
							<div class="6u-first">
								<ul class="link-list">
			<li><a href="contactus.jsp">About US</a></li>
									<li><a href="contactus.jsp">Contact Us</a></li>
													</ul>
							</div>
							
						</section>

					</div>
				</div>
				
			</div>
		</div>

<jsp:include page="footer.html"></jsp:include>