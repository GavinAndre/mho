package com.java.gavinandre.service.impl;

/**
 * Created by gavinandre on 17-1-12.
 */

import com.java.gavinandre.dao.CommonDao;
import com.java.gavinandre.service.CommonService;
import com.java.gavinandre.support.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author weilisky
 *         考虑将来可能切换到hibernate或其他框架的情况，尽量的将切换时不用变的代码移到service层。
 *         将切换时可能会变更的代码放在了dao层
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource(name = "CommonDao")
    protected CommonDao commonDao;

    @Override
    public <T extends Serializable> int save(T pojo) {
        return commonDao.save(pojo);
    }

    @Override
    public <T extends Serializable> int deleteById(Class<T> clazz,
                                                   Serializable id) {
        return commonDao.deleteById(clazz, id);
    }

    @Override
    public <T extends Serializable> T getById(Class<T> clazz, Serializable id) {
        return commonDao.getById(clazz, id);
    }

    @Override
    public <T extends Serializable> List<T> listAll(Class<T> clazz) throws Exception {
        return commonDao.listAll(clazz);
    }


    @Override
    public <T extends Serializable> int pageCount(Class<T> clazz,
                                                  String[] attrs, Object[] values) {
        return commonDao.pageCount(clazz, attrs, values);
    }

    @Override
    public <T extends Serializable> Page<T> pageSelect(Class<T> clazz,
                                                       Page<T> p, String[] attrs, Object[] values) {
        return commonDao.pageSelect(clazz, p, attrs, values);
    }

    @Override
    public <T extends Serializable> int countAll(Class<T> clazz) {
        return commonDao.countAll(clazz);
    }

    @Override
    public List<Map<String, Object>> selectMap(String statement,
                                               Map<String, Object> paraMap) {
        return commonDao.selectMap(statement, paraMap);
    }

}
