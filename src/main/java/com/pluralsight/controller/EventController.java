package com.pluralsight.controller;

import com.pluralsight.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// saves the "event" model through page navigation / sessions
// references the same model object in processEvent
@SessionAttributes("event")
public class EventController {
    @RequestMapping(value="/event", method = RequestMethod.GET)
    public String displayEventPage(Model model) {
        Event event = new Event();
        event.setName("Jave User Group");
        model.addAttribute("event", event);

        return "event";
    }

    @RequestMapping(value="/event", method = RequestMethod.POST)
    public String processEvent(@ModelAttribute("event") Event event) {
        System.out.println(event);

        // will redirect as opposed to using the internal resource view resolver
        return "redirect:index.html";
    }
}
