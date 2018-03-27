package com.daydream.console.dto.basic;


/**
 * @author xinyizhang
 * @date 2015年5月21日 下午4:04:01
 */
public enum ErrorCode {
  failure(-1, "Unknown Server Error"), 
  suc(0, "Success"), 
  invalid_param(2, "parameter bind exception"),
  expired(3,"timestamp expired");

  private Integer code;
  private String description;

  private ErrorCode(Integer code, String description) {
    this.code = code;
    this.description = description;
  }

  public Integer code() {
    return this.code;
  }

  public String description() {
    return this.description;
  }

  @Override
  public String toString() {
    return "ErrorCode{" + code + ", " + description + "}";
  }
  
  public static String nameToCode(String name){
    if (ErrorCode.suc.name().equals(name)) {
      return ErrorCode.suc.code().toString();
    } else if (ErrorCode.failure.name().equals(name)) {
      return ErrorCode.failure.code().toString();
    } else {
      return name;
    }
  }
}
