package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import io.swagger.annotations.*;

/**
 * @author: Yizq
 * @data: 2020/4/12 15:31
 */
@Api(value = "cms页面管理接口",description = "cms页面管理接口，提供页面增、删、改、查")
public interface CmsPageControllerApi {

    //页面查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "记录数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);


    //新增页面
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cmsPage",value = "cmsPage对象")
    })
    public CmsPageResult add(CmsPage cmsPage);
}
