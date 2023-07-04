package top.wjstar.vue_admin_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件实体类
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-04
 */
@Getter
@Setter
@TableName("sys_file")
@ApiModel(value = "File对象", description = "")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文件名称")
    private String name;

    @ApiModelProperty("文件类型")
    private String type;

    @ApiModelProperty("文件大小")
    private Long size;

    @ApiModelProperty("下载链接")
    private String url;

    @ApiModelProperty("0 未删除  1已删除")
    private Boolean isDelete;

    @ApiModelProperty("1启用 0 禁用")
    private Boolean enable;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
