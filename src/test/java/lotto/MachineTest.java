package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Machine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MachineTest {
  static Machine lottoMachine;

  @BeforeAll
  static void beforeAll() {
    lottoMachine = new Machine();
  }

  @DisplayName("티켓 판매 테스트")
  @Test
  void sellTicketTest() {
    int ticketCount = 5;
    List<Lotto> ticketList = lottoMachine.sellTicket(ticketCount);
    assertThat(ticketList.size()).isEqualTo(ticketCount);
  }

}
