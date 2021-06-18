package net.sunrise.cm.service;

import net.sunrise.cm.entity.TopicEntity;
import org.apache.kafka.clients.admin.AdminClient;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc kafka管理服务
 */
public interface KafkaManagerService {
    //TODO 功能实现:topic添加、展示topic、删除topic、获取consumer组、重置consumer组内的信息。

    //添加topic
    void addTopic(AdminClient admin,TopicEntity topic);

    //批量添加topic
    void addTopics(AdminClient admin,List<TopicEntity> topicList);

    Set<String> showTopics(AdminClient admin) throws ExecutionException, InterruptedException;
}
