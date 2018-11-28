package com.galvanize.badgearamareceptiondesk;


import com.galvanize.badgearamareceptiondesk.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guard")
public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping("/visitor/{phoneNumber}")
    public ExtendedPersonFrontEnd getVisitByPhoneNumber(@PathVariable String phoneNumber) {
        return visitService.getVisitByPhoneNumber(phoneNumber);
    }

}
