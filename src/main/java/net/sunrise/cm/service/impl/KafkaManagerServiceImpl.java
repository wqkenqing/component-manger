package net.sunrise.cm.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.sunrise.cm.config.KafkaConfig;
import net.sunrise.cm.convert.TopicConvert;
import net.sunrise.cm.entity.TopicEntity;
import net.sunrise.cm.service.KafkaManagerService;
import org.apache.kafka.clients.admin.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc
 */
@Slf4j
@Component
public class KafkaManagerServiceImpl implements KafkaManagerService {
    TopicConvert topicConvert = new TopicConvert();

    @Override
    public void addTopic(AdminClient admin, TopicEntity topic) {
        log.info("[{}]", topic);
        List<NewTopic> topicList = new ArrayList<>();
        NewTopic newTopic = topicConvert.wrapTopicEntityToNewTopic(topic);
        topicList.add(newTopic);
        CreateTopicsResult result = admin.createTopics(topicList);
        log.info("添加结果[{}]", result.toString());
    }

    @Override
    public void addTopics(AdminClient admin, List<TopicEntity> topicList) {
        //Get NewTopic Object collection !
        List<NewTopic> newTopicList = topicConvert.wrapTopicEntityToNewTopicList(topicList);
        //Create batch  Topics
        admin.createTopics(newTopicList);
    }

    @Override
    public Set<String> showTopics(AdminClient admin) throws ExecutionException, InterruptedException {
        ListTopicsResult listResult = admin.listTopics();
        Set<String> topicNameSet = admin.listTopics().names().get();
        return topicNameSet;
    }


}
