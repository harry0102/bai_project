package com.pbtd.playclick.integrate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbtd.playclick.integrate.domain.VodLabeltype;
import com.pbtd.playclick.integrate.mapper.VodLabeltypeMapper;
import com.pbtd.playclick.integrate.service.face.IVodLabeltypeService;

@Service
public class VodLabeltypeService implements IVodLabeltypeService {
     
	@Autowired
	private  VodLabeltypeMapper vodlabeltypemapper;
	
	@Override
	public int count(Map<String, Object> queryParams) {
		
		return vodlabeltypemapper.count(queryParams);
	}

	@Override
	public List<VodLabeltype> page(Map<String, Object> queryParams) {
		
		return vodlabeltypemapper.page(queryParams);
	}

	@Override
	public VodLabeltype load(int id) {
		
		return vodlabeltypemapper.load(id);
	}

	@Override
	public int insert(VodLabeltype VodLabeltype) {
		
		return vodlabeltypemapper.insert(VodLabeltype);
	}

	@Override
	public int update(VodLabeltype VodLabeltype) {
		
		return vodlabeltypemapper.update(VodLabeltype);
	}

	@Override
	public int deletes(Map<String, Object> ids) {
		
		return vodlabeltypemapper.deletes(ids);
	}

}
