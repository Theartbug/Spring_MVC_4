package com.pluralsight.controller;

import com.pluralsight.model.Attendee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AttendeeController {

    @RequestMapping(value = "/attendee", method = RequestMethod.GET)
    public String displayAttendeePage(Model model) {
        Attendee attendee = new Attendee();

        model.addAttribute("attendee", attendee);

        return "attendee";
    }

    @RequestMapping(value = "/attendee", method = RequestMethod.POST)
    // signature must go in this order or will not work
    public String processAttendee(@Valid Attendee attendee, BindingResult result, Model m) {
        System.out.println(attendee);

        // must check if there are errors
        if(result.hasErrors()) return "attendee";

        return "redirect:index.html";
    }
}
