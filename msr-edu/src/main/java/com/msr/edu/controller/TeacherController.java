package com.msr.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.edu.entity.Teacher;
import com.msr.edu.query.TeacherQuery;
import com.msr.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-05
 * springmvc = servlet
 * festfull风格   CURD的方法用语义化的方式来展示出来
 * @RestController：方法的返回类型是json格式
 * @RequestMapping: 请求路径访问
 * GetMapping:指向的是查询操作
 * DeleteMapping:指向的是删除操作
 * PostMapping:指向的是添加操作
 * PutMapping:指向的是修改操作
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    //读取所有的讲师信息
    //定义业务层对象
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/list")
    public R list(){
        List<Teacher> teacherList =  teacherService.list(null);
        return R.ok().data("list",teacherList);
    }

    /**
     * 前端传递是id数组，后端方法处使用数组参数来接收
     * @return
     */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("/delete")
    public R removeById(
            @ApiParam(name = "ids", value = "讲师ID", required = true)
            @RequestBody Long[] ids){
        //ids数组参数   :把数组类型转换为集合类型     Arrays.asList(数组) = 集合
        //removeByIds(集合参数)
        boolean flag =  teacherService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            TeacherQuery teacherQuery,

            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        if(page <= 0 || limit <= 0){
            //throw new MSRException(21003, "参数不正确1");
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Teacher> pageParam = new Page<>(page, limit);

        //teacherService.page(pageParam, null);
        teacherService.pageQuery(pageParam,teacherQuery);

        List<Teacher> records = pageParam.getRecords();//当前页的集合数据
        long total = pageParam.getTotal();   //总记录数

        return  R.ok().data("total", total).data("rows", records);//返回数据
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){  //传递的是json对象，@RequestBody把json对象转换为java对象
        teacherService.save(teacher);
        return R.ok();
    }

    //后端返回的数据如果是集合，则键的名称用list，如果返回的是对象统一使用item

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/info/{id}") //路径传参
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("/update")
    public R updateById(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){
        teacherService.updateById(teacher);  // update  teacher  set ...   where id = ?
        return R.ok();
    }
}

