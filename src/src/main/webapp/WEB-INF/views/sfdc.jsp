<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
	<title>Setting</title>
	</head>

	<body>
	<p/>
	Please select VMforce Demo Template here and press submit
	<p/>
	<form:form modelAttribute="param" method="post" action="/sfdc.html">
		<table border="0" cellspacing="10" cellpadding="10">
			<tr>
				<td>
					<form:select path="settingid">
						<form:options items="${settings}" itemValue="id" itemLabel="name"/>
					</form:select>
				</td>
				<td>
					<input type="submit" name="btnSubmit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>
	</body>
</html>
