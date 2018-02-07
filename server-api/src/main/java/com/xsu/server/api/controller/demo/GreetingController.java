package com.xsu.server.api.controller.demo;

import com.alibaba.fastjson.JSONObject;
import com.xsu.server.common.utils.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "World")String name,Model model){
        model.addAttribute("name",name);
        System.out.println("this is greeting");

        return "greeting";
    }

    @RequestMapping("/greeting2")
    public String greeting2(HttpServletRequest request, Model model) throws IOException {
        JSONObject json=RequestUtils.toJson(request);
        System.out.println("this is greeting2,request:"+(json==null?"":json.toJSONString()));
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        return "greeting2";
    }
}
