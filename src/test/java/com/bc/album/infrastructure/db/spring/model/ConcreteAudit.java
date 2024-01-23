package com.bc.album.infrastructure.db.spring.model;

import com.bc.album.infrastructure.db.springdata.model.Audit;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class ConcreteAudit extends Audit {
    // It is used in order to test Audit class
}
