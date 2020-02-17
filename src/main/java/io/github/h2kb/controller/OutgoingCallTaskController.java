package io.github.h2kb.controller;

import io.github.h2kb.dto.OutgoingCallTaskDto;
import io.github.h2kb.form.DeliveryOrderForm;
import io.github.h2kb.model.OutgoingCallTask;
import io.github.h2kb.service.impl.OutgoingCallTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/quicksilver")
public class OutgoingCallTaskController {

    @Autowired
    OutgoingCallTaskServiceImpl outgoingCallTaskService;

    @GetMapping("/operator")
    public String getAllOutgoingCallTasks(Model model) {
        DeliveryOrderForm deliveryOrderForm = new DeliveryOrderForm();
        model.addAttribute("deliveryOrderForm", deliveryOrderForm);
        ArrayList<OutgoingCallTaskDto> outgoingCallTaskDtos = (ArrayList<OutgoingCallTaskDto>) outgoingCallTaskService.getAllOutgoingCallTasks();
        model.addAttribute("outgoingCallTasks", outgoingCallTaskDtos);
        return "operator";
    }

    @PostMapping("/operator")
    public String findByDeliveryOrderNumber(@ModelAttribute(name = "deliveryOrderForm") DeliveryOrderForm deliveryOrderForm, Model model) {
        String orderNumber = deliveryOrderForm.getOrderNumber();
        OutgoingCallTaskDto outgoingCallTaskDto = outgoingCallTaskService.getOutgoingCallTask(orderNumber);
        model.addAttribute("outgoingCallTasks", outgoingCallTaskDto);
        return "operator";
    }

    @GetMapping("/courier")
    public String addOutgoingCallTaskForm(Model model) {

        DeliveryOrderForm deliveryOrderForm = new DeliveryOrderForm();
        model.addAttribute("deliveryOrderForm", deliveryOrderForm);
        return "courier";
    }

    @PostMapping("/courier")
    public String addOutgoingCallTask(@ModelAttribute(name = "deliveryOrderForm") DeliveryOrderForm deliveryOrderForm, Model model) throws Exception {
        String orderNumber = deliveryOrderForm.getOrderNumber();

        if (orderNumber != null && orderNumber.length() > 0) {
            outgoingCallTaskService.addOutgoingCallTask(orderNumber);

            return "redirect:/quicksilver/courier";
        }

        model.addAttribute("errorMessage", "Field of order is empty.");
        return "courier";
    }
}
