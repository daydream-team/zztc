package com.daydream.console.utils;


import com.daydream.console.dto.basic.ErrorCode;
import com.daydream.console.dto.basic.WebResultData;

public class WebResultUtils {
  public static WebResultData buildSucResult() {
    return buildResult(ErrorCode.suc);
  }

  public static WebResultData buildFailureResult() {
    return buildResult(ErrorCode.failure);
  }

  public static WebResultData buildSucResult(Object data, Integer compress) {
    if (compress != null && compress == 1) {
      return WebResultUtils.buildSucZipResult(data);
    } else {
      return WebResultUtils.buildSucResult(data);
    }
  }

  public static WebResultData buildSucResult(Object data) {
    WebResultData webResultData = buildResult(ErrorCode.suc);
    webResultData.setData(data);
    return webResultData;
  }

  public static WebResultData buildSucZipResult(Object data) {
    WebResultData webResultData = buildResult(ErrorCode.suc);
    webResultData.setData(data);
    if (data != null) {
      if (data instanceof String && "".equals(((String) data).trim())) {} else {
        webResultData.setCompress(1);
      }
    }
    return webResultData;
  }

  public static WebResultData buildResult(ErrorCode errorCode) {
    WebResultData webResultData = new WebResultData();
    webResultData.setStatus(errorCode.code().toString());
    webResultData.setMsg(errorCode.description());
    return webResultData;
  }

  public static WebResultData buildFailResult(String msg) {
    WebResultData webResultData = buildResult(ErrorCode.failure);
    webResultData.setMsg(msg);
    return webResultData;
  }
}
