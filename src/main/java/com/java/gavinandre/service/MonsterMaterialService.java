package com.java.gavinandre.service;

import com.java.gavinandre.pojo.ResponseWrapper;

import java.io.Serializable;

/**
 * Created by gavinandre on 17-1-13.
 */
public interface MonsterMaterialService extends CommonService {

    public <T extends Serializable> ResponseWrapper select(Class<T> clazz) throws Exception;
}
