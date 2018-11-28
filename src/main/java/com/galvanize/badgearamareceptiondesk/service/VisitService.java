package com.galvanize.badgearamareceptiondesk.service;

import com.galvanize.badgearamareceptiondesk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    VisitRepository visitRepository;


    public void verifySave(ExtendedPerson extendedPerson) {

        List<Visit> visits = visitRepository.findAllByPhoneNumberAndStatusEqualsAndRegisterDateGreaterThan(
                extendedPerson.getPhoneNumber(), VisitStatus.UNVERIFIED, Utils.atStartOfDay(new Date()));
        Long visitId = null;
        if (visits.size() > 0)
            visitId = visits.get(0).getId();

        visitRepository.save(Visit.builder()
                .id(visitId)
                .phoneNumber(extendedPerson.getPhoneNumber())
                .hostName(extendedPerson.getHostName())
                .hostPhoneNumber(extendedPerson.getHostPhoneNumber())
                .purposeOfVisit(extendedPerson.getPurposeOfVisit())
                .active(true)
                .registerDate(new Date())
                .status(VisitStatus.UNVERIFIED)
                .build());

    }
}
