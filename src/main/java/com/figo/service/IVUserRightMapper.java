package com.figo.service;

import java.util.List;

/**
 * Created by FigoBa on 2017/8/2.
 */
public interface IVUserRightMapper {
    List<String> get_user_rights(int role_id,String system);
}
