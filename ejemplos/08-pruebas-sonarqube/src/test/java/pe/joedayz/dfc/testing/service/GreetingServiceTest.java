package pe.joedayz.dfc.testing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetingServiceTest {

  private final GreetingService greetingService = new GreetingService();

  @Test
  void greetUsesName() {
    assertThat(greetingService.greet("Ana")).isEqualTo("Hola, Ana");
  }

  @Test
  void greetGuestWhenBlank() {
    assertThat(greetingService.greet("  ")).isEqualTo("Hola, invitado");
  }
}
