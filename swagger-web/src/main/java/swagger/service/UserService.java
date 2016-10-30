package swagger.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import swagger.form.LoginForm;
import swagger.pojo.User;

/**
 * Created by Black on 2016/10/30.
 */
@Service(value = "userService")
public class UserService {

    public User checkUser(String username, String password) {
        User user = null;
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            user = new User();
            user.setName("Black");
            user.setAge("25");
        }
        return user;
    }

    public String checkLogin(String username) {
        if (StringUtils.isNotBlank(username)) {
            return "success";
        }
        return "failure";
    }

    public String loginByForm(LoginForm form) {
        System.out.println(form.getUsername());
        System.out.println(form.getPassword());
        if (StringUtils.isNotBlank(form.getUsername()) && StringUtils.isNotBlank(form.getPassword())) {
            return "success";
        }
        return "failure";
    }
}
