package cn.yiyang.spotCheck.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import cn.yiyang.spotCheck.service.TProductService;
import cn.yiyang.spotCheck.entity.TProductEntity;
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
@RequestMapping("/spotCheck/tProductEntity")
public class TProductController {


    @Autowired
    private TProductService tProductService;


    /**
    * 新增
    */
    @PostMapping
    public boolean save(TProductEntity tProductEntity){
        return tProductService.save(tProductEntity);
    }

    /**
    * 通过id删除
    */
    @DeleteMapping
    public boolean delete(TProductEntity tProductEntity){
        return tProductService.removeById(tProductEntity);
    }

    /**
    * 修改
    */
    @PutMapping
    public boolean updateById(TProductEntity tProductEntity){
        return tProductService.updateById(tProductEntity);
    }


    /**
    * 查询列表
    */
    @GetMapping("/list")
    public List<TProductEntity> list(TProductEntity tProductEntity ){
        QueryWrapper<TProductEntity> wp = new QueryWrapper<>();
        //todo init wp
        return tProductService.list(wp);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public IPage<TProductEntity> page(Page<TProductEntity> page,TProductEntity tProductEntity){
        QueryWrapper<TProductEntity> wp = new QueryWrapper<>();
        //todo init wp
        return tProductService.page(page,wp);
    }


}

