package com.fyayc.Interview.services;

import com.fyayc.Interview.entities.AuditTrailEntity;

import java.util.Date;
import java.util.List;

public interface AuditService {

    List<AuditTrailEntity> getAuditTrail(Date startDate, Date endDate);
}
