package com.fyayc.Interview.repositories;

import com.fyayc.Interview.entities.AuditTrailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuditTrailRepository extends JpaRepository<AuditTrailEntity,Integer> {

    List<AuditTrailEntity> findByDateCreatedBetween(Date startDate, Date endDate);

}
