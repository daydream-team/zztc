package com.daydream.console.dto.basic;

public class WebResultData {
  private String status;
  private String msg;
  private Object data;
  private int compress = 0;

  public WebResultData() {}

  public WebResultData(String status) {
    this.status = status;
  }

  public WebResultData(String status, Object data) {
    this.status = status;
    this.data = data;
  }

  public WebResultData(String status, int compress) {
    this.status = status;
    this.compress = compress;
  }

  public WebResultData(String status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public WebResultData(String status, String msg, Object data, int compress) {
    super();
    this.status = status;
    this.msg = msg;
    this.data = data;
    this.compress = compress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getCompress() {
    return compress;
  }

  public void setCompress(int compress) {
    this.compress = compress;
  }

}
