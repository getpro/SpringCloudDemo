package com.irskj.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by irskj on 2019/1/10.
 */
public class AccessFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

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
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getParameter("accessToken");
        String path = request.getServletPath();
        logger.info("访问路径：{}",request.getServletPath());
        if(path.contains("api-docs")){
            return null;
        }
        if(accessToken==null){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            logger.info("accessToken not found!");
            return null;
        }
        logger.info("accessToken is ok");
        return null;
    }
}
