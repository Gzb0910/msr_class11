package com.msr.edu.service.impl;

import com.msr.edu.entity.Course;
import com.msr.edu.mapper.CourseMapper;
import com.msr.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-06-05
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
