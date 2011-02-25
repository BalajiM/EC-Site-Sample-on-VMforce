<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
		<title>Faq</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">		
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					${setting.contactsection1}
					${setting.contactsection2}
					<form:form modelAttribute="case" method="post" action="/savefaq.html">
						<table>
							<tr>
								<td>${setting.contactemail}</td>
								<td><form:input path="email" maxlength="20" /></td>
							</tr>
							<tr>
								<td>${setting.contactsubject}</td>
								<td><form:input path="subject" maxlength="70" /></td>
							</tr>
							<tr>
								<td>${setting.contactdescription}</td>
								<td><form:textarea path="description" rows="7" cols="50"></form:textarea></td>
							</tr>						
						</table>
						<table>
							<tr>
								<td height="40px" align="center">
									<input type="submit" name="btnSubmit" value="regsiter">
								</td>
								<td height="40px" align="center">
									<input type="reset"	name="btnReset" value="reset">
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
