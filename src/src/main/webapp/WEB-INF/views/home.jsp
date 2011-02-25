<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
	<title>Home</title>
	</head>

	<body>
		<div id="container">
			<div id="innercontainer">
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="main_image"><img src="${setting.homelargeimgurl}" alt="infromation" width=726 height=180  />
			</div>
			<div id="contents">
				<div id="top">
					${setting.homesection1}
					${setting.homesection2}					
					<div id="top_btm">
						<div id="left">
							<div id="info">
								<h4><img src="${pageContext.request.contextPath}/resources/img/top/st_info.jpg" alt="infromation" width="398" height="34" /></h4>
								<div id="main">
									<c:forEach items="${infos}" var="info">
										<h5>${info.name}</h5>
										<p>${info.description}</p>
									</c:forEach>
								</div>
								<p><img src="${pageContext.request.contextPath}/resources/img/top/bg_info_dwn.jpg" width="398" height="20" alt="information" /></p>
							</div>
						</div>
						<div id="right">
							<div id="bnr_sps">
								<p><a href="${setting.homelinkurl1}">${setting.homelinktitle1}</a></p>
								<p><a href="${setting.homelinkurl2}">${setting.homelinktitle2}</a></p>
								<p><a href="${setting.homelinkurl3}">${setting.homelinktitle3}</a></p>
							</div>
						</div>
					</div>
				</div>
				</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>
