package io.amin.controllers;

import io.amin.entities.Poll;
import io.amin.repositories.PollRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PollController {

    private final PollRepository pollRepository;

    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable int pollId) {
        Poll savedPoll = pollRepository.findById(pollId).orElseThrow();
        return new ResponseEntity<>(savedPoll, HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        Poll savedPoll = pollRepository.save(poll);
        return new ResponseEntity<>(savedPoll, HttpStatus.CREATED);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<Poll> updatePoll(@PathVariable int pollId, @RequestBody Poll poll) {
        if ((poll.getId() != pollId)) {
            throw new RuntimeException("Poll Id doesn't Match");
        }
        Poll updatedPoll = pollRepository.save(poll);
        return new ResponseEntity<>(updatedPoll, HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<Poll> deletePoll(@PathVariable int pollId) {
        Poll savedPoll = pollRepository.findById(pollId).orElseThrow();
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(savedPoll, HttpStatus.OK);
    }

}
