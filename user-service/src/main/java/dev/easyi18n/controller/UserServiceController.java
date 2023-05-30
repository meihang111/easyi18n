package dev.easyi18n.controller;

import dev.easyi18n.entities.CommonResult;
import dev.easyi18n.entities.User;
import dev.easyi18n.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author meihang
 * @date 2023/5/29 8:49
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@RestController
@Slf4j
public class UserServiceController{
    @Resource
    private UserService userService;

    @PostMapping(value = "user/create")
    public CommonResult create(User user){
        int result = userService.create(user);
        log.info("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"createSuccess",result);
        }else {
            return new CommonResult(200,"createError",null);
        }
    }

    @GetMapping(value = "user/get/{id}")
    public CommonResult getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        log.info("******插入结果：" + user);
        if(user != null){
            return new CommonResult(200,"searchSuccess",user);
        }else {
            return new CommonResult(200,"searchError",null);
        }
    }

    @GetMapping(value = "user/getusersbyids")
    public CommonResult getUserListByIds(@RequestParam(value = "ids",required = true) List<Long> ids){
        List<User> userList = null;
        if(ids != null && ids.size() != 0){
            userList = userService.getUserListByIds(ids);
        }
        if(userList != null){
            log.info("******查询结果结果：" + userList);
            return new CommonResult(200,"searchSuccess",userList);
        }else {
            return new CommonResult(200,"searchError",null);
        }
    }
}
