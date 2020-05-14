package io.amin.controllers;

import io.amin.entities.Poll;
import io.amin.exceptions.ResourceNotFoundException;
import io.amin.exceptions.ResourcePathAndBodyMismatchException;
import io.amin.repositories.PollRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PollController {

    private final PollRepository pollRepository;

    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @GetMapping("/polls")
    public ResponseEntity<List<Poll>> getAllPolls() {
        List<Poll> allPolls = new ArrayList<>();
        pollRepository.findAll().forEach(allPolls::add);
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable int pollId) {
        Poll savedPoll = pollRepository.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll with ID: " + pollId + " not found"));
        return new ResponseEntity<>(savedPoll, HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<Poll> createPoll(@Valid @RequestBody Poll poll) {
        Poll savedPoll = pollRepository.save(poll);
        return new ResponseEntity<>(savedPoll, HttpStatus.CREATED);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<Poll> updatePoll(@PathVariable int pollId, @RequestBody Poll poll) {
        if ((poll.getId() != pollId)) {
            throw new ResourcePathAndBodyMismatchException("Poll<Path> ID: " + pollId + ", Poll<Body> ID: " + poll.getId() + " Doesn't Match");
        }
        Poll updatedPoll = pollRepository.save(poll);
        return new ResponseEntity<>(updatedPoll, HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<Poll> deletePoll(@PathVariable int pollId) {
        Poll savedPoll = pollRepository.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll with ID: " + pollId + " not found"));
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(savedPoll, HttpStatus.OK);
    }

}
