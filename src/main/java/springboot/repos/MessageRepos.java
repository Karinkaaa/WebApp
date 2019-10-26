package springboot.repos;

import org.springframework.data.repository.CrudRepository;
import springboot.domain.Message;


public interface MessageRepos extends CrudRepository<Message, Long> {
}
