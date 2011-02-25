<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="javascript/default.js"></script>

<!-- <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css" /> -->

<style type="text/css">  

body{
	color:#000000;
	}
a{
	color:#0099FF;
	}
a:hover{
	color:#FF9900;
	text-decoration:underline;
	}
*{ margin:0; padding:0;}
img{ border:0;}

table,div{
	margin:auto;
	}
body {
	font-size:12px;
	*font-size:80%;
	*font:80%;
	font-family:'メイリオ',Meiryo,'ＭＳ Ｐゴシック',sans-serif;
	 background-color: #${setting.cssbodybg}; //iwaya   
}
body{
	text-align:center;
	}

.CNT{
	text-align:center;
	}
.L{
	text-align:left;
	}
.R{
	text-align:right;
	}
.clr_sps{ clear:both; font-size:1px;}
#container{
	width:800px;
	margin:auto;
	text-align:left;
	 background-color: #${setting.csscontainerbg}; // iwaya
	}
#innercontainer{
	width:740px;
	margin:auto;
	text-align:left;
	 background-color: #${setting.csscontainerbg}; // iwaya
	}	
	
h1{
	height:20px;
	line-height:20px;
	font-size:11px;
	color:#333333;
	font-weight:normal;
	text-indent:0px;
	}
h2{
	margin:0 0 0 0px;
	height:38px;
	font-weight:normal;
	background:url(${pageContext.request.contextPath}/resources/img/common/bg_h1.gif) no-repeat;
	text-indent:62px;
	padding:6px 0 0 0;
	}
h2 a{
	font-size:25px;
	line-height:38px;
	vertical-align:top;
	text-decoration:none;
	color:#333333;
	}
h2 a:hover{
	color:#333333;
	text-decoration:none;
	}
#head_menu{
	width:740px;
	background:url(${pageContext.request.contextPath}/resources/img/common/bg_head_menu.jpg) repeat-x;
	text-align:right;
	font-size:10px;
	line-height:25px;
	color:#FFFFFF;
	}
#head_menu a{
	color:#000000;
	font-size:12px;
	letter-spacing:1px;
	text-decoration:none;
	height:25px;
	vertical-align:middle;
	margin:0 4px 0 4px;
	}
#head_menu a:hover{
	color:#FF0066;
	}
#contents{
	margin:6px 0 20px 0;
	clear:left;
	}
#main_image{
	background:url(${pageContext.request.contextPath}/resources/img/top/bg_main_pic.gif) no-repeat;
	width:740px;
	height:194px;
	margin:16px 0 20px 0;
	padding:8px 7px 6px 7px;
	}

#copy{
	height:20px;
	font-size:10px;
	text-align:right;
	color:#333333;
	border:solid #333333;
	border-width:3px 0 0 0;
	padding:2px;
	clear:left;
	}
#copy a{
	color:#333333;
	text-decoration:none;
	}
#copy a:hover{
	color:#333333;
	}
#top{
	}
#top h3{
	font-size:22px;
	line-height:1.2em;
	color:#333333;
	font-weight:normal;
	}
#top p{
	line-height:1.6em;
	}
#top div#top_btm{
	zoom:100%;
	}
#top div#top_btm:after{
	content: "";
    clear: both;
    height: 0;
    display: block;
    visibility: hidden;
	}
#top div#left{
	float:left;
	width:398px;
	}
#top div#left h4{
	font-size:12px;
	margin:6px 0 0 0;
	}
#top div#left div#info{
	background:url(${pageContext.request.contextPath}/resources/img/top/bg_info.gif);
	width:398px;
	}
#top div#left div#info div#main{
	background:url(${pageContext.request.contextPath}/resources/img/top/bg_info_main.gif) repeat-y;
	text-align:left;
	}
#top div#left div#info div#main h5{
	padding:8px 10px 0 10px;
	font-size:80%;
	}
#top div#left div#info div#main p{
	padding:2px 10px 0 10px;
	}
#top div#right{
	float:left;
	width:230px;
	margin:0 0 0 20px;
	}
