package io.github.sazid.courseapi.topic;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repo;

//    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framework introduction"),
//            new Topic("go", "Go STD", "Introduction to Go standard library"),
//            new Topic("rust", "Rust Basics", "Introduction to Rust")
//    ));

    public List<Topic> getAllTopics() {
        val topics = new ArrayList<Topic>();
        repo.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
//        Optional<Topic> topic = topics
//                .stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst();
//        return topic.orElse(null);
        return repo.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        repo.save(topic);
    }

    public void updateTopic(Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.get(i).getId().equals(id)) {
//                topics.set(i, topic);
//            }
//        }
        repo.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        repo.deleteById(id);
    }
}
