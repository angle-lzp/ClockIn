package com.angle.web.controller;

import com.angle.domain.Client;
import com.angle.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/name")
    public Map name() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

    @RequestMapping("/back")
    public String back() {
        return "redirect:/info/findAll";
    }

    @RequestMapping("/jump")
    public String jump() {
        return "/admin/modifyPassword.jsp";
    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(Client client, @RequestParam("checkPassword") String checkPassword, HttpServletRequest request, HttpServletResponse response) {

        //判断两次输入密码是否相同
        if (checkPassword.equals(client.getPassword())) {
            //使用spring Security加密密码
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(client.getPassword());
            //获取原先的放入session中的client对象数据
            Client client1 = (Client) request.getSession().getAttribute("client");
            client1.setPassword(password);//设置新的密码
            client1.setUsername(client.getUsername());//设置新的账号
            //执行修改密码操做
            loginService.modify(client1);
            //在后台代码中退出springSecurity的方法
            //我们首先是确定，用户点击登出链接的时候，是否是在已验证的前提下（这里可能是用户的session失效等情况）。
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                //不为空，说明已经验证，那么手动退出
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            return "redirect:/login?logout";
        }
        return "/login/jump";
    }
}
