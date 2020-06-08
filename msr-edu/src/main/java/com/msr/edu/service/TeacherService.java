package com.msr.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.edu.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author tom
 * @since 2020-06-05
 */
public interface TeacherService extends IService<Teacher> {
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);

}
