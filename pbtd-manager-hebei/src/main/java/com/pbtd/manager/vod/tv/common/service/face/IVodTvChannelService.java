package com.pbtd.manager.vod.tv.common.service.face;

import java.util.List;
import java.util.Map;

import com.pbtd.manager.vod.tv.common.domain.VodTvchannel;
public interface IVodTvChannelService  {
	  int updateimg(Map<String,Object> Map);
	/**
     * 模糊统计符合查询条件的记录总数
     */
    int count(Map<String, Object> queryParams);

    /**
     * 模糊获取符合查询条件的分页记录
     * @return 记录列表
     */
    List<VodTvchannel> page(int start, int limit, Map<String, Object> queryParams);

    /**
     * 精确获取符合查询条件的记录
     */
    List<VodTvchannel> find(Map<String, Object> queryParams);
    
    /**
     * 精确生成将要插入的记录的序号
     */
    int generatePosition(Map<String, Object> queryParams);

    /**
     * 根据标识获取记录
     */
    VodTvchannel load(int id);
    VodTvchannel loadone();
    VodTvchannel loadbychannel(String channel);

    /**
     * 插入记录
     */
    int insert(VodTvchannel vodchannel);
    int insertjson(VodTvchannel vodchannel);

    /**
     * 修改记录
     */
    int update(VodTvchannel vodchannel);
    int updatesequence(VodTvchannel vodchannel);
    
    /**
     * 批量上线下线
     */
   int updateStatus(Map<String,Object> map);
	/**
     * 删除多条
     */
    int deletes(Map<String, Object> ids);
    
    
    int countalbum(Map<String,Object> map);
    
    List<Map<String,Object>>  pagealbum(Map<String,Object> map);
    
    /**
     * 保存频道节目
     */
    int saveChannelAlbum(Map<String,Object> map);
    
    /**
     * 删除频道节目
     */
    int delChannelAlbum(Map<String,Object> map);
    
    /**
     * 更改频道节目顺序
     */
    int updateChannelAlbumSeq(Map<String,Object> map);
  //查询更改数据的历史排序
    List<Map<String, Object>> findalbumsequencesum(Map<String, Object> queryParams);
    //查询绑定信息排序
    List<Map<String, Object>> findalbumsequence(Map<String, Object> map);
    //查询绑定信息的最大和最小排序
    Map<String, Object> findalbummaxVSminsequence(Map<String, Object> map);
    
  //以下为频道自动排序

    //查询排序的最大值和最小值
   	Map<String, Object> findmaxVSminsequence(Map<String, Object> map);
     //查询更改数据的历史排序
   	List<Map<String, Object>> findsequencesum(Map<String, Object> queryParams);
   	//查询排序
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
