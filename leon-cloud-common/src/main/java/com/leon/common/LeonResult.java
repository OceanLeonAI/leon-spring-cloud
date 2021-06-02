package com.leon.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonResult
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 10:53
 * @Version 1.0
 * @DESCRIPTION: 统一返回类
 **/
@Data
public class LeonResult<T> implements Serializable {
    private static final long serialVersionUID = 6153068102005609196L;

    private static final int SUCCESS = 200;

    private static String MSG_SUCCESS = "操作成功";

    private static int FAIL = 500;

    private static String MSG_FAIL = "操作失败";

    private int code;

    private String msg;

    private T data;

    //分页信息
    private Object meta;

    public static <T> LeonResult<T> ok() {
        return restResult(null, SUCCESS, MSG_SUCCESS, null);
    }

    public static <T> LeonResult<T> okMsg(String msg) {
        return restResult(null, SUCCESS, msg, null);
    }

    public static <T> LeonResult<T> ok(T data) {
        return restResult(data, SUCCESS, MSG_SUCCESS, null);
    }

    public static <T> LeonResult<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg, null);
    }

    public static <T> LeonResult<T> okMeta(T data) {
        return restResult(data, SUCCESS, null, data);
    }

    public static <T> LeonResult<T> ok(T data, String msg, Object meta) {
        return restResult(data, SUCCESS, msg, meta);
    }

    public static <T> LeonResult<T> failed() {
        return restResult(null, FAIL, MSG_FAIL, null);
    }

    public static <T> LeonResult<T> failedMsg(String msg) {
        return restResult(null, FAIL, msg, null);
    }

    public static <T> LeonResult<T> failedCodeMsg(int code, String msg) {
        return restResult(null, code, msg, null);
    }

    public static <T> LeonResult<T> failed(T data) {
        return restResult(data, FAIL, MSG_FAIL, null);
    }

    public static <T> LeonResult<T> failedCodeData(int code, T data) {
        return restResult(data, code, MSG_FAIL, null);
    }

    public static <T> LeonResult<T> failed(T data, String msg) {
        return restResult(data, FAIL, msg, null);
    }

    private static <T> LeonResult<T> restResult(T data, int code, String msg, Object meta) {
        LeonResult leonResult = new LeonResult();
        leonResult.setCode(code);
        leonResult.setData(data);
        leonResult.setMsg(msg);
        leonResult.setMeta(meta);
        return leonResult;
    }
}
