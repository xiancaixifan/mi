package group.msk.mi.dao.model.resquest;

import group.msk.mi.core.base.BaseQueryRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author 吕衡
 * @Create 2020/8/19 - 20:31
 * @Desc Customer 查询参数类
 */
public class CustomerPageQueryRequest extends BaseQueryRequest {

    @ApiModelProperty("客户姓名")
    private String name;

    @ApiModelProperty("客户姓名模糊查询")
    private String likeName;

    @ApiModelProperty("客户手机")
    private String phoneNum;

    @ApiModelProperty("客户手机模糊查询")
    private String likePhoneNum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLikePhoneNum() {
        return likePhoneNum;
    }

    public void setLikePhoneNum(String likePhoneNum) {
        this.likePhoneNum = likePhoneNum;
    }

}
