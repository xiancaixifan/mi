package group.msk.mi.controller;

import group.msk.mi.core.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public BaseResponse test1() {
        String value = getMessage("K-000000", null);
        System.out.println("value = " + value);
        return BaseResponse.success(value);
    }
}
