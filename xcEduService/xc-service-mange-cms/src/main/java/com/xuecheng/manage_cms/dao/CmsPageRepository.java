package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Yizq
 * @data: 2020/4/12 17:02
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {


    //根据页面名称、站点Id、页面webpath查询CMS
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);


}
