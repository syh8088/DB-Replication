package springboot.db.replication.topic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.db.replication.topic.model.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
