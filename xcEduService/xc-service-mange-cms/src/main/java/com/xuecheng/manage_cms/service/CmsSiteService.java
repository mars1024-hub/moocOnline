package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Yizq
 * @data: 2020/4/18 16:51
 */
@Service
public class CmsSiteService {
    @Autowired
    CmsSiteRepository cmsSiteRepository;


    /**
     * 查询所有
     * @return
     */
    public QueryResponseResult selectAll() {
        QueryResult<CmsSite> cmsSiteResult = new QueryResult<>();
        List<CmsSite> all = cmsSiteRepository.findAll();
        cmsSiteResult.setList(all);
        cmsSiteResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteResult);
    }
}
