package com.zyd.mapper;

import com.zyd.po.Itemsinfo;
import com.zyd.po.ItemsinfoExample;
import com.zyd.request.UserWill;
import com.zyd.response.Product;
import com.zyd.response.ProductInfo;
import com.zyd.response.ProductInfoVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsinfoMapper {
    int countByExample(ItemsinfoExample example);

    int deleteByExample(ItemsinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Itemsinfo record);

    int insertSelective(Itemsinfo record);

    List<Itemsinfo> selectByExampleWithBLOBs(ItemsinfoExample example);

    List<Itemsinfo> selectByExample(ItemsinfoExample example);

    Itemsinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Itemsinfo record, @Param("example") ItemsinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Itemsinfo record, @Param("example") ItemsinfoExample example);

    int updateByExample(@Param("record") Itemsinfo record, @Param("example") ItemsinfoExample example);

    int updateByPrimaryKeySelective(Itemsinfo record);

    int updateByPrimaryKeyWithBLOBs(Itemsinfo record);

    int updateByPrimaryKey(Itemsinfo record);

	/**
	 * @param userWilling
	 * @return
	 */
	List<Product> selectByIdAndType(UserWill userWilling);

	/**
	 * @param id
	 * @return
	 */
	ProductInfoVo selectById(Integer id);

}