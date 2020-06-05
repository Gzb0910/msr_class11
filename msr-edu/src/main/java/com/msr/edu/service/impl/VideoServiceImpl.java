package com.msr.edu.service.impl;

import com.msr.edu.entity.Video;
import com.msr.edu.mapper.VideoMapper;
import com.msr.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-06-05
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
