package io.amin.controllers;

import io.amin.entities.Poll;
import io.amin.entities.Vote;
import io.amin.exceptions.ResourceNotFoundException;
import io.amin.repositories.PollRepository;
import io.amin.repositories.VoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VoteController {

    private final VoteRepository voteRepository;
    private final PollRepository pollRepository;


    public VoteController(VoteRepository voteRepository, PollRepository pollRepository) {
        this.voteRepository = voteRepository;
        this.pollRepository = pollRepository;
    }

    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable int pollId, @RequestBody Vote vote) {
        pollRepository.findById(pollId).orElseThrow(() -> new ResourceNotFoundException("Poll with ID: " + pollId + " not found"));
        Vote savedVote = voteRepository.save(vote);
        return new ResponseEntity<>(savedVote, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}/votes")
    public ResponseEntity<List<Vote>> getAllVotes(@PathVariable int pollId) {
        List<Vote> savedVotes = new ArrayList<>();
        voteRepository.findByPollId(pollId).forEach(savedVotes::add);
        return new ResponseEntity<>(savedVotes, HttpStatus.OK);
    }

}
