package springboot.db.replication.topic.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTopicRequest {
    private String title;
    private String description;
    private String author;
}
