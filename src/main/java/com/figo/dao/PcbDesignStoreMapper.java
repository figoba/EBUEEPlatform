package com.figo.dao;

import com.figo.model.PcbDesignStore;
import com.figo.model.PcbDesignStoreExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PcbDesignStoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int countByExample(PcbDesignStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int deleteByExample(PcbDesignStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int insert(PcbDesignStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int insertSelective(PcbDesignStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    List<PcbDesignStore> selectByExample(PcbDesignStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    List<PcbDesignStore> selectByPN(String pn);

    List<PcbDesignStore> selectByAnyPN(String pn);

    PcbDesignStore selectByPrimaryKey(Integer id);

    int queryTotal(Map<String, Object> map);

    List<PcbDesignStore> queryList(Map<String, Object> map);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PcbDesignStore record, @Param("example") PcbDesignStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PcbDesignStore record, @Param("example") PcbDesignStoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PcbDesignStore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pcb_design_store
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PcbDesignStore record);
}