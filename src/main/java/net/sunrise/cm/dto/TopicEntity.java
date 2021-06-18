package net.sunrise.cm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc
 */
@Data
@ApiModel("Topic数据")
public class TopicEntity {
    /** topic名称 */
    @ApiModelProperty(value = "Topic名称")
    private String topicName;
    /** 分区数 */
    @ApiModelProperty(value = "分区数")
    private int partitionNum;
    /** 备份数 */
    @ApiModelProperty(value = "备份数")
    private short replicaNum;
    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String memo;
    /** 创建人 */
    @ApiModelProperty(value = "创建人")
    private String creator;


    
}
