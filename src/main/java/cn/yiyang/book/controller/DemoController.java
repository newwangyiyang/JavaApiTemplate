package cn.yiyang.book.controller;

import cn.yiyang.book.entity.DemoEntity;
import cn.yiyang.common.RequestLimit.RequestLimit;
import cn.yiyang.common.utils.DateUtils;
import cn.yiyang.common.utils.JUtils.base.RegexUtils;
import cn.yiyang.common.utils.JWTUtil;
import cn.yiyang.common.utils.ResultBean;
import cn.yiyang.common.validate.Phone;
import cn.yiyang.common.validate.ValueSet;
import cn.yiyang.system.exception.WYYException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/30 12:48
 * @Version 1.0
 * application/json
 * application/x-www-form-urlencoded
 * 只是前端传递的编码格式不同，在前端传递和后端接收方式相同
 **/
@RestController
@RequestMapping("/demo")
@Slf4j
@Validated
public class DemoController {

    @RequestMapping(value = "/getDemo", method = RequestMethod.GET)
    private ResultBean getDemo() {
        DemoEntity entity = new DemoEntity();
        return ResultBean.success(entity);
    }
    @RequestMapping(value = "/saveDemo", method = { RequestMethod.GET })
    private ResultBean saveDemo() throws Exception {
//        throw new WYYException("服务器错误");
//        return ResultBean.success(demo);
        throw new Exception("服务器错误");
    }

    @PostMapping(value = "/loginDemo")
    public ResultBean loginDemo(@RequestParam("userId") String userId, @RequestParam("userRoles") String[] userRoles) {
        String token = JWTUtil.createToken(userId, userRoles);
        return ResultBean.success(token);
    }

//    @RequiresRoles(logical = Logical.OR, value = {"admin", "boss"})
    @GetMapping("/roleTest")
    public ResultBean roleTest() throws Exception {
        throw new Exception("test");
//        return ResultBean.success("请求成功");
    }

    @PostMapping("/getVal")
    public ResultBean getVal(@Valid @RequestBody DemoEntity demoEntity) {
        return ResultBean.success();
    }


    @GetMapping("/formTest")
    @RequestLimit(count = 5) // 限制没分钟请求5次， 默认每分钟请求2次
    public ResultBean formTest(@ValueSet(value = {"1", "2"}) @RequestParam String name) {
        return ResultBean.success();
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        Collections.addAll(list, 1,2,3,4,5,6);
        System.out.println(list);
    }
}
