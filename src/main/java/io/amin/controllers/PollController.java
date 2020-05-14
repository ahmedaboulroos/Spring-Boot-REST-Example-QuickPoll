package io.amin.controllers;

import io.amin.entities.Poll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PollController {

    @GetMapping("/polls")
    public List<Poll> getAllPolls() {
        return null;
    }

    @GetMapping("/polls/{pollId}")
    public Poll getPollById(@PathVariable int pollId) {
        return null;
    }

    @PostMapping("/polls")
    public Poll createNewPoll(@RequestBody Poll poll) {
        return null;
    }

    @PostMapping("/polls/{pollId}")
    public Poll updatePoll(@PathVariable int pollId, @RequestBody Poll poll) {
        return null;
    }

    @DeleteMapping("/polls/{pollId}")
    public Poll deletePoll(@PathVariable int pollId) {
        return null;
    }

}
