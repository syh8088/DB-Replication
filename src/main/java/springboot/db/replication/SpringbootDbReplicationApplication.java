package springboot.db.replication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootDbReplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDbReplicationApplication.class, args);
    }

}
