package swagger.web.controller;

import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swagger.form.LoginForm;
import swagger.pojo.User;
import swagger.service.UserService;

/**
 * Created by Black on 2016/10/30.
 */
@Api(value = "demo", description = "有关于demo测试相关")
@RestController
@RequestMapping("/demo")
public class ApiDemo {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "test the api demo", notes = "login test")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })*/
    public User login(@RequestParam String username,@RequestParam String password) {
        System.out.println(username);
        System.out.println(password);
        User user = userService.checkUser(username, password);
        return user;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ApiOperation(value = "test the api demo", notes = "login test")
    public String checkLogin(@RequestParam String username) {
        return userService.checkLogin(username);
    }

    @RequestMapping(value = "/login/form", method = RequestMethod.POST)
    @ApiOperation(value = "login by login form", notes = "表单对象接受参数测试")
/*    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "LoginForm"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "LoginForm")
    })*/
    public String loginByForm( LoginForm form) {
        return userService.loginByForm(form);
    }
}
