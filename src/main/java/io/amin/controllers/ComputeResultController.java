package io.amin.controllers;

import io.amin.dto.OptionCount;
import io.amin.dto.VoteResult;
import io.amin.entities.Vote;
import io.amin.repositories.VoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {

    private final VoteRepository voteRepository;

    public ComputeResultController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping("/computeResult")
    public ResponseEntity<VoteResult> computeResult(@RequestParam int pollId) {
        Iterable<Vote> savedVotes = voteRepository.findByPollId(pollId);
        VoteResult voteResult = computeResult(savedVotes);
        return new ResponseEntity<>(voteResult, HttpStatus.OK);
    }

    private VoteResult computeResult(Iterable<Vote> savedVotes) {
        VoteResult voteResult = new VoteResult();
        int totalVotes = 0;
        Map<Integer, OptionCount> tempMap = new HashMap<>();
        for (Vote v : savedVotes) {
            totalVotes++;
            OptionCount optionCount = tempMap.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());
        return voteResult;
    }

}
