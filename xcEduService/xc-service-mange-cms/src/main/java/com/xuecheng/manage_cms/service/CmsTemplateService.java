package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Yizq
 * @data: 2020/4/18 17:12
 */
@Service
public class CmsTemplateService {

    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    public QueryResponseResult selectAll() {
        QueryResult<CmsTemplate> templateResult = new QueryResult<>();
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        templateResult.setList(all);
        templateResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS, templateResult);
    }



}
