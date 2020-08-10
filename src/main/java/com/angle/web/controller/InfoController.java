package com.angle.web.controller;

import com.angle.domain.Client;
import com.angle.domain.Info;
import com.angle.service.IInfoService;
import com.angle.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/info")
public class InfoController {


    @Autowired
    private IInfoService infoService;
    @Autowired
    private ILoginService loginService;

    /**
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, HttpServletRequest request) {

        /*名字回显，设置session的作用时间*/
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Client client = loginService.findOne(name);
        HttpSession session = request.getSession();
        session.setAttribute("client", client);
        session.setMaxInactiveInterval(30 * 60);//单位是秒

        /*判断用户是否是本天第一次登入，是：设置status为：年+月+日*/
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        long str = calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DAY_OF_MONTH);
        if (client.getStatus() == 0 || client.getStatus() < str) {
            //获取元月日相加
            /*Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int str = calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DAY_OF_MONTH);
           */
            client.setStatus(str);
            //调用服务修改数据
            loginService.modify(client);
            //创建本天的数据
            Info info = new Info();
            info.setCid(client.getId());
            info.setNowtime(new Date());
            infoService.insert(info);
        }

        //获取所有client
        List<Client> all = loginService.findAll();
        int lenght = all.size();//获取用户总数
        int[] sore = new int[lenght];

        //设置排列的顺序，登入用户第一个
        sore[0] = client.getId();
        for (int i = 0, j = 1; i < lenght; i++) {
            if (client.getId() != all.get(i).getId()) {
                sore[j++] = all.get(i).getId();
            }
        }

        //获取用户数据
        List<Client> lists = new ArrayList();
        for (int i = 0; i < lenght; i++) {
            lists.add(loginService.findById(sore[i]));
            lists.get(i).setTotalNum(infoService.findAllByCid(sore[i]).size());//设置数据总数
            lists.get(i).setPageNum(1);//设置当前页
        }
        //model.addAttribute("lists", lists);
        session.setAttribute("lists", lists);
        return "/admin/index.jsp";
    }

    /**
     * @param request
     * @param id      用户id，判断是哪个用户
     * @param pageNum 判断是第几页
     * @param num     判断上一页还是下一页 0：上一页，1：下一页
     * @return
     */
    @RequestMapping("/page")
    public String pageDate(HttpServletRequest request, int id, int pageNum, int num) {

        HttpSession session = request.getSession();
        List<Client> lists = (List<Client>) session.getAttribute("lists");

        int offset = (pageNum - 1) * 4, cid = 0;//cid对应集合中的数据

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getId() == id) {
                cid = i;
                break;
            }
        }

        if (num == 0) {
            if (pageNum > 1) {
                offset = (pageNum - 1) * 4;
            }
        } else {
            int quyu = lists.get(cid).getTotalNum() % 4;
            int IntNum = lists.get(cid).getTotalNum() / 4;
            if (quyu != 0) {
                IntNum++;
            }
            if (pageNum < IntNum) {
                offset = pageNum * 4;
            }
        }

        List<Info> pageByCid = infoService.findPageByCid(lists.get(cid).getId(), offset);
        lists.get(cid).setList(pageByCid);
        session.setAttribute("lists", lists);
        return "/admin/index.jsp";
    }


    /**
     * @param model
     * @param request
     * @param value   获取被点击的签到用户的id，判断签到的是不是当前登入的用户
     * @param status  判断是签到上课，还是签到下课 1：上课 0：下课
     * @return
     */
    @RequestMapping("/signIn")
    public String signIn(Model model, HttpServletRequest request, @RequestParam("value") String value, int status) {

        HttpSession session = request.getSession();
        //获取登入用户的信息
        Client client = (Client) session.getAttribute("client");

        if (Integer.parseInt(value) == client.getId()) {
            //通过登入用户的id获取该用户四天的签到情况，取第一个，MySQL使用了降序排列DESC默认是asc
            Info info = infoService.findByCid(client.getId()).get(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int i = calendar.get(Calendar.HOUR_OF_DAY);
            if (i >= 6 && i < 12) {

                if (status == 1) {
                    info.setForenoonon(new Date());
                }
                if (status == 0 && (info.getForenoonon() != null)) {
                    info.setForenoondoen(new Date());
                }
                /*if (info.getForenoonon() == null) {
                    info.setForenoonon(new Date());
                } else {
                    if (info.getForenoondoen() == null) {
                        info.setForenoondoen(new Date());
                    }

                }*/
            }
            if (i >= 12 && i < 18) {


                if (status == 1) {
                    info.setAfternoonon(new Date());
                }
                if (status == 0 && (info.getAfternoonon() != null)) {
                    info.setAfternoondown(new Date());
                }

                /*if (info.getAfternoonon() == null) {
                    info.setAfternoonon(new Date());
                } else {
                    if (info.getAfternoondown() == null) {
                        info.setAfternoondown(new Date());
                    }
                }*/
            }
            if (i >= 18 && i < 24) {

                if (status == 1) {
                    info.setNighton(new Date());
                }
                if (status == 0 && (info.getNighton() != null)) {
                    info.setNightdown(new Date());
                }

               /* if (info.getNighton() == null) {
                    info.setNighton(new Date());
                } else {
                    if (info.getNightdown() == null) {
                        info.setNightdown(new Date());
                    }
                }*/
            }
            infoService.modify(info);
        }
        return "redirect:/info/findAll";
    }

    @RequestMapping("/findByCid")
    public String getMsg(Model model, @RequestParam("value") int value, @RequestParam("username") String username) {

        List<Info> infos = infoService.findAllByCid(value);
        model.addAttribute("infos", infos);
        model.addAttribute("username", username);
        return "/admin/message.jsp";
    }

    @RequestMapping("/result")
    public String getResult(Model model) {
        int fO, fD, aO, aD, nO, nD;
        List<Client> clientList = loginService.findAll();
        List<Map<String, String>> results = new ArrayList<>();
        for (Client client : clientList) {
            fO = 0;
            fD = 0;
            aO = 0;
            aD = 0;
            nO = 0;
            nD = 0;
            Map<String, String> map = new HashMap<>();
            map.put("username", client.getUsername());
            for (Info info : client.getListResult()) {
                if (info.getForenoonon() != null) {
                    fO++;
                }
                if (info.getForenoondoen() != null) {
                    fD++;
                }
                if (info.getAfternoonon() != null) {
                    aO++;
                }
                if (info.getAfternoondown() != null) {
                    aD++;
                }
                if (info.getNighton() != null) {
                    nO++;
                }
                if (info.getNightdown() != null) {
                    nD++;
                }
            }
            map.put("fO", fO + "");
            map.put("fD", fD + "");
            map.put("aO", aO + "");
            map.put("aD", aD + "");
            map.put("nO", nO + "");
            map.put("nD", nD + "");
            results.add(map);
        }
        model.addAttribute("results", results);
        return "/admin/result.jsp";
    }
}