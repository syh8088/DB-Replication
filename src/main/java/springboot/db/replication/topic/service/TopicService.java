package springboot.db.replication.topic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.db.replication.topic.model.entity.Topic;
import springboot.db.replication.topic.model.request.SaveTopicRequest;
import springboot.db.replication.topic.repository.TopicRepository;
import springboot.db.replication.topic.service.query.TopicQueryService;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicQueryService topicQueryService;

    @Autowired
    public TopicService(TopicRepository topicRepository, TopicQueryService topicQueryService) {
        this.topicRepository = topicRepository;
        this.topicQueryService = topicQueryService;
    }

    @Transactional
    public void saveTopic(SaveTopicRequest saveTopicRequest) {
        Topic topic = new Topic();

        topic.setTitle(saveTopicRequest.getTitle());
        topic.setDescription(saveTopicRequest.getDescription());
        topic.setAuthor(saveTopicRequest.getAuthor());

        topicRepository.save(topic);
    }

    @Transactional
    public void modifyTopic(long topicId, SaveTopicRequest saveTopicRequest) {
        //Topic topic = topicRepository.findById(topicId).orElse(null);
        Topic topic = topicQueryService.getTopic(topicId);
        assert topic != null;

        topic.setTitle(saveTopicRequest.getTitle());
        topic.setDescription(saveTopicRequest.getDescription());
        topic.setAuthor(saveTopicRequest.getAuthor());
        topicRepository.save(topic);
    }

    @Transactional
    public void deleteTopic(long topicId) {
        //Topic topic = topicRepository.findById(topicId).orElse(null);
        Topic topic = topicQueryService.getTopic(topicId);
        assert topic != null;

        topicRepository.delete(topic);
    }


}
