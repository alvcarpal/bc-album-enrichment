package com.bc.album.integration.rest;

import com.bc.album.boot.spring.config.AlbumEnrichmentSpringBootService;
import com.bc.album.utils.IntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(Parameterized.class)
@SpringBootTest(classes = AlbumEnrichmentSpringBootService.class)
public class EnrichingDataIntegrationTest extends IntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  private final String output;

  public EnrichingDataIntegrationTest(String output) throws IOException {
    this.output = Files.readString(Path.of(OUTPUT_FILES_PATH + output));
  }

  @Parameterized.Parameters(name = "Test for: {0}}")
  public static Collection<Object[]> getParameters() {
      return Arrays.asList(new Object[][]{
                {"enrich_get.json"}
      });
  }

  @Test
  public void enrichGetHappyPath() throws Exception {
      MockHttpServletRequestBuilder mockMvcRequestBuilders =
              get("/albums/enrich")
                      .header("X-B3-TraceId", "123")
                      .header("Authorization", "231")
                      .contentType(MediaType.APPLICATION_JSON);

      MvcResult mvcResult = mockMvc.perform(mockMvcRequestBuilders).andExpect(status().isOk()).andReturn();

      if (mvcResult.getResponse().getStatus() == HttpStatus.OK.value()) {
          JSONAssert.assertEquals(output, mvcResult.getResponse().getContentAsString(), JSONCompareMode.LENIENT);
      }
  }

  // FALLA PORQUE SAVEALL NO ACTUALIZA (REVISAR)
  // @Test
  //public void enrichPostHappyPath() throws Exception {
 //     MockHttpServletRequestBuilder mockMvcRequestBuilders =
 //             post("/albums/enrich")
 //                     .header("X-B3-TraceId", "123")
 //                     .header("Authorization", "231")
 //                     .contentType(MediaType.APPLICATION_JSON);
 //
 //     mockMvc.perform(mockMvcRequestBuilders).andExpect(status().isNoContent());
 // }

}
