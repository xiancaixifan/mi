package group.msk.mi.controller;

import group.msk.mi.core.base.BaseResponse;
import group.msk.mi.dao.mapper.DemoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 吕衡
 * @Create 2020/8/6 - 16:44
 * @Desc TODO
 */
@RestController
@RequestMapping("td")
public class TestDaoController {

    @Resource
    private DemoMapper demoMapper;

    @RequestMapping(value = "t1",method = RequestMethod.GET)
    public BaseResponse t1() {
        return BaseResponse.success(demoMapper.findAll());
    }
}
