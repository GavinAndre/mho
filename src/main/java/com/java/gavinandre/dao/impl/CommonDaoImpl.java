package com.java.gavinandre.dao.impl;

import com.java.gavinandre.dao.CommonDao;
import com.java.gavinandre.support.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gavinandre on 17-1-12.
 */
@Repository("CommonDao")
public class CommonDaoImpl implements CommonDao {

    @Resource(name = "sqlSessionFactory")
    protected SqlSessionFactory sqlSessionFactory;

    protected <T> String getStatement(Class<T> clazz, String prefix) {
        String entityName = clazz.getSimpleName();
        if (entityName.endsWith("Model")) {
            entityName = entityName.substring(0, entityName.length() - 5);
        }
        entityName = prefix + entityName;
        return entityName;

    }

    @Override
    public <T extends Serializable> int save(T pojo) {
        String statement = getStatement(pojo.getClass(), "insert");
        return sqlSessionFactory.openSession().insert(statement, pojo);
    }

    @Override
    public <T extends Serializable> int deleteById(Class<T> clazz,
                                                   Serializable id) {
        String statement = getStatement(clazz, "idDelete");
        return sqlSessionFactory.openSession().update(statement, id);
    }

    @Override
    public <T extends Serializable> T getById(Class<T> clazz, Serializable id) {
        String statement = getStatement(clazz, "idGet");
        return sqlSessionFactory.openSession().selectOne(statement, id);
    }

    @Override
    public <T extends Serializable> List<T> listAll(Class<T> clazz) throws Exception {
        String statement = getStatement(clazz, "list");
        return sqlSessionFactory.openSession().selectList(statement);
    }

    /**
     * 组装排序串
     *
     * @param sort
     * @param order 最好将order定义成枚举类型，传递一个枚举数组
     * @return
     */
    private String genOrderStr(String sort, String order) {
        String orderBy = "";
        if (StringUtils.isNotBlank(sort)) {
            if (StringUtils.isNotBlank(order)) {
                StringBuilder sb = new StringBuilder(" ");
                String[] aSort = sort.split(",");
                String[] aOrder = order.split(",");
                for (int i = 0; i < aSort.length; i++) {
                    sb.append(aSort[i]).append(" ");
                    if (i < aOrder.length) {
                        sb.append(aOrder[i]).append(",");
                    } else {
                        sb.append("ASC").append(",");
                    }
                }
                // 删除最后一个,
                sb.deleteCharAt(sb.length() - 1);
                orderBy = sb.toString();

            } else {
                orderBy = " order by " + sort;
            }
        }

        return orderBy;
    }

    @Override
    public <T extends Serializable> int pageCount(Class<T> clazz,
                                                  String[] attrs, Object[] values) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        if (values != null && attrs != null) {
            for (int i = 0; i < values.length; i++) {
                if (i < attrs.length) {
                    paraMap.put(attrs[i], values[i]);
                }
            }
        }
        String statement = getStatement(clazz, "pageCount");
        Object o = sqlSessionFactory.openSession().selectOne(statement, paraMap);
        return Integer.parseInt(o.toString());
    }

    @Override
    public <T extends Serializable> Page<T> pageSelect(Class<T> clazz,
                                                       Page<T> p, String[] attrs, Object[] values) {
        int startNum = p.getStartIndex();
        int pageSize = p.getPageSize();
        String orderBy = genOrderStr(p.getSort(), p.getOrder());
        Map<String, Object> paraMap = new HashMap<String, Object>();

        if (values != null && attrs != null) {
            for (int i = 0; i < values.length; i++) {
                if (i < attrs.length) {
                    paraMap.put(attrs[i], values[i]);
                }

            }
        }
        String statement = getStatement(clazz, "page");
        p.setTotal(pageCount(clazz, attrs, values));

        paraMap.put("startNum", startNum);
        paraMap.put("pageSize", pageSize);
        paraMap.put("endNum", startNum + pageSize);
        paraMap.put("orderBy", orderBy);
        List<T> list = sqlSessionFactory.openSession().selectList(statement,
                paraMap);
        p.setData(list);
        return p;
    }

    @Override
    public <T extends Serializable> int countAll(Class<T> clazz) {
        String statement = getStatement(clazz, "count");
        Object o = sqlSessionFactory.openSession().selectOne(statement);
        return Integer.parseInt(o.toString());
    }

    @Override
    public List<Map<String, Object>> selectMap(String statement,
                                               Map<String, Object> paraMap) {
        return sqlSessionFactory.openSession().selectList(statement, paraMap);
    }
}