#top div#right div#bnr_sps{}
#top div#right div#bnr_sps p{
	width:318px;
	height:105px;
	margin:12px 0px 0 0px;
	text-align:center;
	}
#top div#right div#bnr_sps p a{
	background:url(${pageContext.request.contextPath}/resources/img/top/bg_bnr.jpg) no-repeat;
	display:block;
	width:318px;
	height:105px;
	line-height:105px;
	color:#666666;
	font-size:20px;
	font-weight:bold;
	text-decoration:none;
	text-indent:10px;
	}
#top div#right div#bnr_sps p a:hover{
	font-size:16px;
	filter:alpha(opacity=75); /*IE*/
	-moz-opacity:0.75; /*FF*/
	}
#main_image2{
	background:url(${pageContext.request.contextPath}/resources/img/top/bg_main_pic.gif) no-repeat;
	width:740px;
	height:194px;
	margin:16px 0 0 0;
	padding:8px 7px 6px 7px;
	}
#main_image2 h2{
	background:url(${pageContext.request.contextPath}/resources/img/common/main_pic01.jpg) no-repeat;
	width:726px;
	height:180px;
	font-size:25px;
	color:#ffffff;
	font-weight:normal;
	text-align:right;
	padding:120px 30px 0 0;
	}
#main_image2 h2.t_bk{
	color:#000000;
	}
#main_image2 h2.t_wt{
	color:#FFFFFF;
	}
#other_page{}

#other_page h3{
	background:url(${pageContext.request.contextPath}/resources/img/common/bg_h3a.jpg) no-repeat;
	text-indent:20px;
	font-size:100%;
	color:#333333;
	margin:20px 0 0 0;
	line-height:1.5em;
	}
#other_page h4{
	font-size:100%;
	line-height:1.0em;
	vertical-align:top;
	margin:14px 0 0 0;
	color:#003366;
	}
#other_page div.typeA{
	}
#other_page div.typeA p{
	margin:8px 6px 10px 6px;
	line-height:180%;
	}
#other_page div.typeB{
	margin:8px 0 10px 0;
	line-height:160%;
	zoom:100%;
	}
#other_page div.typeB:after{
	content: "";
    clear: both;
    height: 0;
    display: block;
    visibility: hidden;
	}
#other_page div.typeB p{
	margin:8px 6px 10px 6px;
	line-height:180%;
	}
#other_page div.typeB div.left{
	float:left;
	width:360px;
	}
#other_page div.typeB div.right{
	float:right;
	width:360px;
	margin:0 0 0 20px;
	}
#other_page p.margin_none{ margin:0;}
#other_page p{ margin:6px 0 0 0;}
#tbl_setA{
	border:#0099CC solid 1px;
	border-collapse:collapse;
	margin:0;
	}
#tbl_setA th{
	border:#0099CC solid 1px;
	background:url(${pageContext.request.contextPath}/resources/img/bg_th_a.gif);
	padding:6px;
	color:#003366;
	text-align:center;
	}
#tbl_setA td{
	border:#0099CC solid 1px;
	padding:6px;
	}

/* copyrights */
#copyright{
	float: right;
}
#copyright a{
    display: inline;
    font-size: 9px;
    text-decoration: none;
}
#copyright_box{
	width: 28px;
	height: 11px;
}
#copyright p a{
	background: url(http://pondt.com/img/logo.gif) bottom no-repeat;
	width: 28px;
	float: left;
	text-indent: -9999px;
}
*:first-child+html #copyright_box{
	float:right;
}
#menu2 ul{
    list-style: none;
}
#menu2 li{
    float: left;
    margin: 0 2px;
}
.submenu{
    list-style: none;
    border: 1px solid #cccccc;
    background: #ffffff;
    visibility: hidden;
    position: absolute;
    right: 0px;
    z-index: 1;
}


table.table5{
     font-family:arial;
     border-collapse:collapse;
     font-size:10pt;
     background-color:#ffffff;
     border-style:solid;
     border-color:#DBDBDB;
     border-width:1px;
}
td.table5{
     color:black;
     border-style:solid;
     border-width:1px;
     border-color:#DBDBDB;
     padding:5px 2px 4px 5px;
}

</style> 