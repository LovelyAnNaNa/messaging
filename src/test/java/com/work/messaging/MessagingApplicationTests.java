package com.work.messaging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MessagingApplicationTests {

    @Test
    public void contextLoads() {
        String aaaa = new BCryptPasswordEncoder().encode("aaaa");
        String aaaa1 = new BCryptPasswordEncoder().encode("aaaa");
        System.out.println(aaaa);
        System.out.println(aaaa1);
        System.out.println("aaaa.equals(aaaa1) = " + aaaa.equals(aaaa1));
    }

}
