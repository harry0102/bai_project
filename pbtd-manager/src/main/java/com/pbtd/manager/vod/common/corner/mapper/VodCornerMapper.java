package com.pbtd.manager.vod.common.corner.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pbtd.manager.vod.common.corner.domain.VodCorner;

@Mapper
public interface VodCornerMapper {

	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);

    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<VodCorner> page(Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<VodCorner> find(Map<String, Object> queryParams);
    
    /**
     * 精确生成将要插入的记录的序号
     */
    int generatePosition(Map<String, Object> queryParams);

    /**
     * 根据标识获取记录
     */
    VodCorner load(int id);

    /**
     * 插入记录
     */
    int insert(VodCorner vodCorner);

    /**
     * 修改记录
     */
    int update(VodCorner vodCorner);
    /**
     * 批量上线下线
     */
   int updateStatus(Map<String,Object> map);
	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);
    
    /**
     * 模糊统计符合查询条件的记录总数
     */
    int countCorner(Map<String, Object> queryParams);

	/**
     * 精确获取符合查询条件的记录
     */
    List<VodCorner> findCorner(Map<String, Object> queryParams);
}
