package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.domain.Message;
import springboot.repos.MessageRepos;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepos messageRepos;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Karina") String name,
                           Map<String, Object> model) {

        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {

        Iterable<Message> messages = messageRepos.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {

        Message message = new Message(text, tag);
        messageRepos.save(message);

        Iterable<Message> messages = messageRepos.findAll();
        model.put("messages", messages);

        return "main";
    }
}