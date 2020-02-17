package io.github.h2kb.dto;

import io.github.h2kb.model.Customer;
import io.github.h2kb.model.DeliveryOrder;
import io.github.h2kb.model.OutgoingCallTask;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class OutgoingCallTaskDtoConverter {

    private String pattern = "dd-MM-yyyy HH:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public OutgoingCallTaskDto convert(OutgoingCallTask outgoingCallTask, DeliveryOrder deliveryOrder, Customer customer) {
        OutgoingCallTaskDto outgoingCallTaskDto = new OutgoingCallTaskDto();
        outgoingCallTaskDto.setFirstName(customer.getFirstName());
        outgoingCallTaskDto.setLastName(customer.getLastName());
        outgoingCallTaskDto.setPhoneNumber(customer.getPhoneNumber());
        outgoingCallTaskDto.setOrderNumber(deliveryOrder.getOrderNumber());
        outgoingCallTaskDto.setCreateAt(outgoingCallTask.getCreateAt());

        return outgoingCallTaskDto;
    }
}
