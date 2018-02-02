package com.xsu.server.biz;

import com.xsu.server.common.utils.DemoUtil;
import com.xsu.server.dao.demo.DemoDao;
import com.xsu.server.entity.demo.Demo;
import com.xsu.server.sdk.demo.DemoDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DemoBiz {

    private Logger logger= LoggerFactory.getLogger(DemoBiz.class);

    @Autowired
    private DemoDao demoDao;

    public DemoDomain demoShow(String demo){
        DemoDomain domain=new DemoDomain();
        domain.setDemoId(DemoUtil.getCurrentTime());
        domain.setDemoName("**<>DemoBiz->"+demo+ DemoUtil.getCurrentTime());
        List<Demo> demoList=demoDao.listAll();
        logger.info("demoList size:"+demoList.size());
        if(demoList!=null){
            for(Demo d:demoList){
                logger.info("数据：{id:"+d.getRoleId()+",roleName:"+d.getRoleName()+"}");
            }
        }
        System.out.println("这是数据啊");
        return domain;
    }
    public static void main(String[] args){
        System.out.println("测试中文乱码");
    }
}
