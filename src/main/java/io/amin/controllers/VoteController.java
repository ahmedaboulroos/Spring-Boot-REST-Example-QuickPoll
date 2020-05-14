package io.amin.controllers;

import io.amin.entities.Vote;
import io.amin.repositories.VoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    private final VoteRepository voteRepository;

    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable int pollId, @RequestBody Vote vote) {
        Vote savedVote = voteRepository.save(vote);

        return null;
    }

}
