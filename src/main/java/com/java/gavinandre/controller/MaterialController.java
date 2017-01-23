package com.java.gavinandre.controller;

import com.java.gavinandre.pojo.MonsterMaterial;
import com.java.gavinandre.pojo.ResponseWrapper;
import com.java.gavinandre.service.MonsterMaterialService;
import com.java.gavinandre.service.NormalMaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gavinandre on 17-1-11.
 */
@Controller
public class MaterialController {

    @Resource
    private NormalMaterialService normalMaterialService;
    @Resource
    private MonsterMaterialService monsterMaterialService;

    @RequestMapping("/NormalMaterial")
    public
    @ResponseBody
    ResponseWrapper queryNormalMaterial() {
        return normalMaterialService.select(null);
    }

    @RequestMapping("/MonsterMaterial")
    public
    @ResponseBody
    ResponseWrapper queryMonsterMaterial() throws Exception {
        return monsterMaterialService.select(MonsterMaterial.class);
    }

}
