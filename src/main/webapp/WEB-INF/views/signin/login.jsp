<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
	<title>Login</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">		
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					<font color="red">${message}</font><br/>
					${setting.signinsection1}
					<form:form modelAttribute="contact" method="post" action="/user/check.html">
						<table>
							<tr>
								<td>${setting.signinemail}</td>
								<td><form:input path="email" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.signinpassword}</td>
								<td><form:input path="password" maxlength="20" /></td>
							</tr>
						</table>
						<table>
							<tr>
								<td align="right">
									<input type="submit" name="btnSubmit" value="${setting.signinsubmit}">
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
