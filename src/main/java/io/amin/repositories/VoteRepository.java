package io.amin.repositories;

import io.amin.entities.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {

    @Query(value = "SELECT v.* FROM options o, votes v WHERE o.poll_id = ?1 AND v.option_id = o.option_id", nativeQuery = true)
    Iterable<Vote> findByPollId(int pollId);

}
