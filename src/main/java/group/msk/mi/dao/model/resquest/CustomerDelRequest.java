package group.msk.mi.dao.model.resquest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Author 吕衡
 * @Create 2020/8/20 - 17:28
 * @Desc 客户删除请求对象
 */
@Api("客户删除请求对象")
public class CustomerDelRequest {
    @ApiModelProperty("客户ID")
    @NotBlank
    public String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
