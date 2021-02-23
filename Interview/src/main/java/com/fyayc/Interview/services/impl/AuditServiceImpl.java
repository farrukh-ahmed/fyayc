package com.fyayc.Interview.services.impl;

import com.fyayc.Interview.entities.AuditTrailEntity;
import com.fyayc.Interview.repositories.AuditTrailRepository;
import com.fyayc.Interview.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditTrailRepository auditTrailRepository;

    @Override
    public List<AuditTrailEntity> getAuditTrail(Date startDate, Date endDate) {
        return auditTrailRepository.findByDateCreatedBetween(startDate,endDate);
    }
}
