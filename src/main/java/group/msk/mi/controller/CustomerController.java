package group.msk.mi.controller;

import cn.hutool.core.bean.BeanUtil;
import group.msk.mi.core.base.BaseResponse;
import group.msk.mi.dao.model.entity.Customer;
import group.msk.mi.dao.model.resquest.CustomerAddRequest;
import group.msk.mi.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author 吕衡
 * @Create 2020/8/18 - 00:57
 * @Desc 客户操作类
 */
@Api(tags = "CustomerController", description = "客户操作类")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("新增一位客户")
    @PutMapping
    public BaseResponse<Boolean> add(@RequestBody  @Valid CustomerAddRequest request) {
        Customer customer = BeanUtil.copyProperties(request, Customer.class);
        return BaseResponse.success(customerService.add(customer));
    }




}
