package top.wjstar.vue_admin_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 角色实体类
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-05
 */
@Getter
@Setter
@TableName("sys_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("角色名称")
    private String name;
    @ApiModelProperty("角色描述")
    private String description;
}
