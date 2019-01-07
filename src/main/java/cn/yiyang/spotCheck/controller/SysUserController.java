package cn.yiyang.spotCheck.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.*;
import cn.yiyang.common.utils.ResultBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import cn.yiyang.spotCheck.service.SysUserService;
import cn.yiyang.spotCheck.entity.SysUserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
@RequestMapping("/spotCheck/sysUserEntity")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;


    /**
    * 新增
    */
    @PostMapping
    public boolean save(SysUserEntity sysUserEntity){
        return sysUserService.save(sysUserEntity);
    }

    /**
    * 通过id删除
    */
    @DeleteMapping
    public boolean delete(SysUserEntity sysUserEntity){
        return sysUserService.removeById(sysUserEntity);
    }

    /**
    * 修改
    */
    @PutMapping
    public boolean updateById(SysUserEntity sysUserEntity){
        return sysUserService.updateById(sysUserEntity);
    }


    /**
    * 查询列表
    */
    @GetMapping("/list")
    public List<SysUserEntity> list(SysUserEntity sysUserEntity ){
        QueryWrapper<SysUserEntity> wp = new QueryWrapper<>();
        //todo init wp
        return sysUserService.list(wp);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public IPage<SysUserEntity> page(Page<SysUserEntity> page,SysUserEntity sysUserEntity){
        QueryWrapper<SysUserEntity> wp = new QueryWrapper<>();
        //todo init wp
        return sysUserService.page(page,wp);
    }


    /**
     * Hutool工具类测试
     */
    @PostMapping("/hutoolTest")
    public ResultBean hutoolTest(@RequestParam MultipartFile file) throws IOException {
        Map<Object, Object> map = MapUtil.createMap(HashMap.class);
        return ResultBean.success(MapUtil.isEmpty(map));
    }

}

