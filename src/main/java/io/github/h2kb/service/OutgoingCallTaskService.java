package io.github.h2kb.service;

import io.github.h2kb.dto.OutgoingCallTaskDto;
import io.github.h2kb.model.OutgoingCallTask;

public interface OutgoingCallTaskService extends CommonService{

    int addOutgoingCallTask(String orderNumberId) throws Exception;

    Iterable<OutgoingCallTaskDto> getAllOutgoingCallTasks();

    OutgoingCallTaskDto getOutgoingCallTask(String orderNumber);
}
