package com.ureca.idle.consumer;


import java.util.List;

public interface SubmissionConsumer {

    void consumeSubmissions(List<Submission> submissions);
}
