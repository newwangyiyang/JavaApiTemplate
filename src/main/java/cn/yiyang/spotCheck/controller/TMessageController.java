package cn.yiyang.spotCheck.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import cn.yiyang.spotCheck.service.TMessageService;
import cn.yiyang.spotCheck.entity.TMessageEntity;
import java.util.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyiyang
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/spotCheck/tMessageEntity")
public class TMessageController {


    @Autowired
    private TMessageService tMessageService;


    /**
    * 新增
    */
    @PostMapping
    public boolean save(TMessageEntity tMessageEntity){
        return tMessageService.save(tMessageEntity);
    }

    /**
    * 通过id删除
    */
    @DeleteMapping
    public boolean delete(TMessageEntity tMessageEntity){
        return tMessageService.removeById(tMessageEntity);
    }

    /**
    * 修改
    */
    @PutMapping
    public boolean updateById(TMessageEntity tMessageEntity){
        return tMessageService.updateById(tMessageEntity);
    }


    /**
    * 查询列表
    */
    @GetMapping("/list")
    public List<TMessageEntity> list(TMessageEntity tMessageEntity ){
        QueryWrapper<TMessageEntity> wp = new QueryWrapper<>();
        //todo init wp
        return tMessageService.list(wp);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public IPage<TMessageEntity> page(Page<TMessageEntity> page,TMessageEntity tMessageEntity){
        QueryWrapper<TMessageEntity> wp = new QueryWrapper<>();
        //todo init wp
        return tMessageService.page(page,wp);
    }


}

