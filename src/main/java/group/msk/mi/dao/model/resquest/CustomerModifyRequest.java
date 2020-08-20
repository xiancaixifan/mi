package group.msk.mi.dao.model.resquest;

import group.msk.mi.core.base.BaseRequest;
import group.msk.mi.dao.model.enums.Sex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author 吕衡
 * @Create 2020/8/19 - 21:45
 * @Desc 客户修改对象
 */
@Api("编辑客户")
public class CustomerModifyRequest extends BaseRequest {

    @ApiModelProperty("客户Id")
    @NotBlank
    private String id;

    @ApiModelProperty(value = "客户姓名",required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(value = "客户性别",required = true)
    private Sex sex;

    @ApiModelProperty(value = "手机号码", required = true)
    @Length(max = 11, min = 11)
    private String phoneNum;

    @ApiModelProperty("备用手机号码")
    //todo 统一自定义参数校验
//    @Length(max = 11, min = 11)
    private String phoneNumBak;

    @ApiModelProperty("身份证号码")
//    @Length(max = 18, min = 18)
    private String careId;

    @ApiModelProperty("家庭地址")
    private String address;

    @ApiModelProperty("客户等级")
    private Integer level =  0;

    @ApiModelProperty("备注信息")
    private String bakInfo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNumBak() {
        return phoneNumBak;
    }

    public void setPhoneNumBak(String phoneNumBak) {
        this.phoneNumBak = phoneNumBak;
    }

    public String getCareId() {
        return careId;
    }

    public void setCareId(String careId) {
        this.careId = careId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBakInfo() {
        return bakInfo;
    }

    public void setBakInfo(String bakInfo) {
        this.bakInfo = bakInfo;
    }
}
