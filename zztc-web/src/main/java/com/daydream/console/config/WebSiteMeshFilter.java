package com.daydream.console.config;

import com.daydream.console.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

  @Override
  protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
    builder.addDecoratorPath(Constants.SITEMESH_CONTENT_PATH, Constants.SITEMESH_DECORATOR_PATH);
    if (StringUtils.isEmpty(Constants.SITEMESH_EXCLUDED_PATH)) {
      return;
    }
    String[] paths = Constants.SITEMESH_EXCLUDED_PATH.split(",");
    for (String path : paths) {
      builder.addExcludedPath(path);
    }
  }
}