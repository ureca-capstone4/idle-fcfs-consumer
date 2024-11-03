package com.ureca.idle.caller;


import com.ureca.idle.consumer.Submission;

import java.util.List;


public interface SubmissionConsumerCaller {

    void callConsumer(List<Submission> submissions);
}
