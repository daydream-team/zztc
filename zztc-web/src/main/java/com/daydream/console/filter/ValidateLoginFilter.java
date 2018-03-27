package com.daydream.console.filter;

import com.daydream.console.constant.Constants;
import com.daydream.console.model.Admin;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class ValidateLoginFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String uri = httpServletRequest.getRequestURI();
    String contextPath = httpServletRequest.getContextPath();

    httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    httpServletResponse.setHeader("Expires", "0"); // Proxies.
    
    if (StringUtils.containsIgnoreCase(uri, "/index")
        || StringUtils.containsIgnoreCase(uri, "/AdminLTE")
        || StringUtils.containsIgnoreCase(uri, "/admin/login")
        || StringUtils.containsIgnoreCase(uri, "/download")
        || StringUtils.containsIgnoreCase(uri, "/api/third")
        || StringUtils.containsIgnoreCase(uri, "/third")
        || StringUtils.containsIgnoreCase(uri, "/login.html")
        || StringUtils.containsIgnoreCase(uri, "/policy.html")
        || StringUtils.containsIgnoreCase(uri, "/css")
        || StringUtils.containsIgnoreCase(uri, "/fonts")
        || StringUtils.containsIgnoreCase(uri, "/images")
        || StringUtils.containsIgnoreCase(uri, "/js")) {
      chain.doFilter(request, response);
    } else {
      Admin loginAdmin = (Admin) httpServletRequest.getSession().getAttribute(Constants.LOGIN_ADMIN_SESSION_KEY);
      if (loginAdmin != null) {
        if (StringUtils.equals(contextPath + "/", uri)) {
          httpServletResponse.sendRedirect(contextPath + "/page/");
        } else
          chain.doFilter(request, response);
      } else {
        String loginUrl = httpServletRequest.getContextPath() + Constants.LOGIN_PAGE_HTML;
        httpServletResponse.sendRedirect(loginUrl);
      }
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // do nothing
  }

  @Override
  public void destroy() {
    // do nothing
  }
}
