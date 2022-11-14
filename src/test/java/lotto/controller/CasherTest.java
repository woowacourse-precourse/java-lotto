package lotto.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.view.BonusNumberReceiver;
import lotto.view.MoneyReceiver;
import lotto.view.WinNumberReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class CasherTest {

    @Mock
    Casher casher;

    @DisplayName("1000원 단위로 티켓을 발행한다.")
    @Test
    void issueTickets() {
        int money = 8000;
        int expected = 8;
        assertThat(casher.issueTickets(money)).isEqualTo(expected);
    }
}
