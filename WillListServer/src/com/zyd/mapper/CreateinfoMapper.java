package com.zyd.mapper;

import com.zyd.po.Createinfo;
import com.zyd.po.CreateinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreateinfoMapper {
    int countByExample(CreateinfoExample example);

    int deleteByExample(CreateinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Createinfo record);

    int insertSelective(Createinfo record);

    List<Createinfo> selectByExample(CreateinfoExample example);

    Createinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Createinfo record, @Param("example") CreateinfoExample example);

    int updateByExample(@Param("record") Createinfo record, @Param("example") CreateinfoExample example);

    int updateByPrimaryKeySelective(Createinfo record);

    int updateByPrimaryKey(Createinfo record);

	/**
	 * @param createinfo
	 * @return
	 */
	int selectByCreate(Createinfo createinfo);
}