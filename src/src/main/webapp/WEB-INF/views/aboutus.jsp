<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
		<title>About US</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">
		<%@ include	file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					${setting.companysection1}
					${setting.companysection2}
				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>