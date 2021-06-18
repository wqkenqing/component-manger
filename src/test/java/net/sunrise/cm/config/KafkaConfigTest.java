package net.sunrise.cm.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/17
 * @desc
 */
@SpringBootTest
@Slf4j
class KafkaConfigTest {
    @Autowired
    private KafkaConfig kafkaConfig;

    @Test
    public void testCreateTopic() {
        NewTopic newTopic = new NewTopic("test-topic1", 3, (short) 1);
        List<NewTopic> tlist = new ArrayList<>();
        tlist.add(newTopic);
        kafkaConfig.adminClient().createTopics(tlist);
    }
}