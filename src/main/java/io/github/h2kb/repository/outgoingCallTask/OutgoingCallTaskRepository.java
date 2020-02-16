package io.github.h2kb.repository.outgoingCallTask;

import io.github.h2kb.model.OutgoingCallTask;

public interface OutgoingCallTaskRepository {

    Iterable<OutgoingCallTask> findAll();

    int addOutgoingCallTask(Long orderNumberId);
}
