package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author: Yizq
 * @data: 2020/4/12 17:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;


    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testFindAll(){
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindPage() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<CmsPage> page = cmsPageRepository.findAll(pageable);
        System.out.println(page);

    }

    @Test
    public void testRestTeamplte() {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/get/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        System.out.println(body);
    }
}
