package group.msk.mi.service;

import group.msk.mi.dao.mapper.CustomerMapper;
import group.msk.mi.dao.model.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 吕衡
 * @Create 2020/8/19 - 17:07
 * @Desc 客户数据处理类
 */
@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    public boolean add(Customer customer) {
        return customerMapper.insert(customer) > 0;
    }
}
