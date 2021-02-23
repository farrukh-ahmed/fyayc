package com.fyayc.Interview.controllers;

import com.fyayc.Interview.common.Meta;
import com.fyayc.Interview.common.Response;
import com.fyayc.Interview.entities.AuditTrailEntity;
import com.fyayc.Interview.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    AuditService auditService;

    @GetMapping("/")
    public ResponseEntity<Response<List<AuditTrailEntity>>> getAuditTrail(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return new ResponseEntity<>(
                new Response<>(auditService.getAuditTrail(startDate,endDate),
                        new Meta("Audit trail has been fetched.", HttpStatus.OK.value())),HttpStatus.OK);
    }
}
