package com.figo.service;

import com.figo.model.TUser;

/**
 * Created by FigoBa on 2017/7/25.
 */
public interface STuser {
    public void selectall();
    TUser queryByUserName(String username);
}
