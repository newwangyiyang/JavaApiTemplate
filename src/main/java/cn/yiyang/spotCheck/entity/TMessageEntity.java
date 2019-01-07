package cn.yiyang.spotCheck.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyiyang
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_message")
public class TMessageEntity extends Model<TMessageEntity> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;
    @TableField("user_id")
    private String userId;
    /**
     * 消息头
     */
    @TableField("title")
    private String title;
    /**
     * 点击消息跳转url
     */
    @TableField("url")
    private String url;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
    /**
     * 消息状态：0：未读 1：已读
     */
    @TableField("status")
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
