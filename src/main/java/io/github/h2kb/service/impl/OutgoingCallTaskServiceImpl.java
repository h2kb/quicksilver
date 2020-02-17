package io.github.h2kb.service.impl;

import io.github.h2kb.dto.OutgoingCallTaskDto;
import io.github.h2kb.dto.OutgoingCallTaskDtoConverter;
import io.github.h2kb.model.Customer;
import io.github.h2kb.model.DeliveryOrder;
import io.github.h2kb.model.OutgoingCallTask;
import io.github.h2kb.repository.customer.CustomerRepository;
import io.github.h2kb.repository.deliveryOrder.DeliveryOrderRepository;
import io.github.h2kb.repository.outgoingCallTask.OutgoingCallTaskRepository;
import io.github.h2kb.service.OutgoingCallTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OutgoingCallTaskServiceImpl implements OutgoingCallTaskService {

    @Autowired
    OutgoingCallTaskRepository outgoingCallTaskRepository;

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OutgoingCallTaskDtoConverter dtoConverter;

    @Override
    public int addOutgoingCallTask(String orderNumber) throws Exception {
        Optional<DeliveryOrder> optionalDeliveryOrder = Optional.ofNullable(deliveryOrderRepository.findByOrderNumber(orderNumber));

        if (optionalDeliveryOrder.isPresent()) {
            return outgoingCallTaskRepository.addOutgoingCallTask(optionalDeliveryOrder.get().getId());
        } else {
            throw new Exception(NOT_FOUND);
        }

    }

    @Override
    public Iterable<OutgoingCallTaskDto> getAllOutgoingCallTasks() {
        ArrayList<OutgoingCallTask> outgoingCallTasks = (ArrayList<OutgoingCallTask>) outgoingCallTaskRepository.findAll();
        ArrayList<OutgoingCallTaskDto>outgoingCallTaskDtos = new ArrayList<OutgoingCallTaskDto>();

        for (OutgoingCallTask outgoingCallTask : outgoingCallTasks) {
            DeliveryOrder deliveryOrder = deliveryOrderRepository.findById(outgoingCallTask.getDeliveryOrderId());
            Customer customer = customerRepository.findById(deliveryOrder.getCustomerId());

            outgoingCallTaskDtos.add(dtoConverter.convert(outgoingCallTask, deliveryOrder, customer));
        }

        return outgoingCallTaskDtos;
    }

    @Override
    public OutgoingCallTaskDto getOutgoingCallTask(String orderNumber) {
        DeliveryOrder deliveryOrder = deliveryOrderRepository.findByOrderNumber(orderNumber);
        Customer customer = customerRepository.findById(deliveryOrder.getCustomerId());
        OutgoingCallTask outgoingCallTask = outgoingCallTaskRepository.findByDeliveryOrderNumberId(deliveryOrder.getId());

        return dtoConverter.convert(outgoingCallTask, deliveryOrder, customer);
    }

}
