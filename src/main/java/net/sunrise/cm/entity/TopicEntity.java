package net.sunrise.cm.entity;

import lombok.Data;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc
 */
@Data
public class TopicEntity {
    /** topic名称 */
    private String topicName;
    /** 分区数 */
    private int partitionNum;
    /** 备份数 */
    private short replicaNum;
    /** 备注 */
    private String memo;
    /** 创建人 */
    private String creator;


    
}
