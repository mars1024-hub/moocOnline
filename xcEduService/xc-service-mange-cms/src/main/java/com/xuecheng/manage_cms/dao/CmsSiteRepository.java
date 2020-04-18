package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Yizq
 * @data: 2020/4/18 16:51
 */
@Repository
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {



}
