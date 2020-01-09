package springboot.db.replication.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.db.replication.user.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
