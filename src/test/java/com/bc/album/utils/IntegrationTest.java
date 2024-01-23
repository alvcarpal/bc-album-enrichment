package com.bc.album.utils;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ActiveProfiles("integration")
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase
public abstract class IntegrationTest {

    @ClassRule
    public static final SpringClassRule scr = new SpringClassRule();

    @Rule
    public final SpringMethodRule smr = new SpringMethodRule();

}
