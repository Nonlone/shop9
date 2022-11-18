package com.shop9.app.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("testa")
public class TestAPo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("`key`")
    private String key;

    private String value;

}
