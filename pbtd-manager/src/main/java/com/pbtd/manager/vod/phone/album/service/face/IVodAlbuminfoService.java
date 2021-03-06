package com.pbtd.manager.vod.phone.album.service.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pbtd.manager.vod.phone.album.domain.Vodalbuminfo;

@Mapper
public interface IVodAlbuminfoService  {

	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);
    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<Vodalbuminfo> page(Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<Vodalbuminfo> find(Map<String, Object> queryParams);
   

    /**
     * 根据标识获取记录
     */
    Vodalbuminfo load(int id);

    /**
     * 插入记录
     */
    int insert(Vodalbuminfo vodalbuminfo);

    /**
     * 修改记录
     */
    int update(Vodalbuminfo vodalbuminfo);
    /**
     * 批量上下线
     */
    int updatestatus(Map<String, Object> queryParams);

	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);
    int updatesequce(Map<String, Object> queryParams);
    int addsequce(Map<String, Object> queryParams);
    Map<String,Object> loadVideo(int id);
    List<Map<String, Object>> findAlbumsinfovideo(Map<String, Object> queryParams);
    /**
     * 关联推荐 
     * @param queryParams
     * @return
     */
    List<Map<String,Object>> pageAlbumsinfovideo(Map<String, Object> queryParams);
    List<Map<String,Object>> recommandalbum(Map<String,Object> queryParams);
    int countAlbumsinfovideo(Map<String, Object> queryParams);
    int insertvideo(Map<String, Object> queryParams);
    int deletesvideo(Map<String, Object> queryParams);
    /**
     * 编辑剧集
     * 
     */
    int updatevideo(Map<String,Object> queryParams);
    /**
     * 节目关联推荐剧集
     * 
     */
    List<Map<String,Object>> pagealbum(Map<String,Object> queryParams);
    int updatealbumsequence(Map<String,Object>queryParams);
    int countalbum(Map<String,Object> queryParams);
    int addalbum(Map<String,Object> queryParams);
    int deletealbum(Map<String,Object> queryParams);
    //查询绑定信息排序
    List<Map<String, Object>> findalbumsequence(Map<String, Object> map);
    //查询绑定信息的最大和最小排序
    Map<String, Object> findalbummaxVSminsequence(Map<String, Object> map);
  //查询更改数据的历史排序
    List<Map<String, Object>> findalbumsequencesum(Map<String, Object> queryParams);
    /**
     * 专辑绑定角标
     */
    int updatecorner(String albumid,String cornerid);
    /**
     * 专辑绑定付费包
     */
    int updatecollectfeesbag(String albumid,String collectid);
    
    //更改是否显示
    int updateisshow(Map<String,Object> map);
    //更改是否正片
    int updateisPositive(Map<String,Object> map);
}
