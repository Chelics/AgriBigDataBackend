package com.agri.agribigdata.interceptor;


import com.agri.agribigdata.entity.vo.ResultVO;
import com.agri.agribigdata.utils.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 登录校验拦截器 目标资源方法运行前运行
     * @param request
     * @param response
     * @param handler
     * @return true放行, false不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        //1.获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的url:{}", url);

        //2.判断请求url中是否包含login, 如是登录操作, 直接放行
        if(url.contains("login")){
            log.info("登录操作, 放行...");
            return true;
        }

        //3.获取请求头中的令牌
        String jwt = request.getHeader("Authorization");

        if (jwt != null && jwt.startsWith("Bearer ")) {
            String token = jwt.substring(7); // 提取令牌部分
        }

        //4.判断令牌是否存在. 如不存在
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空, 未登录");
            request.setAttribute("claims", new HashMap<String,Object>());
            ResultVO error = ResultVO.error(HttpStatus.UNAUTHORIZED.value(),"NOT_LOGIN");
            //String notLogin = JSONObject.toJSONString(error);
            //response.getWriter().write(notLogin);
            return true;
        }

        //5.解析token, 如解析失败(未登录), 返回错误结果
        try {
            request.setAttribute("claims",JwtUtils.parseJwt(jwt));
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败, 返回未登录错误信息");
            ResultVO error = ResultVO.error(HttpStatus.UNAUTHORIZED.value(),"NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //6.放行
        log.info("令牌合法, 放行");
        return true;

    }


    /**
     * 目标资源方法运行后运行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    /**
     * 视图渲染完毕后运行, 最后运行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
