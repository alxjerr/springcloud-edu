package com.springcloud.edu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器编写
 */
@Component
public class TokenFilter extends ZuulFilter {

    //表示过滤器类型，表示在请求之前执行
    @Override
    public String filterType() {
        return "pre";
    }

    //表示过滤器执行的顺序，
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //编写过滤器拦截业务代码
    @Override
    public Object run() throws ZuulException {
        // 拦截所有的服务接口，判断服务接口上是否有token

        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2. 获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //3.从请求头中获取token
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)){
            //表示不会继续向下执行 --> 不会调用服务接口，网关服务直接响应客户端
            //返回错误提示
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            return null;

        }
        // 正常调用其他服务接口
        return null;
    }


}
