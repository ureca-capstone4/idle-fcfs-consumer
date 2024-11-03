package com.ureca.idle.caller;


import com.ureca.idle.consumer.Submission;
import com.ureca.idle.consumer.SubmissionConsumer;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionConsumerCallerImpl implements SubmissionConsumerCaller {

    private final SubmissionConsumer submissionConsumer;

    // TODO Poll 주기 커스텀을 위해 TaskSchedulerExecutor 도입 고려
    @Override
    @SqsListener(queueNames = "FCFS", maxMessagesPerPoll = "10")
    public void callConsumer(List<Submission> submissions) {
        log.info(submissions.toString());
        submissionConsumer.consumeSubmissions(submissions);
    }
}
