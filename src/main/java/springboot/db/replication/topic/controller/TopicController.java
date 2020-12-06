package springboot.db.replication.topic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.db.replication.topic.model.request.SaveTopicRequest;
import springboot.db.replication.topic.service.TopicService;
import springboot.db.replication.topic.service.query.TopicQueryService;

@RestController
@RequestMapping("topics")
public class TopicController {

    private final TopicService topicService;
    private final TopicQueryService topicQueryService;

    @Autowired
    public TopicController(TopicService topicService, TopicQueryService topicQueryService) {
        this.topicService = topicService;
        this.topicQueryService = topicQueryService;
    }

    @GetMapping("/types/{type}")
    public ResponseEntity<?> getTopics(@PathVariable(value = "type") String type) {

        return ResponseEntity.ok().body(topicQueryService.getTopics(type));
    }

    @GetMapping("master/types/{type}")
    public ResponseEntity<?> getTopicsByMaster(@PathVariable(value = "type") String type) {

        return ResponseEntity.ok().body(topicQueryService.getTopics(type));
    }

    @PostMapping
    public ResponseEntity<?> saveTopic(@RequestBody SaveTopicRequest saveTopicRequest) {

        topicService.saveTopic(saveTopicRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{topicId}")
    public ResponseEntity<?> modifyTopic(@PathVariable(value = "topicId") long topicId, @RequestBody SaveTopicRequest saveTopicRequest) {

        topicService.modifyTopic(topicId, saveTopicRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{topicId}")
    public ResponseEntity<?> deleteTopic(@PathVariable(value = "topicId") long topicId) {

        topicService.deleteTopic(topicId);
        return ResponseEntity.noContent().build();
    }
}
