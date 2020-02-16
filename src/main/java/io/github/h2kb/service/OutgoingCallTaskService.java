package io.github.h2kb.service;

import io.github.h2kb.dto.OutgoingCallTaskDto;

public interface OutgoingCallTaskService extends CommonService{

    int addOutgoingCallTask(String orderNumber) throws Exception;

    Iterable<OutgoingCallTaskDto> getAllOutgoingCallTasks();
}
