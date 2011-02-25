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
					<h4>${product.name}</h4>
					<div class="typeB">
						<div class="left">
							<p><img src="${product.imgbig}"  width="300" height="300" /></p>
						</div>
						<div class="right">
							<p>
								${product.description} <br/>
								$ ${product.price}
							</p>
						</div>
					</div>
					<div class="typeB">
						<div class="right">
							<form name="addCartForm" action="/shoppingcart/add" method="post">
								<input type="hidden" name="pid" value="${product.id}"/>									
								<table width="98%" border="0">
									<tr>
										<td>
											<select name="qty">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>																																																		
											</select>
										</td>
										<td>
											<a href="#" onclick="document.forms['addCartForm'].submit();"><img src="${setting.productdetailaddcarturl}" /></a>
										</td>								
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
		</div>
	</body>
</html>



