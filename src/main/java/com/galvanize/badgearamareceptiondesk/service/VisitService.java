package com.galvanize.badgearamareceptiondesk.service;

import com.galvanize.badgearamareceptiondesk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

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

        Visit visit = Visit.builder()
                .id(visitId)
                .phoneNumber(extendedPerson.getPhoneNumber())
                .hostName(extendedPerson.getHostName())
                .hostPhoneNumber(extendedPerson.getHostPhoneNumber())
                .purposeOfVisit(extendedPerson.getPurposeOfVisit())
                .active(true)
                .registerDate(new Date())
                .status(VisitStatus.UNVERIFIED)
                .build();
        visitRepository.save(visit);

    }

    public List<ExtendedPersonFrontEnd> getVisitByPhoneNumber(String phoneNumber) {
        List<ExtendedPersonFrontEnd> result = new ArrayList<>();
        if (phoneNumber == null)
            throw new IllegalArgumentException();
        Long phoneLong = Long.parseLong(phoneNumber.replaceAll("[^0-9]", ""));
        List<Visit> allByPhoneNumber = visitRepository.findAllByPhoneNumber(phoneLong);
        allByPhoneNumber.forEach(e -> {
            result.add(ExtendedPersonFrontEnd.builder()
                    .phoneNumber(Long.toString(e.getPhoneNumber()))
                    .hostName(e.getHostName())
                    .hostPhone(Long.toString(e.getHostPhoneNumber()))
                    .active(e.getActive())
                    .status(e.getStatus())
                    .registerDate(e.getRegisterDate())
                    .checkedInDate(e.getCheckedInDate())
                    .checkedOutDate(e.getCheckedOutDate())
                    .build());
        });

        return result;

    }

    public Iterable<ExtendedPersonFrontEnd> getAll() {
        List<ExtendedPersonFrontEnd> result = new ArrayList<>();
        StreamSupport.stream(visitRepository.findAll().spliterator(), false)
                .forEach(e -> {
                    result.add(
                            ExtendedPersonFrontEnd.builder()
                                    .hostName(e.getHostName())
                                    .hostPhone(Long.toString(e.getHostPhoneNumber()))
                                    .registerDate(e.getRegisterDate())
                                    .build());
                });
        return result;
    }
}
