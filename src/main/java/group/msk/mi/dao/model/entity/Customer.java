package group.msk.mi.dao.model.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import group.msk.mi.dao.model.enums.Sex;

/**
 * @Author 吕衡
 * @Create 2020/8/7 - 23:23
 * @Desc 客户实体类
 */

public class Customer {
    private Long id;

    private String name;
    @EnumValue
    private Sex sex;

    private String phoneNum;

    private String phoneNumBak;

    private String careId;

    private String address;

    private Integer level;

    private String bakInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
