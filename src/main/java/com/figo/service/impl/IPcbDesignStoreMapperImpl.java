package com.figo.service.impl;

import com.figo.dao.PcbDesignStoreMapper;

import com.figo.model.PcbDesignStore;
import com.figo.service.IPcbDesignStoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by FigoBa on 2017/7/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IPcbDesignStoreMapperImpl implements IPcbDesignStoreMapper {
    @Resource
    PcbDesignStoreMapper pcbDesignStoreMapper;
    @Override
    public int insertNewPcbDesignRecord(PcbDesignStore pcbDesignStore) {
        return pcbDesignStoreMapper.insert(pcbDesignStore);
    }

    @Override
    public List<PcbDesignStore> queryByPN(String pn) {
        return pcbDesignStoreMapper.selectByPN(pn);
    }

    @Override
    public List<PcbDesignStore> queryByAnyPN(String pn) {
        return pcbDesignStoreMapper.selectByAnyPN(pn);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return pcbDesignStoreMapper.queryTotal(map);
    }

    @Override
    public List<PcbDesignStore> queryList(Map<String, Object> map) {
        return pcbDesignStoreMapper.queryList(map);
    }
}
