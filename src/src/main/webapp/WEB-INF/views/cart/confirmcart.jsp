<%@ include file="/WEB-INF/views/common/jsp_header.jsp"%>
<html>
	<head>
	<title>Shopping Cart</title>
	</head>
	<body>
		<div id="container">
			<div id="innercontainer">		
			<%@ include file="/WEB-INF/views/common/tabheader.jsp"%>
			<div id="contents">
				<div id="other_page">
					${setting.confirmsection1}
					${setting.confirmsection2}				
					<table class="table5">
						<c:forEach items="${cart.itemList}" var="itemSet">
							<tr>
								<td class="table5" width="60px"><img src="${itemSet.item.pictureUrl}" alt="sample" width="60" height="60" /></td>			
								<td class="table5" width="280px">${itemSet.item.itemName}</td>
								<td class="table5" width="150px" align="right">$ ${itemSet.item.price}</td>				
								<td class="table5" width="40px" align="right">${itemSet.quantity}</td>
							</tr>
						</c:forEach>
					</table>
					<br/>
					<div align="right">
						<a href="/shoppingcart/thank.html"><img src="${setting.confirmaccepturl}" /></a>
					</div>
				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>
