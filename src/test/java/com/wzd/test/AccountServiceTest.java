package com.wzd.test;

import com.wzd.config.SpringConfig;
import com.wzd.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wr847214947@163.com
 * @date 2020/6/23 15:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
//@ContextConfiguration(locations = "classpath:Application.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService accountService;

    @Test
    public void transfer(){
        accountService.transfer("aaa","bbb",100f);
    }
}
