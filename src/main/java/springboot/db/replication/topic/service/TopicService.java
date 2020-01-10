package springboot.db.replication.topic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springboot.db.replication.topic.model.entity.Topic;
import springboot.db.replication.topic.model.request.SaveTopicRequest;
import springboot.db.replication.topic.repository.TopicMapper;
import springboot.db.replication.topic.repository.TopicRepository;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Autowired
    public TopicService(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
    }

    @Transactional(readOnly = true)
    public List<Topic> getTopics(String type) {

        List<Topic> topics;

        switch (type) {
            case "mybatis":
                topics = topicMapper.selectAllTopics();
                break;
            default:
                topics = topicRepository.findAll();
        }

        return topics;
    }

    @Transactional
    public List<Topic> getTopicsByMaster(String type) {

        List<Topic> topics;

        switch (type) {
            case "mybatis":
                topics = topicMapper.selectAllTopics();
                break;
            default:
                topics = topicRepository.findAll();
        }

        return topics;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Topic getTopic(long topicId) {
        return topicRepository.findById(topicId).orElse(null);
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
        Topic topic = getTopic(topicId);
        assert topic != null;

        topic.setTitle(saveTopicRequest.getTitle());
        topic.setDescription(saveTopicRequest.getDescription());
        topic.setAuthor(saveTopicRequest.getAuthor());
        topicRepository.save(topic);
    }

    @Transactional
    public void deleteTopic(long topicId) {
        //Topic topic = topicRepository.findById(topicId).orElse(null);
        Topic topic = getTopic(topicId);
        assert topic != null;

        topicRepository.delete(topic);
    }


}
