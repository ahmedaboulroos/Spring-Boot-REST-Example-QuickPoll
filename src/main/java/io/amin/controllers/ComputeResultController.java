package io.amin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeResultController {

    @GetMapping("/computeResult")
    public void computeResult(@RequestParam int pollId) {

    }

}
