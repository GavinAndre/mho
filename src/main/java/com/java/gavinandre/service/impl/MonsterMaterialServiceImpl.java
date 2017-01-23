package com.java.gavinandre.service.impl;

import com.java.gavinandre.pojo.MonsterMaterialList;
import com.java.gavinandre.pojo.ResponseWrapper;
import com.java.gavinandre.service.MonsterMaterialService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by gavinandre on 17-1-13.
 */
@Service("monsterMaterialService")
public class MonsterMaterialServiceImpl extends CommonServiceImpl implements MonsterMaterialService {

    public <T extends Serializable> ResponseWrapper select(Class<T> clazz) throws Exception {
        MonsterMaterialList<T> monsterMaterialList = new MonsterMaterialList<>();
        monsterMaterialList.setMonsterMaterialList(super.listAll(clazz));
        ResponseWrapper<MonsterMaterialList> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setRequestData(monsterMaterialList);
        return responseWrapper;
    }

}
