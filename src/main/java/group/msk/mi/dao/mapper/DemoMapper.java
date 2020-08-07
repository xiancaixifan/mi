package group.msk.mi.dao.mapper;

import group.msk.mi.dao.model.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 吕衡
 * @Create 2020/8/6 - 16:06
 * @Desc 测试
 */

@Mapper
public interface DemoMapper {

    @Select("select * from demo")
    List<Demo> findAll();
}
