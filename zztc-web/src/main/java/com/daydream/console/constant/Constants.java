package com.daydream.console.constant;

public class Constants {

  /**
   * 保存已登录管理员的会话Key
   */
  public static final String LOGIN_ADMIN_SESSION_KEY = "loginAdmin";
  /**
   * 请求开始时间
   */
  public static final String REQUEST_START_TIME = "requestStartTime";
  /**
   * 需要装饰的访问路径
   */
  public static final String SITEMESH_CONTENT_PATH = "/page/*.html";
  /**
   * sitemesh装饰器页面路径
   */
  public static final String SITEMESH_DECORATOR_PATH = "/frame.html";
  /**
   * 不需要装饰的访问路径,多个之间用英文逗号分隔
   */
  public static final String SITEMESH_EXCLUDED_PATH = "/login.html";
  /**
   * 登陆页面
   */
  public static final String LOGIN_PAGE_HTML = "/login.html";
}
