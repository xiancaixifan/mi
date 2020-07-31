package group.msk.mi.controller;

import group.msk.mi.core.annotation.WebLog;
import group.msk.mi.core.base.BaseResponse;
import group.msk.mi.core.exception.MiRuntimeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Api(tags = "TestController")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private MessageSource messageSource;

    protected String getMessage(String code, Object[] param) {
        return messageSource.getMessage(code, param, Locale.CHINA);
    }
    @ApiOperation(value = "通过性测试")
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public BaseResponse test1() {
        String value = getMessage("K-000000", null);
        System.out.println("value = " + value);
        return BaseResponse.success(value);
    }


    @ApiOperation(value = "异常返回测试")
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    @WebLog(description="异常返回测试")
    public BaseResponse test2() {

        try {
            throw new NullPointerException();
        } catch (Exception exception) {
            throw new MiRuntimeException(exception);
        }
    }

    @ApiOperation(value = "异常返回测试")
    @RequestMapping(value = "/test3/{v1}/{v2}",method = RequestMethod.GET)
    @WebLog
    public BaseResponse test3(@PathVariable String v1, @PathVariable String v2) {
        return BaseResponse.SUCCESSFUL();
    }
}
