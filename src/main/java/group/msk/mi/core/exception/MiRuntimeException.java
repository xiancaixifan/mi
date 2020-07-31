package group.msk.mi.core.exception;

import group.msk.mi.core.common.CommonCoreErrorCode;

/**
 * @Author 吕衡
 * @Create 2020/7/31 - 00:00
 * @Desc 全局统一异常
 */
public class MiRuntimeException extends RuntimeException {
    //状态码
    private String errorCode;
    //返回数据
    private Object data;
    //自定义错误消息
    private String resultInfo = "fail";
    //自定义的错误消息信息,填充{}
    private Object[] params;


    /**
     * 默认构造,抛出错误异常
     */
    public MiRuntimeException() {
        super();
        this.errorCode = CommonCoreErrorCode.FAILED;
    }


    /**
     * 主动抛出,用于业务错误代码,自定义异常
     * @param errorCode
     */
    public MiRuntimeException(String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * 主动抛出,用于业务错误代码,自定义异常,自定义返回消息
     * (建议准守规范,异常定义于配置文件中)
     * @param errorCode
     * @param result
     */
    public MiRuntimeException(String errorCode, String resultInfo) {
        this.errorCode = errorCode;
        this.resultInfo = resultInfo;
    }


    /**
     * 主动抛出,用于业务错误代码,自定义异常,自定义返回消息
     * (建议准守规范,异常定义于配置文件中)
     * @param errorCode
     * @param result
     */
    public MiRuntimeException(String errorCode, String resultInfo,Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.resultInfo = resultInfo;
    }


    /**
     * 主动抛出,用于业务错误代码,填充配置的消息内容
     * 如{0},{1}
     * @param errorCode
     * @param params
     */
    public MiRuntimeException(String errorCode, Object[] params) {
        this.errorCode = errorCode;
        this.params = params;
    }


    /**
     * 被动抛出,用于捕获的异常,将异常返回到上层结构
     * 上级异常链
     * @param errorCode
     * @param cause
     */
    public MiRuntimeException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public Object[] getParams() {
        return params;
    }

    public Object getData() {
        return data;
    }
}
