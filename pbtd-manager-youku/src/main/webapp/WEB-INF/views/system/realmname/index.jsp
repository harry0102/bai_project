<!--
        *  管理页面
        * 
        * @author admin
        *
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title> 管理</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=8,9,10" />
        <link rel="stylesheet" type="text/css" href="/js/common/themes/default/base.css">
        <link rel="stylesheet" type="text/css" href="/js/common/jquery-easyui-1.3.1/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="/js/common/jquery-easyui-1.3.1/themes/icon.css">
        <script type="text/javascript">
            //呈现顶端遮罩
            if (top.showMask) top.showMask();
        </script>
        <style type="text/css">
        a.l-btn span span.l-btn-text {
        width:60px;
        }
        </style>
    </head>
    <body class="easyui-layout" style="visibility:hidden">
        <div data-options="region:'center',border:false" style="padding:0px;">
            <table id="tables"></table>
        </div>
        <script type="text/javascript" src="/js/common/scripts/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="/js/common/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="/js/common/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.min.js"></script>
        <script type="text/javascript" src="/js/common/scripts/jquery-domain.min.js"></script>
          <script type="text/javascript" src="/js/common/jquery-easyui-1.3.1/common.js"></script>
        
        <script type="text/javascript"> 
            function getinfo() {
                var t = $('#tables');
                if(typeof($.data(t[0], 'datagrid')) == 'undefined') {
                	var customToolbar = [$.fn.domain.create,'-',$.fn.domain.edit,'-',$.fn.domain.del,'-',sysBtnreset];
                	t.domain('datagrid', {
                        title: '域名管理',
                    	url: '${pageContext.request.contextPath}/system/realmname/page',
                    	toolbar: customToolbar,
                        columns: [[
	                    	 {field: 'name', title: '名称', width: 100,   align: 'center'}
	                    	,{field: 'id', title: '标识', width: 100,   align: 'center', hidden: true}
	                    	,{field: 'oldtitle', title: '初始域名', width: 100, align: 'center', hidden: false }
	                    	,{field: 'newtitle', title: '更新域名', width: 100,   align: 'center', hidden: false}
	                   ]],
                        onLoadSuccess: function(data, status, XHR) {
                        },
                        onLoadError: function(XHR, status, errorThrow) {
                        },
                        names: [
         	                    ],
        	                     
                    });
                }
                else {
                    t.datagrid("load",{});
                }
            }
        	
        	$(function(){
        		//解析页面
                $.parser.parse();
                //显示隐藏页面
                $('body').css({ visibility: 'visible' });
                //移除顶端遮罩
                if (top.hideMask) top.hideMask();
                $table = $("#tables");
                //加载数据
                if($.fn.domain.defaults.datagrid.auto) getinfo();
            });
        	
        		//同步
             	var sysBtnreset=$.extend($.fn.domain.reset,{
             		title:'同步',
             		text:'同步',
             		iconCls:"icon-reset",
             		handler:function(){
             			$.ajax({
                           	url:"${pageContext.request.contextPath}/phonereset/resetlogo",
                           	type:"GET",
                           	dataType:"JSON",
                           	data:{},
                           	async:false,
                           	success:function(){
                           		 top.$.messager.alert("信息", "同步成功！", "info", null, 2000); 
                           	},
                           	error:function(XHR, status, errorThrow){
                           		
                           	}
                           }); 
             		},
             		scope:"all"
             	})
        
        </script>
    </body>
</html>
