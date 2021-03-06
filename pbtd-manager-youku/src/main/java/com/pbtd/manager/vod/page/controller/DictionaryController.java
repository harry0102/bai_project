package com.pbtd.manager.vod.page.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbtd.manager.base.common.easyui.ComboBoxOptionModel;
import com.pbtd.manager.base.common.web.RequestUtil;
import com.pbtd.manager.vod.page.domain.Dictionary;
import com.pbtd.manager.vod.page.service.face.IDictionaryService;

@Controller("pbtdController.DictionaryController")
@RequestMapping("/pbtd")
public class DictionaryController {

	@Autowired
	private IDictionaryService dictionaryService;

	/**
	 * 数据字典下拉框方式展示
	 * @param obj 数据库对象名例如T_ZXBZ_ZZMM,则obj为Zzmc
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/dictionary/{obj}")
	public List<ComboBoxOptionModel> findDictionary(@PathVariable("obj")String obj,HttpServletRequest request){
		Map<String,Object> params = RequestUtil.asMap(request);
		List<ComboBoxOptionModel> comboBox = new ArrayList<ComboBoxOptionModel>();
		ComboBoxOptionModel option;
		List<Dictionary> dics = this.dictionaryService.findDictionary(params, obj);
		for(Dictionary d:dics){
			option = new ComboBoxOptionModel();
			option.setText(d.getName());
			option.setValue(d.getId()+"");
			option.setExtraField1(d.getExtract());
			comboBox.add(option);
		}
		return comboBox;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/findDictionaryMap/{obj}")
	public List<Map<String,Object>> findDictionaryMap(@PathVariable("obj")String obj,HttpServletRequest request){
		Map<String,Object> params = RequestUtil.asMap(request);
		List<Map<String,Object>> dics = this.dictionaryService.findDictionaryMap(params, obj);
		return dics;
	}
}
