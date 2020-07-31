package group.msk.mi.core.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import group.msk.mi.core.base.BaseResponse;
import group.msk.mi.core.common.CommonLogFormat;
import group.msk.mi.core.util.MessageSourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

/**
 * @Author 吕衡
 * @Create 2020/7/31 - 00:13
 * @Desc 全局异常处理类
 */
@ControllerAdvice
public class GloBalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;


    /**
     * @param exception
     * @return
     * @ExceptionHandler(MiRuntimeException.class) 处理请求访问过程中出现的指定异常
     * @ResponseStatus(HttpStatus.OK) 返回Http的状态码
     * @ResponseBody 返回参数实例化为JSON格式
     */
    @ExceptionHandler(MiRuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse MiRuntimeExceptionHandler(MiRuntimeException exception) {
        Throwable cause = exception.getCause();
        //异常链内描述
        String detailMessage = "";
        //异常配置描述信息
        String codeMessage = "";
        //自定义错误描述
        String resultInfo = exception.getResultInfo();
        //自定义异常码
        String errorCode = exception.getErrorCode();

        //异常链消息若有必抛
        if (null != cause) {
            //TODO 感觉可以搞一个异常配置,再写个方法搞搞
            //想法: 搞一个异常配置 其中有 异常类名称,异常难度级别枚举(简单,稍难,困难),解决方案链接(例如csdn,博客园链接等)
            //在配置文件里面配置,服务启动时校验配置里的异常类是否存在,校验这一过程可以配置开关
            //然后把配置文件里初始化成功的信息放到redis中,每次项目启动如果校验开关打开就刷一次到redis中,
            //定义这个想法为 异常帮助 异常帮助可以开关,异常校验可以开关,抽一个方法或者类出来
            if (ExceptionUtil.isCausedBy(exception, NullPointerException.class)) {
                detailMessage = "空指针异常";
            }
        }

        codeMessage = StrUtil.isNotBlank(this.getMessage(errorCode, exception.getParams())) ? this.getMessage(errorCode, exception.getParams()) : resultInfo;
        logger.error(CommonLogFormat.COMMON_ERROR_FORMAT, errorCode, codeMessage, exception);
        return new BaseResponse<>(errorCode, codeMessage, detailMessage, exception.getData());

    }

    private String getMessage(String code, Object[] params) {
        return MessageSourceUtil.getMessage(code, params, Locale.CHINA);
    }
}
