package cn.yiyang.book.controller;

import cn.yiyang.book.entity.DemoEntity;
import cn.yiyang.common.RequestLimit.RequestLimit;
import cn.yiyang.common.utils.JWTUtil;
import cn.yiyang.common.utils.ResultBean;
import cn.yiyang.common.validate.Phone;
import cn.yiyang.common.validate.ValueSet;
import cn.yiyang.system.exception.WYYException;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/30 12:48
 * @Version 1.0
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
    @ApiOperation(value = "访问频率限制")
    @RequestLimit(count = 5) // 限制没分钟请求5次， 默认每分钟请求2次
    public ResultBean formTest(@ValueSet(value = {"1", "2"}) @RequestParam String name) {
        return ResultBean.success();
    }


    @ApiOperation(value = "获取用户", notes = "根据用户id，获取用户的具体信息")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
                    @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
            }
    )
    @PostMapping("/getUserById")
    public ResultBean getUserById(
            @RequestParam(name = "userId", required = true, defaultValue = "") String userId,
            @RequestParam(name = "username", required = true, defaultValue = "") String username,
            @RequestParam(name = "password", required = true, defaultValue = "") String password
    ) {
        Map<String, Object> map = Maps.newHashMap();
        map.remove("userId");
        map.clear();
        map.put("userId", userId);
        map.put("username", username);
        map.put("password", password);
        return ResultBean.success(map);
    }


    @GetMapping("/getAllUser")
    public void getAllUser(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com");
    }

}
