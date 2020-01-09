package springboot.db.replication.user.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user1")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String email;
    private String name;
    private String pw;
}
