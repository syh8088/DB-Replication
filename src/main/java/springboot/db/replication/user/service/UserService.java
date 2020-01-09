package springboot.db.replication.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.db.replication.user.model.entity.User;
import springboot.db.replication.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    public List<User> getUsersByMaster() {

        List<User> users = userRepository.findAll();
        return users;
    }

}
