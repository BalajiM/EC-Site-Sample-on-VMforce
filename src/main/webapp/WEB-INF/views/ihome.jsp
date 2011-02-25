<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html" charset="UTF-8">
		<meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
		<link rel="apple-touch-icon" href="http://iphone.hebita.jp/apple-touch-icon.png">
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
		
		
        <link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resources/iphone/jqtouch/jqtouch.css"/>
        <link type="text/css" rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resources/iphone/themes/jqt/theme.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/iphone/jqtouch/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/iphone/jqtouch/jqtouch.js"></script>		

		<script type="text/javascript" charset="utf-8">
			var jQT = $.jQTouch( {
		                statusBar: 'black',
		                startupScreen: 'http://thumbnail.image.rakuten.co.jp/@0_mall/jiaju/cabinet/dining/y07a-dt002a_2.jpg?_ex=320x320&s=2&r=1',
		                icon: 'http://profile.ak.fbcdn.net/hprofile-ak-snc4/27537_119925784688980_8584_q.jpg'
		            });
		</script>

		<title>Demo Site</title>
	</head>

	<body>

<!-- TOP Page -->
		<div id="top">
			<div class="toolbar">
				<h1>VMforce</h1>
				<a class="button slideup" id="infoButton" href="#aboutApp">This App</a>
			</div>
			<div>
				<ul>
					<li class="arrow"><a href="#aboutus" class="swap">${setting.iphonetab1}</a></li>
					<li class="arrow"><a href="#products" class="swap">${setting.iphonetab2}</a></li>
 					<li class="arrow"><a href="#contactus" class="swap">${setting.iphonetab3}</a></li>
					<li class="arrow"><a href="#information" class="swap">${setting.iphonetab4}</a></li>
				</ul>
			</div>
		</div>
<!-- TOP Page -->


<!-- About App Page -->
        <div id="aboutApp">
            <div class="toolbar">
                <h1>This App</h1>
                <a class="button back" href="#">${setting.iphonebackbtn}</a>
            </div>
            <div>
                <span class="itemDetailInfoValue"></span>${setting.iphonethisapp} | <a href="/sfdc.html" rel="external">template</a>
            </div>
        </div>
<!-- About App Page -->


<!-- About Us Page -->
		<div id="aboutus">
			<div class="toolbar">
				<a class="back slideup" href="#top">${setting.iphonebackbtn}</a>
				<h1>${setting.iphonetab1}</h1>
			</div>
			<span class="itemDetailInfoValue">${setting.iphonecompany}</span>
			
		</div>
<!-- About Us Page -->		


<!-- Contact Us Page -->
		<div id="contactus">
			<div class="toolbar">
				<a class="back slideup" href="#top">${setting.iphonebackbtn}</a>
				<h1>${setting.iphonetab3}</h1>
			</div><span class="itemDetailInfoValue">${setting.iphonecontactus}</span>


			<form action="isavefaq.html" method="POST" class="form">
			<ul>
				<li><input type="text" name="email" placeholder="${setting.iphonecontactusemail}"/></li>
				<li><input type="text" name="subject"  placeholder="${setting.iphonecontactussubject}"/></li>
				<li><input type="text" name="description"  placeholder="${setting.iphonecontactusdesc}"/></li>
				<li><a style="margin:0 10px;color:rgba(0,0,0,.9)" href="#" class="submit whiteButton">Submit</a></li>
				</ul>
			</form>

		</div>
<!-- Contact Us Page -->		


<!-- Information Page -->
		<div id="information">
			<div class="toolbar">
				<a class="back slideup" href="#top">${setting.iphonebackbtn}</a>
				<h1>${setting.iphonetab4}</h1>
			</div>
			<c:forEach items="${infos}" var="info">
				<span class="itemDetailInfoTitle">${info.name}</span><br/>
				<span class="itemDetailInfoValue">${info.description}</span></br></br>
			</c:forEach>			
		</div>
<!-- Information Page -->


<!-- Product List Page -->
        <div id="products">
            <div class="toolbar">
                <h1>${setting.iphonetab2}</h1>
                <a class="button back">${setting.iphonebackbtn}</a>
            </div>
            <ul class="rounded">
				<c:forEach items="${products}" var="product">
	                <li class="arrowd">
    	                <a id="${product.id}" href="#pid_${product.id}">
        	               <img src="${product.imgsmall}" style="width: 57px; height: 57px; float: left"/>
            	            <div style="font-size: 14px; text-overflow: ellipsis; overflow: hidden; width:190px; margin-left: 15px;"><BR/>
	                    	    ${product.name}<BR/>${product.price}
    	                    </div>
        	                <div style="clear: left"></div>
            	        </a>
                	</li>
				</c:forEach>
            </ul>
        </div>		
<!-- Product List Page -->


<style type="text/css">
.itemDetailImage {
    width:250px; height:250px;
}
.itemDetailInfoTitle {
    text-shadow: rgba(0, 0, 0, 0.199219) 0px 1px 1px;
    font: normal normal bold 14px/normal Helvetica;
    color: white;
}
.itemDetailInfoValue {
    text-shadow: rgba(0, 0, 0, 0.199219) 0px 1px 1px;
    font: normal normal normal 14px/normal Helvetica;
    color: white;
}
</style>

 
<!-- Product Detail Page -->
		<c:forEach items="${products}" var="product">
        	<div id="pid_${product.id}">
            	<div class="toolbar">
                	<h1>${product.name}</h1>
                	<a class="button back">${setting.iphonebackbtn}</a>
            	</div>
	            <ul class="rounded">
    	            <li>
        	            <img src="${product.imgsmall}" class="itemDetailImage"/>
            	    </li>
            	</ul>
            	<ul class="rounded">
                	<li><span class="itemDetailInfoTitle">Price: </span><span class="itemDetailInfoValue">${product.price}</span></li>
            	</ul>
            	<ul class="rounded">
                	<li><span class="itemDetailInfoTitle">Desc: </span><span class="itemDetailInfoValue">${product.description}</span></li>
            	</ul>
        	</div>
		</c:forEach>
<!-- Product Detail Page -->

</body>
</html>