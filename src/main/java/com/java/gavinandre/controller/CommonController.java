package com.java.gavinandre.controller;

import com.java.gavinandre.pojo.UserModel;
import com.java.gavinandre.service.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gavinandre on 17-1-12.
 */
@Controller
public class CommonController {

    @Resource
    private CommonService commonService;

    @RequestMapping("/Common")
    public
    @ResponseBody
    List<UserModel> Common() throws Exception {
        return commonService.listAll(UserModel.class);
    }
}
