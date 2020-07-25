package group.msk.wanmi.core.base;

import group.msk.wanmi.core.common.CommonErrorCode;
import group.msk.wanmi.core.util.MessageSourceUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.Serializable;

/**
 * @Author 吕衡
 * @Create 2020/7/25 - 11:06
 * @Desc 公共响应类
 */
@ApiModel(value = "公共响应类")
public class BaseResponse<T> implements Serializable {

    /**
     * 成功返回
     * @return
     */
    public  static BaseResponse SUCCESSFUL(){
        return new BaseResponse(CommonErrorCode.SUCCESSFUL);
    }

    /**
     * 失败返回
     * @return
     */
    public static BaseResponse FAILED() {
        return new BaseResponse(CommonErrorCode.FAILED);
    }


    @ApiModelProperty(value = "结果码",required = true)
    private String code;

    @ApiModelProperty(value ="消息内容")
    private String message;

    @ApiModelProperty(value = "错误内容")
    private Object errorData;

    @ApiModelProperty(value = "内容")
    private T context;

    /**
     * 返回消息码
     * @param code
     */
    public BaseResponse(String code) {
        this.code = code;
        this.message = MessageSourceUtil.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     * 写入占位参数到消息码
     * @param code
     */
    public BaseResponse(String code,Object[] args) {
        this.code = code;
        this.message = MessageSourceUtil.getMessage(code, args, LocaleContextHolder.getLocale());
    }


    public BaseResponse(String code, String message, Object errorData, T context) {
        this.code = code;
        this.message = message;
        this.errorData = errorData;
        this.context = context;
    }

    /**
     * 操作成功,不注重message内容
     * @param context
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T context) {
        return new BaseResponse<>(CommonErrorCode.SUCCESSFUL, null, null, context);
    }



    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", errorData=" + errorData +
                ", context=" + context +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

    public T getContext() {
        return context;
    }

    public void setContext(T context) {
        this.context = context;
    }
}
