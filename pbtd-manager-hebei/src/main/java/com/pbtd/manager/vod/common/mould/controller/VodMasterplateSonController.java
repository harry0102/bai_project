package com.pbtd.manager.vod.common.mould.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbtd.manager.base.common.web.RequestUtil;
import com.pbtd.manager.util.LogAnnotation;
import com.pbtd.manager.vod.common.mould.domain.vodMasterplateSon;
import com.pbtd.manager.vod.common.mould.service.face.IvodMasterplateInterface;
import com.pbtd.manager.vod.common.mould.service.face.IvodMasterplateSonInterface;
import com.pbtd.manager.vod.page.PageResult;
import com.pbtd.manager.vod.page.QueryObject;
/**
 * @author zr
 */
@Controller 
@RequestMapping("/vod/MasterplateSon")
public class VodMasterplateSonController {

     @Autowired
    private IvodMasterplateInterface  vodTvMasterplateInterface; 
    
    @Autowired
    private IvodMasterplateSonInterface  vodTvMasterplatesonInterface;
    /**
     * GET 查询
     *
     * @return 视图路径
     */
    @RequestMapping(value = {"/index", ""})
    public String index(Model model) {
    	Map<String, Object> params=new HashMap<>();
    	model.addAttribute("masterplatelist", vodTvMasterplateInterface.find(null));
    	return "/vod/system/MasterplateSon/index";
    }

    /**
     * GET 创建
     *
     * @return 视图路径
     */
    @RequestMapping("/create")
    public String create() {
        return "/vod/system/MasterplateSon/create";
    }

    /**
     * GET 编辑
     *
     * @param id 标识
     * @return 视图路径
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model) {
    	Map<String, Object> params=new HashMap<>();
    	model.addAttribute("masterplatelist", vodTvMasterplateInterface.find(null));
        return "/vod/system/MasterplateSon/edit";
    }

    /**
     * 模糊统计符合查询条件的记录总数
     *
     * @param request 查询参数
     * @return 记录总数
     */
    @ResponseBody
    @RequestMapping("/count")
    public int count(HttpServletRequest request) {
        return this.vodTvMasterplatesonInterface.count(RequestUtil.asMap(request, false));
    }

    /**
     * 模糊获取符合查询条件的分页记录
     * 
     * @param page 页码
     * @param limit 页长
     * @param request 查询参数
     * @return 记录列表
     */
    @ResponseBody
    @RequestMapping("/page")
    public PageResult page(@RequestParam(value="page")int page, @RequestParam(value="rows")int limit, HttpServletRequest request) {
    	List<vodMasterplateSon> data = new ArrayList<vodMasterplateSon>();
    	Map<String, Object> queryParams = RequestUtil.asMap(request, false);
        int total = this.vodTvMasterplatesonInterface.count(queryParams);
		if (total == 0) {
			return new PageResult(total, Collections.EMPTY_LIST);
		}
		QueryObject qo=new QueryObject();
		qo.setPage(page);
		qo.setRows(limit);
		queryParams.put("start", qo.getStart());
		queryParams.put("pageSize", qo.getPageSize());
			data =this.vodTvMasterplatesonInterface.find(queryParams);
			return new PageResult(total, data);
		
    }

    /**
     * 根据标识获取记录
     *
     * @param id 标识
     * @return 记录
     */
    @ResponseBody
    @RequestMapping("/load/{id}")
    public vodMasterplateSon load(@PathVariable("id") int id) {
    	vodMasterplateSon v = null;
        if (id > 0) {
        	v = this.vodTvMasterplatesonInterface.load(id);
        } 
        else {
        	v = new  vodMasterplateSon(); 
        }
        return v;
    }

    /**
     * 插入记录
     *
     * @param vodChannel VodChannel实例
     * @return 被插入的记录标识
     */
    @LogAnnotation(operationInfo = "点播-tv-模板管理-添加频道操作")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(vodMasterplateSon v, HttpServletRequest request) {
    	Map<String,Object> map=new HashMap<String,Object>();
        this.vodTvMasterplatesonInterface.insert(v);
        return 1;
    }

    /**
     * POST 编辑
     *
     * @param id 标识
     * @param vodChannel VodChannel实例
     * @return int 被修改的记录条数
     * @throws ServletException
     */
    @LogAnnotation(operationInfo = "点播-tv-模板管理-更改频道操作")
    @ResponseBody
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public int edit(@PathVariable("id") int id, vodMasterplateSon v) throws ServletException {
    	return this.vodTvMasterplatesonInterface.update(v);
    }

    /**
     * POST 删除多条
     *
     * @param ids 标识列表
     * @return 被删除的记录条数
     */
    @LogAnnotation(operationInfo = "点播-tv-模板管理-删除频道操作")
    @ResponseBody
    @RequestMapping("/deletes")
    public int deletes(HttpServletRequest request) {
    	Map<String, Object> queryParams = RequestUtil.asMap(request, false);
    	   if(queryParams.get("id")!=null){
    		   String[] ids=queryParams.get("id").toString().split(",");
    		   for(String num:ids){
    	           int id=Integer.parseInt(num);
    	           queryParams.put("id", id);
    	           this.vodTvMasterplatesonInterface.delete(queryParams);
    	           }
    	   } 
           
           return 1;
    }
    
    
    
    
    
    
}
