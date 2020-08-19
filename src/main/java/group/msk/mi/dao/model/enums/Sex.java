package group.msk.mi.dao.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Author 吕衡
 * @Create 2020/8/18 - 01:27
 * @Desc 性别枚举类
 */

public enum Sex  implements IEnum<Integer> {
    FEMALE, MAN;

    @Override
    public Integer getValue() {
        return this.ordinal();
    }

    public static Sex fromValue(int value){
        return values()[value];
    }

}
