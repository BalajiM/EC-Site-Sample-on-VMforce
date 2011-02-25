<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
		<title>About US</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">		
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					${setting.signupsection1}
					${setting.signupsection2}
					<form:form modelAttribute="contact" method="post" action="/user/submit.html">
						<table>
							<tr>
								<td>${setting.signupfirstname}</td>
								<td><form:input path="firstname" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.signuplastname}</td>
								<td><form:input path="lastname" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.signupemail}</td>
								<td><form:input path="email" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.signuppassword}</td>
								<td><form:input path="password" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.signupphone}</td>
								<td><form:input path="phone" maxlength="20" /></td>
							</tr>						
						</table>
						<table>
							<tr>
								<td align="center">
									<input type="submit" name="btnSubmit" value="${setting.signupregister}">
								</td>
								<td height="40px" align="center">
									<input type="reset"	name="btnReset" value="${setting.signupreset}">
								</td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>
