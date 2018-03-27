package com.daydream.console.web.controller;

import com.daydream.console.dto.basic.WebResultData;
import com.daydream.console.utils.WebResultUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器基类
 */
public abstract class BaseController {

  /**
   * logger
   */
  protected Logger LOGGER = LoggerFactory.getLogger(getClass());
  /**
   * 请求
   */
  @Autowired
  protected HttpServletRequest request;
  /**
   * 响应
   */
  @Autowired
  protected HttpServletResponse response;

  /**
   * 统一处理接口调用产生的异常
   *
   * @return json格式的错误信息
   */
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public WebResultData handleException(Exception e, HttpServletRequest request) {
    LOGGER.error(request.getRequestURI(), e, e.getMessage());
    return WebResultUtils.buildFailResult(e.getMessage());
  }
}
