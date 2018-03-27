package com.daydream.console.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ConsoleWebMvcConfigurer extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }

  /**
   * 装饰器
   */
  @Bean
  public FilterRegistrationBean siteMeshFilter() {
    FilterRegistrationBean filer = new FilterRegistrationBean();
    WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
    filer.setFilter(siteMeshFilter);
    return filer;
  }
}
