package group.msk.mi.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import group.msk.mi.core.annotation.WebLog;
import group.msk.mi.core.base.BaseResponse;
import group.msk.mi.dao.model.entity.Customer;
import group.msk.mi.dao.model.resquest.CustomerAddRequest;
import group.msk.mi.dao.model.resquest.CustomerDelRequest;
import group.msk.mi.dao.model.resquest.CustomerModifyRequest;
import group.msk.mi.dao.model.resquest.CustomerPageQueryRequest;
import group.msk.mi.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
//    @WebLog
    public BaseResponse<Boolean> add(@RequestBody @Valid CustomerAddRequest request) {
        Customer customer = BeanUtil.copyProperties(request, Customer.class);
        return BaseResponse.success(customerService.add(customer));
    }


    @ApiOperation("分页查询客户列表")
    @PostMapping("/page")
    @WebLog
    public BaseResponse page(@RequestBody @Valid CustomerPageQueryRequest request) {
        Page<Customer> customerPage = new Page<>();
        customerPage.setCurrent(request.getCurrentPage());
        customerPage.setSize(request.getPageSize());
        return BaseResponse.success(customerService.page(customerPage, request));
    }

    @ApiOperation("编辑客户")
    @PutMapping
    @WebLog
    public BaseResponse<Boolean> edit(@RequestBody @Valid  CustomerModifyRequest request) {
        Customer customer = BeanUtil.copyProperties(request, Customer.class);
        Boolean edit = customerService.edit(customer);
        if (edit) {
            return BaseResponse.SUCCESSFUL();
        } else {
            return BaseResponse.FAILED();
        }
    }
//
    @ApiOperation("删除客户")
    @DeleteMapping
//    @WebLog
    public BaseResponse<Boolean> del(@RequestBody @Valid  CustomerDelRequest request) {
        Boolean del = customerService.del(request.getCustomerId());
        if (del) {
            return BaseResponse.SUCCESSFUL();
        } else {
            return BaseResponse.FAILED();
        }
    }

}
