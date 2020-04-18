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
            @ApiImplicitParam(name = "CmsPage", value = "实体对象", required = true, paramType = "path", dataType = "object")
    })
    public CmsPageResult add(CmsPage cmsPage);


    //根据ID查询页面
    @ApiOperation("根据ID查询页面")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "String")
    public CmsPage findById(String id);

    //修改页面
    @ApiOperation("修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "CmsPage", value = "实体对象", required = true, paramType = "path", dataType = "object")

    })
    public CmsPageResult edit(String id, CmsPage cmsPage);

    //删除页面
    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "String")
    public CmsPageResult delete(String id);

}
