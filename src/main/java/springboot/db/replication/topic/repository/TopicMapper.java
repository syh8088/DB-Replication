package springboot.db.replication.topic.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springboot.db.replication.topic.model.entity.Topic;

import java.util.List;

@Mapper
@Repository
public interface TopicMapper {
    List<Topic> selectAllTopics();
}
