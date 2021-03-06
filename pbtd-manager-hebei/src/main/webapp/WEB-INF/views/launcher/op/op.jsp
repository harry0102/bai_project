<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>运营位管理</title>
<%@ include file="/js/common/common.jsp"%>
<script type="text/javascript" src="/js/launcher/op/op.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false,split:true" style="padding:10px; border-bottom:0px solid #99BBE8; height:50px; width:auto;">
       	<span class="property">
        	分组-导航-模板：<input id="groupIdSearch" name="groupId" class="easyui-combobox" style="width: 140px; height: 25px">
        	<font>-</font>
        	<input id="navIdSearch" name="navId" class="easyui-combobox" style="width: 140px; height: 25px">
        	<font>-</font>
        	<input id="tempIdSearch" name="tempId" class="easyui-combobox" style="width: 140px; height: 25px;padding-left: 2px">
       	</span>
		<a id="conditionSearch">搜索</a>
		<a id="reload">刷新</a>
    </div>
	<div data-options="region:'center',border:false" style="padding:0px;">
		<table id="datagrid"></table>
	</div>
	<div id="addOrEditDialog">
		<form id="addOrEditFrom" method="post">
			<input id="op_id" type="hidden" name="id" />
			<input id="nav_id" type="hidden"/>
			<input id="group_id" type="hidden"/>
			<input id="temp_id" type="hidden"/>
			<input id="isCoyp" type="hidden"/>
			<input id="op_status" type="hidden"/>
			<div align="center" style="padding-top:10px">
				<table>
					<tr style="height: 30px">
						<td colspan="2">
							<input id="groupId" name="groupId" class="easyui-combobox" style="width: 100px;height:25px">
							<font>-</font>
							<input id="navId" name="navId" class="easyui-combobox" style="width: 100px;height:25px">
							<font>-</font>
							<input id="tempId" name="tempId" class="easyui-combobox" style="width: 100px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							运营位名称：<input id="operationName" name="operationName" class="easyui-textbox" style="width: 120px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td>
							图片标题：<input id="titleName" name="titleName" class="easyui-textbox" style="width: 100px;height:25px">
						</td>
						<td>
							内容看点：<input id="titleDetail" name="titleDetail" class="easyui-textbox" style="width: 100px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							是否显示图片标题：<input id="showTitle" name="showTitle" class="easyui-combobox" style="width: 80px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							默认焦点：<input id="optionFocus" name="optionFocus" class="easyui-combobox" style="width: 80px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td>
							播放时间：<input id="playTime" name="playTime" class="easyui-numberbox" style="width: 50px;height:25px">秒
						</td>
						<td>
							运营位位置：<input id="sortpos" name="sortpos" class="easyui-numberbox" style="width: 50px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td>
							显示类型：<input id="showType" name="showType" class="easyui-combobox" style="width: 80px;height:25px">
						</td>
						<td>
							是否显示焦点：<input id="focus" name="focus" class="easyui-combobox" style="width: 80px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td>
							运营位上边距：<input id="topMargin" name="topMargin" class="easyui-numberbox" style="width: 50px;height:25px">
						</td>
						<td>
							运营位左边距：<input id="leftMargin" name="leftMargin" class="easyui-numberbox" style="width: 50px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td>
							运营位宽度：<input id="width" name="width" class="easyui-numberbox" style="width: 50px;height:25px">
						</td>
						<td>
							运营位高度：<input id="height" name="height" class="easyui-numberbox" style="width: 50px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							跳转包名：<input id="packageName" name="packageName" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							跳转类名：<input id="className" name="className" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							跳转参数key值：<input id="paramKey" name="paramKey" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							跳转参数value值：<input id="paramValue" name="paramValue" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							视频地址：<input id="video" name="video" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
					<tr style="height: 30px">
						<td colspan="2">
							图片地址：<input id="image" name="image" class="easyui-textbox" style="width: 160px;height:25px">
						</td>
					</tr>
				</table>
			</div>
		</form>
		<div id="imageEditDiv">
			<hr>
			<div style="padding-top: 5px;padding-left: 5px">
				<a class="easyui-linkbutton" data-options="plain:false" onclick="imageAdd()">添加</a>
			</div>
			<table id="imageTable" style="padding-top: 5px;padding-left: 10px">
				<tbody id="imageTbody">
					<tr style="width: 482;height: 28" align="center">
						<td>
							多图：<input id='imageUrl' class="easyui-validatebox textbox" style="width: 160px;height:25px" data-options="type:'text'">
							<a data-myid="up" class="easyui-linkbutton" data-options="plain:false" onclick="imageUp(this)">上移</a>
							<a data-myid="down" class="easyui-linkbutton" data-options="plain:false" onclick="imageDown(this)">下移</a>
							<a data-inputid="imageUrl" data-myid="upload" class="easyui-linkbutton" onclick="fileuploadOpen(this)">重新上传</a>
							<a data-myid="remove" class="easyui-linkbutton" data-options="plain:false" onclick="imageRemove(this)">删除</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div id="fileuploadDialog"></div>
</body>
</html>