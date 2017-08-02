package com.figo.function;

import com.figo.model.PcbDesignStore;
import com.figo.service.IPcbDesignStoreMapper;
import com.figo.util.PageUtils;
import com.figo.util.Query;
import com.figo.util.R;

import java.util.List;
import java.util.Map;

/**
 * Created by FigoBa on 2017/8/1.
 */
public class PCBCheck {
    public static R getChecklist(Map<String, Object> params,IPcbDesignStoreMapper iPcbDesignStoreMapper){
        Query query = new Query(params);
        int total = iPcbDesignStoreMapper.queryTotal(query);

        List<PcbDesignStore> pcbList = iPcbDesignStoreMapper.queryList(query);
        System.out.println(pcbList.get(0).getDateUpload());
        PageUtils pageUtil = new PageUtils(pcbList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
}
