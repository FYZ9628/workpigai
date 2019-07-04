package com.example.workpigai.controller;

import com.example.workpigai.model.User;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * 控制层  转发调用
 */

@Controller
public class AdminLoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/admin_login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String account = requestUser.getAccount();
        account = HtmlUtils.htmlEscape(account);

        // 返回码：100对应管理员，200对应教师，300对应学生，400是错误码
        User user = userService.get(account, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else if (user.getType() == 1){
            String mAccount = user.getAccount();
            String mPassword = user.getPassword();
            return new Result(100, mAccount, mPassword);
        } else {
            return new Result(400);
        }
    }

    @PostMapping("/api/updatePassword")
    public User updatePassword(@RequestBody User user) throws Exception {

        boolean bl = userService.isExist(user.getAccount());
        if (bl == true){
            User user1 = userService.addOrUpdateUser(user);
            User userId = userService.getByAccount(user.getAccount());
            user1.setId(userId.getId());
            return user1;
        }else {
            return null;
        }
    }

}
