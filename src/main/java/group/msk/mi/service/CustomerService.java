package group.msk.mi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import group.msk.mi.dao.mapper.CustomerMapper;
import group.msk.mi.dao.model.entity.Customer;
import group.msk.mi.dao.model.resquest.CustomerPageQueryRequest;
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

    public Boolean add(Customer customer) {
        return customerMapper.insert(customer) > 0;
    }

    public Page<Customer> page(Page<Customer> page,CustomerPageQueryRequest request) {
        Page<Customer> customerPage = customerMapper.selectPage(page, null);
        return customerPage;
    }

    public Boolean edit(Customer request){
        return customerMapper.updateById(request) > 0;
    }

    public Boolean del(String customerId) {
        return customerMapper.deleteById(customerId) > 0;
    }
}
