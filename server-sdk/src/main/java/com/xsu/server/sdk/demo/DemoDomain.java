package com.xsu.server.sdk.demo;

public class DemoDomain {

    private Long demoId;
    private String demoName;

    public Long getDemoId() {
        return demoId;
    }

    public void setDemoId(Long demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    @Override
    public String toString(){
        return "DemoDomain:{demoId:"+demoId
                +",demoName:"+demoName
                +"}";
    }
}
