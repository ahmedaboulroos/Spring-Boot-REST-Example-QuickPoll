package io.amin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class VoteResult {

    private int totalVotes;

    private Collection<OptionCount> results;

}
