package io.github.h2kb.dto;

import io.github.h2kb.model.Customer;
import io.github.h2kb.model.DeliveryOrder;
import io.github.h2kb.model.OutgoingCallTask;
import org.springframework.stereotype.Service;

@Service
public class OutgoingCallTaskDtoConverter {

    public OutgoingCallTaskDto converter(OutgoingCallTask outgoingCallTask, DeliveryOrder deliveryOrder, Customer customer) {
        OutgoingCallTaskDto outgoingCallTaskDto = new OutgoingCallTaskDto();
        outgoingCallTaskDto.setFirstName(customer.getFirstName());
        outgoingCallTaskDto.setLastName(customer.getLastName());
        outgoingCallTaskDto.setPhoneNumber(customer.getPhoneNumber());
        outgoingCallTaskDto.setOrderNumber(deliveryOrder.getOrderNumber());
        outgoingCallTaskDto.setCreateAt(outgoingCallTask.getCreateAt());

        return outgoingCallTaskDto;
    }
}
