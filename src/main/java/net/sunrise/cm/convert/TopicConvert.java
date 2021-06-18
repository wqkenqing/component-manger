package net.sunrise.cm.convert;

import net.sunrise.cm.entity.TopicEntity;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc
 */
public class TopicConvert {
    /**
     * @desc: 将entity 转换成newtopic对象
     * @date: 2021/5/14
     **/
    public NewTopic wrapTopicEntityToNewTopic(TopicEntity entity) {
        NewTopic topic = new NewTopic(entity.getTopicName(), entity.getPartitionNum(), entity.getReplicaNum());
        return topic;
    }

    /**
     * @desc: 将TopicEnity集合转成NewTopic集合
     * @date: 2021/5/14
     **/
    public List<NewTopic> wrapTopicEntityToNewTopicList(List<TopicEntity> entityList) {
        List<NewTopic> newTopicList = new ArrayList<>();
        for (TopicEntity entity : entityList) {
            NewTopic newtopic = new NewTopic(entity.getTopicName(), entity.getPartitionNum(), entity.getReplicaNum());
            newTopicList.add(newtopic);
        }
        return newTopicList;
    }
}
