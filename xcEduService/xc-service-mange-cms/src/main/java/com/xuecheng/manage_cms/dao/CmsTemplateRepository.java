package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Yizq
 * @data: 2020/4/18 17:11
 */
@Repository
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {

}
