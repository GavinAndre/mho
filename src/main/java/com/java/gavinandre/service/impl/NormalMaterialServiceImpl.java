package com.java.gavinandre.service.impl;

import com.java.gavinandre.dao.NormalMaterialDao;
import com.java.gavinandre.pojo.NormalMaterial;
import com.java.gavinandre.pojo.NormalMaterialList;
import com.java.gavinandre.pojo.ResponseWrapper;
import com.java.gavinandre.service.NormalMaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("NormalMaterialService")
public class NormalMaterialServiceImpl implements NormalMaterialService {

    @Resource
    private NormalMaterialDao normalMaterialDao;

    public int insert(NormalMaterial pojo) {
        return normalMaterialDao.insert(pojo);
    }

    public int insertList(List<NormalMaterial> pojos) {
        return normalMaterialDao.insertList(pojos);
    }

    public ResponseWrapper select(NormalMaterial pojo) {
        NormalMaterialList normalMaterialList = new NormalMaterialList();
        normalMaterialList.setNormalMaterialList(normalMaterialDao.select(pojo));
        ResponseWrapper<NormalMaterialList> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setRequestData(normalMaterialList);
        return responseWrapper;
    }

    public int update(NormalMaterial pojo) {
        return normalMaterialDao.update(pojo);
    }

}
