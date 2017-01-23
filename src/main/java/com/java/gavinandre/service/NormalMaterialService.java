package com.java.gavinandre.service;

import com.java.gavinandre.pojo.NormalMaterial;
import com.java.gavinandre.pojo.ResponseWrapper;

import java.util.List;

/**
 * Created by gavinandre on 17-1-11.
 */
public interface NormalMaterialService {

    public int insert(NormalMaterial pojo);

    public int insertList(List<NormalMaterial> pojos);

    public ResponseWrapper select(NormalMaterial pojo);

    public int update(NormalMaterial pojo);

}
