package com.pbtd.manager.vod.phone.common.service.face;

import java.util.List;
import java.util.Map;

import com.pbtd.manager.vod.phone.common.domain.Vodchannel;
public interface IVodChannelService  {

	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);

    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<Vodchannel> page(int start, int limit, Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<Vodchannel> find(Map<String, Object> queryParams);
    
    /**
     * 精确生成将要插入的记录的序号
     */
    int generatePosition(Map<String, Object> queryParams);

    /**
     * 根据标识获取记录
     */
    Vodchannel load(int id);
    int updateimg(Map<String,Object> Map);
    /**
     * 插入记录
     */
    int insert(Vodchannel vodchannel);
    int insertjson(Vodchannel vodchannel);

    /**
     * 修改记录
     */
    int update(Vodchannel vodchannel);

	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);
    
    /**
     *批量上线下线 
     */
    int updatestatus(Map<String,Object> map);
    
    //插入绑定专辑信息
    int insertalbum(Map<String, Object> map);
    //更改绑定信息排序
    int updatealbumsequence(Map<String, Object> map);
    //删除绑定信息
   int  deletesalbum(Map<String, Object> map);
    //绑定信息查询
    int countalbum(Map<String, Object> queryParams);
    //绑定信息查询
    List<Map<String, Object>> pagealbum(Map<String, Object> queryParams);
    //查询绑定信息的最大和最小排序
    Map<String, Object> findalbummaxVSminsequence(Map<String, Object> map);
    //查询更改数据的历史排序
    List<Map<String, Object>> findalbumsequencesum(Map<String, Object> queryParams);
    //查询绑定信息排序
    List<Map<String, Object>> findalbumsequence(Map<String, Object> map);
    //查询频道排序
    Map<String, Object> findsequence(Map<String, Object> map);
    //查询频道排序的最大值和最小值
    Map<String, Object> findchannelmaxVSminsequence(Map<String, Object> map);
   //查询频道更改数据的历史排序
    List<Map<String, Object>> findchannelsequencesum(Map<String, Object> queryParams);
   //查询频道排序
    List<Map<String, Object>> findchannelsequence(Map<String, Object> map);
  //以下为频道绑定标签
    List<Map<String, Object>> pagelabelforchannel(Map<String, Object> map);
    int countlabelforchannel(Map<String, Object> map);
    int addbindinglabel (Map<String, Object> map);
    int deletebindinglabel(Map<String, Object> map);
    //更改排序
    int updatebindinglabel(Map<String,Object> map);
    //以下为频道绑定标签自动排序
    //查询频道绑定标签排序的最大值和最小值
    Map<String, Object> findchannellabelmaxVSminsequence(Map<String, Object> map);
   //查询绑定标签更改数据的历史排序
    List<Map<String, Object>> findchannellabelsequencesum(Map<String, Object> queryParams);
   //查询绑定标签 排序
    List<Map<String, Object>> findchannellabelsequence(Map<String, Object> map);
}
