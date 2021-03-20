<html>
	<body>
	 <div class="header" >
	    <jsp:include value="header.jsp" />
	 </div>
	 <div class="menu" >
     	<jsp:include value="menu.jsp" />
     </div>
	 <div class="container" >
		<form method="POST" action="/web-test/controller?command=login">
			"login"
			<input type="text" name="login" />
			<br/>
			"password"
			<input type="password" name="password" />
			<input type="submit" />
		</form>
		${errorMessage}
	 </div>
	</body>
</html>
