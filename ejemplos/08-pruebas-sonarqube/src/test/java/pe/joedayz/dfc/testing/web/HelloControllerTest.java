package pe.joedayz.dfc.testing.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pe.joedayz.dfc.testing.service.GreetingService;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private GreetingService greetingService;

  @Test
  void returnsGreetingFromService() throws Exception {
    when(greetingService.greet("Luis")).thenReturn("Hola, Luis");
    mockMvc
        .perform(get("/api/hello").param("name", "Luis"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hola, Luis"));
  }
}
