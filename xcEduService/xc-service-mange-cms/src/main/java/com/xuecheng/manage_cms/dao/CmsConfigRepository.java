package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Yizq
 * @data: 2020/4/19 10:56
 */
@Repository
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {

}
