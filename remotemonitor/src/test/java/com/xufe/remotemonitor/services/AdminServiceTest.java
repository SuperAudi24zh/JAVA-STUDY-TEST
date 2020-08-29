package com.xufe.remotemonitor.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Resource
    private IAdminService ims;
    @Test
    public void find(){
//        System.out.println("======"+ims.findAdminByNameAndPassword("admin","123456"));
//        System.out.println("$$$$$$$$$$$$"+ims.findAdminAll());
        System.out.println(ims.findAllHouses());
    }
}




