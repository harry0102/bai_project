<!--
        *  管理页面
        * 
        * @author admin
        *
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>版本管理</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8,9,10" />
<link rel="stylesheet" type="text/css"
	href="/js/common/themes/default/base.css">
<link rel="stylesheet" type="text/css"
	href="/js/common/jquery-easyui-1.3.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/js/common/jquery-easyui-1.3.1/themes/icon.css">
<script type="text/javascript">
            //呈现顶端遮罩
            if (top.showMask) top.showMask();
        </script>
</head>
<body class="easyui-layout" style="visibility: hidden">
	<div data-options="region:'north',border:false,split:true"
		style="padding: 0px; border-bottom: 1px so lid #99BBE8; height: 38px; width: auto;">
		<form id="formQuery" style="margin: 0; padding: 0" action=""
			method="post">
			<span class="property"> <label class="">商家名：</label> <input
				type="text" id="name" name="name" style="width: 200px;" />
			</span> <a href="javascript:getVodChannels()" id="btnSearch"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:false,disabled:false">查询</a>
		</form>
	</div>
	<div data-options="region:'center',border:false" style="padding: 0px;">
		<table id="vodchannels"></table>
	</div>
	<script type="text/javascript"
		src="/js/common/scripts/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="/js/common/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="/js/common/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.min.js"></script>
	<script type="text/javascript"
		src="/js/common/scripts/jquery-domain.min.js"></script>

	<script type="text/javascript"> 
            function getVodChannels() {
            	  var f = $('#formQuery');
            	 var queryParams = f.domain('collect');
            	 if (f.form('validate') == false) {
             		return false;
             	}
                var t = $('#vodchannels');
                if(typeof($.data(t[0], 'datagrid')) == 'undefined') {
                	var customToolbar = [$.fn.domain.create,'-',$.fn.domain.edit,'-',$.fn.domain.del,'-',sysExtend];
                	t.domain('datagrid', {
                        title: '商家版本管理',
                    	url: '${pageContext.request.contextPath}/live/VersionBussInfo/page',
                    	queryParams: queryParams,
                    	toolbar: customToolbar, 
                    	idField:"id",
                        columns: [[
	                    	{field: 'id', title: '编号', width: 100, sortable: true, align: 'center', hidden: false}
	                    	,{field: 'bussid', title: '商家id', width: 100, sortable: true, align: 'center', hidden: false}
	                    	,{field: 'name', title: '商家名称', width: 100, sortable: true, align: 'center', hidden: false}
	                    	,{field: 'versionid', title: '版本编号', width: 100, sortable: true, align: 'center', hidden: false}
	                    	,{field: 'versionname', title: '版本名称', width: 80, sortable: true, align: 'center', hidden: false}
	                 	 	,{field: 'createtime', title: '创建时间', width: 150, sortable: true, align: 'center', hidden: false}
	                    	,{field: 'updatetime', title: '修改时间', width: 150, sortable: true, align: 'center', hidden: false}
	                   ]],
                        onLoadSuccess: function(data, status, XHR) {
                        },
                        onLoadError: function(XHR, status, errorThrow) {
                        },
                        names: [
         	                    ],
        	                    subject: '频道管理',
        	                    onClickRow:function(index,row){
        	                    	$table.datagrid('unselectAll');
        	                    	$table.datagrid('selectRow', index).datagrid('beginEdit', index);
        	                    },
        	                    isHeaderMenu:false
                    });
                }
                else {
                    t.datagrid("load", queryParams);
                }
            }
        	
        	$(function(){
        		//解析页面
                $.parser.parse();
                //显示隐藏页面
                $('body').css({ visibility: 'visible' });
                //移除顶端遮罩
                if (top.hideMask) top.hideMask();
                $form = $("#formQuery");
                $table = $("#vodchannels");
                //加载数据
                if($.fn.domain.defaults.datagrid.auto) getVodChannels();
              
            });
        	
        	 
       	 //操作下发
       	 var  sysExtend=$.extend($.fn.domain.Btnsys,{
            	title:"下发",
           	text:"下发",
           	 iconCls:"icon-ok",
       		handler: function() {
       			var nodes =  $table.datagrid("getSelections");
       	    	if (!nodes || nodes.length == 0) {
       	            top.$.messager.alert("信息", "请您选择一条信息进进行下发操作", "info", null, 2000);
       	            return;
       	        } 
       	    	if(nodes.length>1){
       	    		 top.$.messager.alert("信息", "请只选择一条信息", "info", null, 2000);
       	    		 return;
       	    	}
       	    	var  id= nodes[0].bussid;
       	    	dataExtend(id)
               },
               scope:"one"
       	});
       	 
       	 
    	 function dataExtend(id){
 		  	$.ajax({
                	url:"${pageContext.request.contextPath}/live/DataExtend/version/"+id,
                	type:"GET",
                	dataType:"JSON",
                   	async:false,
                   	success:function(msg){
                   	 top.$.messager.alert("信息", "下发成功！", "info", null, 2000);
        	            return;
                   	},
                	error:function(XHR, status, errorThrow){
                		
                	}
                }); 
 	 }
        </script>
</body>
</html>
