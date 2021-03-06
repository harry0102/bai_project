package com.pbtd.manager.vod.tv.album.service.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pbtd.manager.vod.tv.album.domain.VodTvAlbuminfovideo;

@Mapper
public interface IVodTvAlbuminfovideoService  {

	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);
    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<VodTvAlbuminfovideo> page(int start, int limit, Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<VodTvAlbuminfovideo> find(Map<String, Object> queryParams);
    
    /**
     * 精确生成将要插入的记录的序号
     */
    int generatePosition(Map<String, Object> queryParams);

    /**
     * 根据标识获取记录
     */
    VodTvAlbuminfovideo load(int id);

    /**
     * 插入记录
     */
    int insert(VodTvAlbuminfovideo vodTvAlbuminfovideo);

    /**
     * 修改记录
     */
    int update(VodTvAlbuminfovideo vodTvAlbuminfovideo);

	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);
    int updatesequce(Map<String, Object> queryParams);
    int addsequce(Map<String, Object> queryParams);
}
