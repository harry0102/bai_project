<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
        *  新建页面
        * 
        * @author admin
        *
-->
<!DOCTYPE html>
<html>
<head>
<title>专题编辑 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=8,9,10" /> 
<link rel="stylesheet" type="text/css" href="/js/common/themes/default/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" href="/js/common/themes/default/bootstrapSwitch.css"></link>
  		<link rel="stylesheet" type="text/css" href="/js/common/themes/default/base.css">
        <link rel="stylesheet" type="text/css" href="/js/common/jquery-easyui-1.3.1/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="/js/common/jquery-easyui-1.3.1/themes/icon.css">
    	<script type="text/javascript" src="/js/common/scripts/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="/js/common/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="/js/common/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.min.js"></script>
        <script type="text/javascript" src="/js/common/scripts/jquery-domain.min.js"></script>
       
<style type="text/css">
td.tdCaption {
	text-align: center;
}
td.tdCaption span {
	color: #ff0000;
}
select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input {
	display: inline-block;
	height: 20px;
	padding: 0px;
	margin-bottom: 2px;
	margin-top: 2px;
	font-size: 14px;
	line-height: 20px;
	color: #555555;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	vertical-align: middle;
}
a.l-btn span span.l-btn-text {
	width: 35px;
}
.tdContent input {
	width: 300px;
}
</style>
</head>
<body class="easyui-layout" style="visibility:hidden">

<div data-options="region:'center',border:false" style="padding:0px;">
    <form id="vodSpecial"  accept-charset="utf-8" style="margin:10px; padding:0; visibility:hidden" method="post" autoTypeset="false" columnSize="2">
	<input type="hidden" id="id" name="id" />
			<table width="98%" cellspacing="1" cellpadding="3" class="tblMain" align="center">
			<tr>
				<td style="text-align: right; width: 20%"   style="width: 120px;" class="tdCaption"  align="center">
		名称
				</td>
				<td class="tdContent">
				<input type="text" id="name"name="name"  class="input text easyui-validatebox-disable"      style="" data-options="validType:'text[1,30]',required:true" />
				</td>
			</tr>
			 <tr>
				<td style="text-align: right; width: 15%"   style="width: 120px;" class="tdCaption"  align="center">
		看点
				</td>
				<td class="tdContent">
				<input type="text" id="viewPoint"name="viewPoint" class="input text easyui-validatebox-disable"       style="" data-options="validType:'text[1,80]',required:true" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 15%"   style="width: 120px;" class="tdCaption"  align="center">
		描述
				</td>
				<td class="tdContent">
				<input type="text" id="describes"name="describes"        style="" data-options="validType:'text[1,2000]',required:true" />
				</td>
			</tr>
				<tr>
				<td style="text-align: right; width: 15%"  class="tdCaption"  align="center">
		专题类型
				</td>
				<td class="tdContent">
				<select id="type" name="type"  style="width: 120px;" class="chzn-select">
						<option value="0">节目</option>
						<option value="1">直播</option>
						<option value="2">网页</option>
						<option value="3">频道</option>
					</select>
	</td>
			</tr>
				<tr>
				<td style="text-align: right; width: 15%"   style="width: 120px;" class="tdCaption"  align="center">
		网页跳转地址
				</td>
				<td class="tdContent">
				<input type="text" id="web_url"name="web_url" style="" data-options="validType:'text[1,200]',required:true" />
				</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 15%"  class="tdCaption"  align="center">
		排序
				</td>
				<td class="tdContent">
		<input type="text" id="sequence" name="sequence"class="easyui-numberbox"   style="width: 60px" data-options="min:1,max:999,required:true" />	
	</td>
			</tr>
			 
			<tr>
				<td style="text-align: right; width: 15%"  class="tdCaption"  align="center">
		模板类型
				</td>
				<td class="tdContent">
				<select id="template" name="template"  style="width: 120px;" class="chzn-select">
						<option value="1">背景专题</option>
						<option value="2">标题栏专题</option>
						<option value="3">网页专题</option>
						<option value="4">图文专题</option>
						<option value="5">其他</option>
					</select>
				</td>
			</tr>
			
				<tr>
				<td style="text-align: right; width: 15%"  class="tdCaption"  align="center">
		文字颜色
				</td>
				<td class="tdContent">
				<select id="textcolor" name="textcolor"  style="width: 120px;" class="color-select">
						<option value="0">黑色</option>
						<option value="1">白色</option>
					</select>
	</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 15%"  class="tdCaption"  align="center">
		状态
				</td>
				<td class="tdContent">
				<select id="status" name="status"  style="width: 120px;" class="chzn-select">
						<option value="0">下线</option>
						<option value="1">上线</option>
					</select>
	</td>
			</tr>
			</table>
    </form>
</div>
<div data-options="region:'south',border:false" style="height:35px;text-align:right; padding:5px 5px 0 0;background-color:#efefef;">
   <a id="btnSave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:false,disabled:true">保存</a>
   <a id="btnClose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false,disabled:true">关闭</a>
</div>
<script type="text/javascript">
	//页面初始化
   	$(function(){
	    	//解析页面
	        $.parser.parse();
	        var id = $.query.getId();
	        $('body').css({ visibility: 'visible' });
	        var t = $('#vodSpecial');
	        //加载数据
	        t.domain('load', {
	            url: '${pageContext.request.contextPath}/vod/tv/vodSpecial/load/' + id,
	            names: [],
	            onLoadSuccess: function(data, status, XHR) {
	                $('#btnSave').linkbutton('enable')[0].onclick = function() { save(); };
	                chosenCombox(data);  //初始化下拉框
	            },
	            onLoadComplete: function() {
	            	//关闭按钮
                	$('#btnClose').linkbutton('enable')[0].onclick = function() { $(parent).domain('closeDialog'); 
                	}
            }
        });
 
	
        //保存
        function save() {
        	if (t.form('validate') == false) {
        		return false;
        	}
            var data = t.domain('collect');
            $('#btnSave,#btnClose').linkbutton('disable');
	    //如果id为0，是要创建一条新记录，否则是whn
	    var  url= '${pageContext.request.contextPath}/vod/tv/vodSpecial/'+($.query.getId()=="0"?'create':'edit/'+id);  
		     t.domain('edit', {
	             title: ' ',
	             url: url,
	             data: data,
	             onBeforeLoad: function(XHR) {
	             },
	             onLoadSuccess: function(data, status, XHR) {
	             	$('#btnSave,#btnClose').linkbutton('enable');
	             	top.$.data(top.document.body, "domain.create.refresh","refresh");
	                 $(parent).domain('closeDialog');
	             },
	             onLoadError: function(XHR, statusText, errorThrow) {
	             	$('#btnSave,#btnClose').linkbutton('enable');
	             }
	         });
        }
  	});
</script>
