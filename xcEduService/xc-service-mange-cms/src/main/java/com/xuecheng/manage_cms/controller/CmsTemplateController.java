package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmstTemplateControllerApi;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.CmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yizq
 * @data: 2020/4/18 17:11
 */
@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements CmstTemplateControllerApi {

    @Autowired
    CmsTemplateService cmsTemplateService;



    @Override
    @GetMapping("/list")
    public QueryResponseResult selectAll() {
        return cmsTemplateService.selectAll();
    }
}
