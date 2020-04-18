package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Yizq
 * @data: 2020/4/13 20:16
 */
@Service
public class CmsPageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 页面查询方法
     *
     * @param page             从1开始计数
     * @param size             每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        //自定义条件查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        //设置条件值(站点ID)
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())) {
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());

        }
        //定义Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);


        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageRequest);
        QueryResult queryResult = new QueryResult();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());

        QueryResponseResult result = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return result;
    }

    //新增页面
    public CmsPageResult add(CmsPage cmsPage) {
        //页面名称、站点Id、页面webpath为唯一索引
        CmsPage resultCmsPage = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (resultCmsPage == null) {
            //防止页面插入新主键，在这里将主键设置为空
            cmsPage.setPageId(null);
            //新增
            CmsPage saveCmsPage = cmsPageRepository.save(cmsPage);
            return new CmsPageResult(CommonCode.SUCCESS, saveCmsPage);
        }
        //添加失败
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    //根据ID查询页面
    public CmsPage getById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    //更新页面信息
    public CmsPageResult update(String id, CmsPage cmsPage) {
        //根据id查询页面信息
        CmsPage one = this.getById(id);
        if (one != null) {
            //更新模板ID
            one.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            one.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            one.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            one.setPageName(cmsPage.getPageName());
            //更新访问路径
            one.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            //执行更新
            CmsPage save = cmsPageRepository.save(one);
            if (save != null) {
                //返回结果
                return new CmsPageResult(CommonCode.SUCCESS, save);

            }
        }
        //返回失败
        return new CmsPageResult(CommonCode.FAIL, null);

    }

    //删除
    public CmsPageResult delete(String id) {
        CmsPage result = this.getById(id);
        if (result != null) {
            cmsPageRepository.delete(result);
            return new CmsPageResult(CommonCode.SUCCESS, null);
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }
}
