package com.pbtd.manager.live.util;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pbtd.manager.live.domain.LiveCibnEpg;
import com.pbtd.manager.live.domain.LivePackage;
import com.pbtd.manager.live.domain.LivePackageMQ;
import com.pbtd.manager.live.domain.LiveProgram;
import com.pbtd.manager.live.domain.LiveVideo;
import com.pbtd.manager.live.mapper.LivePackageMapper;
import com.pbtd.manager.live.mapper.LiveProgramMapper;
import com.pbtd.manager.live.mapper.LiveVideoMapper;
import com.pbtd.manager.live.mapper.LiveCibnEpgMapper;


/**
 * 从中心平台 自动获取数据的类
 * @author PBTD
 *
 */
@Service
public class GetAutomaticData{
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	private GethttpObjectUtil gethttpObjectUtil;	

	@Autowired
	private LivePackageMapper livePackageMapper;
	@Autowired
	private LiveVideoMapper liveVideoMapper;
	@Autowired
	private LiveProgramMapper liveProgramMapper;
	@Autowired
	private LiveCibnEpgMapper LiveCibnEpgMapper;
	@Autowired
	private SearchLiveController SearchLiveController;


	public void getCibnEpg() throws JSONException{
		String jsonString = gethttpObjectUtil.gethttpObject("/cibnepginterface/");
		if (!jsonString.equals("") && jsonString != null) {
			JSONObject json =new  JSONObject(jsonString);
			String code = json.get("code") == null ? "0" : json.get("code").toString();// 是否返回正确数据
			logger.info("响应code值:"+code);
			if (code.equals("1")) {
				JSONArray jsonObjlist = json.getJSONArray("data");
				for (int i = 0; i < jsonObjlist.length(); i++) {
					JSONObject job = jsonObjlist.getJSONObject(i);
					LiveCibnEpg liveCibnEpg = JSON.parseObject(job.toString(), LiveCibnEpg.class);
					logger.info("响应code值:"+code);
					if(liveCibnEpg != null){
						LiveCibnEpg  list = LiveCibnEpgMapper.selectByPrimaryKey(liveCibnEpg);
						if(list != null ){
							logger.info("已存在该节目包数据:"+liveCibnEpg.getEpgname());
						}else{
							LiveCibnEpgMapper.insert(liveCibnEpg);
						}
					}
				}
			} else {
				logger.info("响应错误");
			}
		}
	}
	
	
	public void getPackage() throws JSONException{
		String jsonString = gethttpObjectUtil.gethttpObject("/packageinterface/");
		if (!jsonString.equals("") && jsonString != null) {
			JSONObject json =new  JSONObject(jsonString);
			String code = json.get("code") == null ? "0" : json.get("code").toString();// 是否返回正确数据
			logger.info("响应code值:"+code);
			if (code.equals("1")) {
				JSONArray jsonObjlist = json.getJSONArray("data");
				List<LivePackageMQ> MQlist = new ArrayList<>();
				for (int i = 0; i < jsonObjlist.length(); i++) {
					JSONObject job = jsonObjlist.getJSONObject(i);
					LivePackage livepackage = JSON.parseObject(job.toString(), LivePackage.class);
					logger.info("响应code值:"+code);
					if(livepackage != null){
						List<LivePackage>  list = livePackageMapper.selectByPrimaryKey(livepackage);
						if(list.size() != 0 ){
							logger.info("已存在该节目包数据:"+livepackage.getPackagename());
						}else{
							livePackageMapper.insert(livepackage);
							LivePackageMQ listpackagemq = new LivePackageMQ();
							listpackagemq.setPackageid(livepackage.getPackageid());
							listpackagemq.setChncode(livepackage.getChncode());
							listpackagemq.setPackagename(livepackage.getPackagename());
							listpackagemq.setPackageposter(livepackage.getPackageposter());
							MQlist.add(listpackagemq);
						}
					}
				}
				logger.info("+===============++++:"+MQlist.toString());
				String mq = JSON.toJSON(MQlist).toString();
				logger.info("发送mq："+mq);
				logger.info("发送mq开始：");
				try {
					SearchLiveController.liveIndexAdd(mq);
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("直播节目包 发送mq出现错误");
				}
				logger.info("发送mq成功");
			} else {
				logger.info("响应错误");
			}
		}
	}

