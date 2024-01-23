package com.bc.album.integration.rest;

import com.bc.album.boot.spring.config.AlbumEnrichmentSpringBootService;
import com.bc.album.utils.IntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(Parameterized.class)
@SpringBootTest(classes = AlbumEnrichmentSpringBootService.class)
public class AlbumsGetIntegrationTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final String output;

    public AlbumsGetIntegrationTest(String output) throws IOException {
        this.output = output;
    }

    @Parameterized.Parameters(name = "Test for: {0}}")
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {null}
        });
    }

    @Test
    public void albumsGetHappyPath() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders =
                         get("/albums")
                        .header("X-B3-TraceId", "123")
                        .header("Authorization", "231")
                        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockMvcRequestBuilders).andExpect(status().isOk());
    }


}
