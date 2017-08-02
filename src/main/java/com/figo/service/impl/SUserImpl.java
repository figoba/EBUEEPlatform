package com.figo.service.impl;

import com.figo.dao.TUserMapper;
import com.figo.model.TUser;
import com.figo.service.STuser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by FigoBa on 2017/7/25.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SUserImpl implements STuser {
    @Resource
    TUserMapper tUserMapper;
    public void selectall() {
        long id=1;
        System.out.println(tUserMapper.selectByPrimaryKey(id).getUserEmail());
    }

    @Override
    public TUser queryByUserName(String user_name) {
        return tUserMapper.queryByName(user_name);
    }
}
