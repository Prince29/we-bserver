package com.xsu.server.biz;

import com.xsu.server.common.utils.DemoUtil;
import com.xsu.server.sdk.demo.DemoDomain;
import org.springframework.stereotype.Component;

@Component
public class DemoBiz {
    public DemoDomain demoShow(String demo){
        DemoDomain domain=new DemoDomain();
        domain.setDemoId(DemoUtil.getCurrentTime());
        domain.setDemoName("DemoBiz->"+demo+ DemoUtil.getCurrentTime());
        return domain;
    }
}
