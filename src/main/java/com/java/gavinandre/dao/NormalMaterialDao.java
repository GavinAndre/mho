package com.java.gavinandre.dao;

import com.java.gavinandre.pojo.NormalMaterial;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NormalMaterialDao {

    int insert(@Param("pojo") NormalMaterial pojo);

    int insertList(@Param("pojos") List< NormalMaterial> pojo);

    List< NormalMaterial> select(@Param("pojo") NormalMaterial pojo);

    int update(@Param("pojo") NormalMaterial pojo);

}