	public void getProgram() throws JSONException{
		String jsonString = gethttpObjectUtil.gethttpObject("/programinterface/");
		if (!jsonString.equals("") && jsonString != null) {
			JSONObject json =new  JSONObject(jsonString);
			String code = json.get("code") == null ? "0" : json.get("code").toString();// 是否返回正确数据
			logger.info("响应code值:"+code);
			if (code.equals("1")) {
				JSONArray jsonObjlist = json.getJSONArray("data");
				for (int i = 0; i < jsonObjlist.length(); i++) {
					JSONObject job = jsonObjlist.getJSONObject(i);
					LiveProgram liveprogram = JSON.parseObject(job.toString(), LiveProgram.class);
					logger.info("响应code值:"+code);
					if(liveprogram != null){
						List<LiveProgram>  list = liveProgramMapper.selectByPrimaryKey(liveprogram);
						if(list.size() != 0 ){
							logger.info("已存在该节目单数据:"+liveprogram.getProgramname());
						}else{
							liveProgramMapper.insert(liveprogram);
						}
					}
				}
			} else {
				logger.info("响应错误");
			}
		}
	}

	
	public void getVideo() throws JSONException{
		String jsonString = gethttpObjectUtil.gethttpObject("/videointerface/");
		if (!jsonString.equals("") && jsonString != null) {
			JSONObject json =new  JSONObject(jsonString);
			String code = json.get("code") == null ? "0" : json.get("code").toString();// 是否返回正确数据
			logger.info("响应code值:"+code);
			if (code.equals("1")) {
				JSONArray jsonObjlist = json.getJSONArray("data");
				for (int i = 0; i < jsonObjlist.length(); i++) {
					JSONObject job = jsonObjlist.getJSONObject(i);
					LiveVideo liveVideo = JSON.parseObject(job.toString(), LiveVideo.class);
					logger.info("响应code值:"+code); 
					if(liveVideo != null){
						List<LiveVideo>  list = liveVideoMapper.selectByPrimaryKey(liveVideo);
						if(list.size() != 0 ){
							logger.info("已存在该剧集数据:"+liveVideo.getTitle());
						}else{
							liveVideoMapper.insert(liveVideo);
						}
					}
				}
			} else {
				logger.info("响应错误");
			}
		}
	}
	
	public void deleteAll() throws JSONException{
		List<LivePackage>  list = livePackageMapper.selectTimeOut();
		StringBuffer sb = new StringBuffer();
		for (LivePackage livePackage : list) {
			sb.append(livePackage.getPackageid());
			sb.append(",");
		}
		String aaaaa  = "1346444,1346412,1346436,";
		logger.info("+===============++++:"+sb.toString());
		String mq = sb.toString();
		logger.info("发送mq："+aaaaa);
		logger.info("发送mq开始：");
		try {
			SearchLiveController.deleteLiveIndex(aaaaa);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("直播节目包 发送mq出现错误");
		}
		logger.info("发送mq成功");
		int aa  = livePackageMapper.deleteTimeOut();
		logger.info("数据库package删除"+aa+"条数据" );	
		
		
		int bb  = liveVideoMapper.deleteTimeOut();
		logger.info("数据库video删除"+bb+"条数据" );		
		int cc  = liveProgramMapper.deleteTimeOut();
		logger.info("数据库program删除"+cc+"条数据" );		
		int dd  = LiveCibnEpgMapper.deleteTimeOut();
		logger.info("数据库program删除"+dd+"条数据" );		
	}


}
