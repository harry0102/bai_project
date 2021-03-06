package com.pbtd.manager.vod.buss.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pbtd.manager.vod.buss.domain.Vodbussinfo;

@Mapper
public interface VodbussinfoMapper {

	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);

    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<Vodbussinfo> page(int start, int limit, Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<Vodbussinfo> find(Map<String, Object> queryParams);
    
    /**
     * 精确生成将要插入的记录的序号
     */
    int generatePosition(Map<String, Object> queryParams);

    /**
     * 根据标识获取记录
     */
    Vodbussinfo load(int id);

    /**
     * 插入记录
     */
    int insert(Vodbussinfo vodbussinfo);

    /**
     * 修改记录
     */
    int update(Vodbussinfo vodbussinfo);

	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);

}
