package com.daydream.console.config;

import com.daydream.console.constant.Constants;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter {

  /**
   * logger
   */
  protected Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.setAttribute(Constants.REQUEST_START_TIME, System.currentTimeMillis());
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    long startTime = (Long) request.getAttribute(Constants.REQUEST_START_TIME);
    LOGGER.info("{}.{}执行耗时: {}ms", method.getDeclaringClass().getSimpleName(), method.getName(),
        System.currentTimeMillis() - startTime);
  }
}
