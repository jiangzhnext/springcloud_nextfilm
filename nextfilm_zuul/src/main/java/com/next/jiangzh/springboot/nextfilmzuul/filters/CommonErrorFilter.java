package com.next.jiangzh.springboot.nextfilmzuul.filters;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Map;

public class CommonErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 系统维护中，请稍后再试
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        // ... 告警

        Map<String,Object> result = Maps.newHashMap();
        result.put("status", HttpStatus.BAD_GATEWAY.value());
        result.put("message","系统维护中，请稍后再试");

        try {
            // 刷新一下Response
            ctx.setResponse(new HttpServletResponseWrapper(ctx.getResponse()){
                @Override
                public ServletOutputStream getOutputStream() throws IOException {
                    ServletOutputStream os = super.getOutputStream();
                    return os;
                }
            });

            // 设置中文支持
            ctx.getResponse().setContentType(ContentType.APPLICATION_JSON.toString());
            ctx.getResponse().setCharacterEncoding("utf-8");

            // 设置返回结果
            ctx.getResponse().getWriter().write(JSONObject.toJSONString(result));
            ctx.getResponse().getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
