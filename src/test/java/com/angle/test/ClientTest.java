package com.angle.test;

import com.angle.domain.Client;
import com.angle.mapper.ClientMapper;
import com.angle.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClientTest {
    @Test
    public void a() {

        //获取spring容器
        ApplicationContext ps = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        ClientMapper bean = ps.getBean(ClientMapper.class);
        //获取数据
        Client item = bean.findOne("lucy");
        System.out.println(item);
    }

    @Test
    public void b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        int str = calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(str);
        System.out.println(new Date());
    }
}
