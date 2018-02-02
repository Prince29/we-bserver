package com.xsu.server.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class RequestUtils {
    public static final Charset DEFAULT_CHARSET=Charset.forName("UTF-8");

    /**
     * HttpServletRequest to JSONObject
     * @param request
     * @return
     * @throws IOException
     */
    public static JSONObject toJson(HttpServletRequest request) throws IOException {
        InputStream in = request.getInputStream();
        InputStreamReader reader = new InputStreamReader(in, DEFAULT_CHARSET);
        String content = IOUtils.toString(reader);
        if(StringUtils.isEmpty(content)) {
            return null;
        }
        return JSON.parseObject(content);
    }

    /**
     * HttpServletRequest to Javabean
     * @param request
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T toObject(HttpServletRequest request, Class<T> clazz) throws IOException {
        JSONObject json = toJson(request);
        if(json == null) {
            return null;
        }
        JSONObject dataJson = json.getJSONObject("data");
        if(dataJson == null) {
            return null;
        }

        T t = null;
        try {
            t = JSON.toJavaObject(dataJson, clazz);
        } catch (Exception e) {
            throw new RuntimeException("json转化异常："+ e.getMessage(), e);
        }
        return t;
    }
}
