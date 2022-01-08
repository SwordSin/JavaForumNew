package com.forum.controller;

import com.forum.common.BusisnessException;
import com.forum.common.PropertiesList;
import com.forum.common.ResultCode;
import com.forum.common.UtilsMethod;
import com.forum.entity.BoardInfoPojo;
import com.forum.service.impl.BoardInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * <p>
 * 论坛板块表 前端控制器
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@RestController
@RequestMapping("/board-info")
@Api(tags = {"论坛版块列表操作"})
public class BoardInfoController {

    @Autowired
    private BoardInfoServiceImpl boardInfoService;
    @Autowired
    private PropertiesList propertiesList;

    @Autowired
    private UtilsMethod utilsMethod;

    /**
     * 获取论坛板块列表
     */
    @GetMapping("/list")
    @ApiOperation(value="获取论坛板块列表",notes="无需参数")
    @ResponseBody
    public List<BoardInfoPojo> getBoardInfoList(){
        return boardInfoService.list();
    }

    /*
        添加论坛板块信息
     */
    @GetMapping("/saveOne")
    @ApiOperation(value="添加板块",notes="板块名称")
    @ResponseBody
    public Boolean insertBoardInfo(@RequestParam String boardName){
        BoardInfoPojo boardInfoPojo = new BoardInfoPojo().setBoardName(boardName);
        try {
            return boardInfoService.save(boardInfoPojo);
        }  catch (Exception e) {
            e.printStackTrace();
            utilsMethod.errType(e.getMessage(), propertiesList.getUkBoardName());
            throw new BusisnessException(ResultCode.UNKNOW_ERROR);
        }
    }

    /*
        修改板块名字
     */

    @PutMapping("/updateOne/{id}/{boardName}")
    @ApiOperation(value="修改板块",notes="id, 板块名称")
    @ResponseBody
    public Boolean updateBoardInfo(@PathVariable("id") Long id, @PathVariable("boardName") String boardName){
        BoardInfoPojo boardInfoPojo  = new BoardInfoPojo().setBoardName(boardName).setId(id);
        // 校验是否能找到修改的板块
        BoardInfoPojo isNull = boardInfoPojo.selectById();
        Assert.notNull(isNull, "找不到要修改的板块, 尝试刷新页面重新操作");
        try {
            return boardInfoService.updateById(boardInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            utilsMethod.errType(e.getMessage(), propertiesList.getUkBoardName());
            throw new BusisnessException(ResultCode.UNKNOW_ERROR);
        }
    }

    /*
        删除论坛板块
     */
    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value="删除板块",notes="板块id")
    @ResponseBody
    public Boolean deleteBoardInfo(@PathVariable("id") Long id){
        Boolean isDelete = false;
        if ((isDelete = boardInfoService.removeById(id)) == true) {
            return isDelete;
        } else {
            throw  new RuntimeException("删除失败, 尝试刷新页面重新操作");
        }
    }

}

