package io.github.sazid.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    // Willing setting `topicId` instead of `id` as variable name to demonstrate
    // how path variable can be named differently and accessed.
    @GetMapping("/topics/{topicId}")
    public Topic getTopic(@PathVariable("topicId") String id) {
        return topicService.getTopic(id);
    }

    // @RequestMapping(value = "/topics", method = RequestMethod.POST)
    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
