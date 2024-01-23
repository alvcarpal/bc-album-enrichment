package com.bc.album.infrastructure.db.spring.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuditTest {

    @InjectMocks
    private ConcreteAudit concreteAudit;

    @Test
    public void testAuditCreation() {
        concreteAudit.setCreatedBy("JohnDoe");
        concreteAudit.setUpdatedBy("JaneDoe");
        assertEquals("JohnDoe", concreteAudit.getCreatedBy());
        assertEquals("JaneDoe", concreteAudit.getUpdatedBy());
    }

}