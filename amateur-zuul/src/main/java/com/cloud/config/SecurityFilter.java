package com.cloud.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;


/**
 * 用于安全路由，仅当token正确或UserInfo正确时才能使用Zuul
 *
 */

@Component
public class SecurityFilter extends ZuulFilter {

    private static String TOKEN = "123456";
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getParameter("token");
        if (token != null && !"".equals(token) && token.equals(SecurityFilter.TOKEN)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            ctx.setResponseBody("无访问权限");
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
        }
        return null;
    }
}
