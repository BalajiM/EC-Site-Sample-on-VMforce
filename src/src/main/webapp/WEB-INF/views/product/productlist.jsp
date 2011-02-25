<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
	<title>Product List</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">		
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					${setting.productlistsection1}
					${setting.productlistsection2}
					<c:forEach items="${products}" var="product">
						<h4><a href="/productdetail.html?pid=${product.id}">${product.name}</a></h4>
						<div class="typeB">
							<div class="left">
								<p>
									${product.description}<br/>
									$ ${product.price}
								</p>
							</div>
							<div class="right">
								<p><img src="${product.imgsmall}" alt="sample" width="220" height="220" /></p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>
