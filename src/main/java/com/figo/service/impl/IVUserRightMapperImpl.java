package com.figo.service.impl;

import com.figo.dao.VUserRightMapper;
import com.figo.model.VUserRight;
import com.figo.service.IVUserRightMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FigoBa on 2017/8/2.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IVUserRightMapperImpl implements IVUserRightMapper {
    @Resource
    VUserRightMapper vUserRightMapper;
    @Override
    public List<String> get_user_rights(int role_id,String system) {
        return vUserRightMapper.getRightsByID(role_id,system);
    }
}
