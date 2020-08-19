package group.msk.mi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import group.msk.mi.dao.model.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 吕衡
 * @Create 2020/8/18 - 00:18
 * @Desc 客户操作类
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
