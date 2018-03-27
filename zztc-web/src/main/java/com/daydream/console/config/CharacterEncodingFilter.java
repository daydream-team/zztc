package com.daydream.console.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;


@Order(1)
@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.setProperty("file.encoding", "utf-8");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");

    servletResponse.setContentType("text/html;charset=UTF-8");

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
