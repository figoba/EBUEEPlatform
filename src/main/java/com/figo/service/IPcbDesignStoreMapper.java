package com.figo.service;

import com.figo.model.PcbDesignStore;

import java.util.List;
import java.util.Map;

/**
 * Created by FigoBa on 2017/7/28.
 */
public interface IPcbDesignStoreMapper {
    int insertNewPcbDesignRecord(PcbDesignStore pcbDesignStore);
    List<PcbDesignStore> queryByPN(String pn);
    List<PcbDesignStore> queryByAnyPN(String pn);

    /**
     * 查询总数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 查询详细记录
     * @param map
     * @return
     */
    List<PcbDesignStore> queryList(Map<String, Object> map);
}
