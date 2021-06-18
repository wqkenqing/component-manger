package net.sunrise.cm.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sunrise.cm.config.KafkaConfig;
import net.sunrise.cm.entity.TopicEntity;
import net.sunrise.cm.service.KafkaManagerService;
import netscape.javascript.JSObject;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author kuiqwang
 * @emai wqkenqingto@163.com
 * @time 2021/5/14
 * @desc
 */
@Api(tags = {"kafka-管理服务"})
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaManagerController {
    @Autowired
    private KafkaManagerService kmanager;
    //初始
    @Autowired
    private KafkaConfig kafkaConfig;

    @ApiOperation("添加kafkaTopic")
    @PostMapping("/addTopic")
    private String createTopic(@RequestBody TopicEntity entity) {
        log.info("开始添加信息....");
        AdminClient admin = kafkaConfig.adminClient();
        kmanager.addTopic(admin, entity);
        return "ok";
    }

    @ApiOperation("展示topic信息")
    @GetMapping("/getTopics")
    private String getToipcs() throws ExecutionException, InterruptedException {
        log.info("开始添加信息....");
        AdminClient admin = kafkaConfig.adminClient();
        Set<String> topicSet = kmanager.showTopics(admin);
        JSONObject topicJson = new JSONObject();
        topicJson.put("data", topicSet);
        return JSONObject.toJSONString(topicJson);
    }

}
