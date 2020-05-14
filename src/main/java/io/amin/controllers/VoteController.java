package io.amin.controllers;

import io.amin.entities.Vote;
import io.amin.repositories.VoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {

    private final VoteRepository voteRepository;

    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable int pollId, @RequestBody Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        return new ResponseEntity<>(savedVote, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}/votes")
    public ResponseEntity<Iterable<Vote>> getAllVotes(@PathVariable int pollId) {
        Iterable<Vote> savedVotes = voteRepository.findByPollId(pollId);
        return new ResponseEntity<>(savedVotes, HttpStatus.OK);
    }

}
