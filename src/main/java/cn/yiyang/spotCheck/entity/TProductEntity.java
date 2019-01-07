package cn.yiyang.spotCheck.entity;

import java.math.BigDecimal;
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
@TableName("t_product")
public class TProductEntity extends Model<TProductEntity> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;
    /**
     * 药厂id
     */
    @TableField("FACTORY_ID")
    private String factoryId;
    @TableField("DIVISION_ID")
    private String divisionId;
    /**
     * 产品名称
     */
    @TableField("PRODUCT_NAME")
    private String productName;
    /**
     * 产品类型
     */
    @TableField("PRODUCT_TYPE")
    private String productType;
    /**
     * 包装规格
     */
    @TableField("PACKING_SPECIFICATION")
    private String packingSpecification;
    /**
     * 最低零售价
     */
    @TableField("MINIMUM_PRICE")
    private BigDecimal minimumPrice;
    /**
     * 含税零售价
     */
    @TableField("TAX_INCLUSIVE_RETAIL_PRICE")
    private BigDecimal taxInclusiveRetailPrice;
    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;
    @TableField("CREATE_USER_ID")
    private String createUserId;
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;
    @TableField("UPDATE_USER_ID")
    private String updateUserId;
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;
    /**
     * 最小包装数量
     */
    @TableField("RESERVE_FILED_1")
    private String reserveFiled1;
    /**
     * 最小包装单位
     */
    @TableField("RESERVE_FILED_2")
    private String reserveFiled2;
    @TableField("RESERVE_FILED_3")
    private String reserveFiled3;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
