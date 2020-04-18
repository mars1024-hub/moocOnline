package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: Yizq
 * @data: 2020/4/18 17:18
 */
@Api(value = "cms模板管理接口",description = "cms模板管理接口，提供页面增、删、改、查")
public interface CmstTemplateControllerApi {

    //页面查询
    @ApiOperation("无条件查询所有")
    public QueryResponseResult selectAll();
}
