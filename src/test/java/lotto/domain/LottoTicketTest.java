package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 금액에 숫자가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void inputMoneyContainNotNumber() {
        assertThatThrownBy(() -> new LottoTicket("700ab0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력 금액이 1000원 단위가 아닌 값이면 예외가 발생한다.")
    @Test
    void inputMoneyUnit() {
        assertThatThrownBy(() -> new LottoTicket("15050"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력 금액에 맞게 로또 갯수가 생성되었는지 테스트.")
    @Test
    void lottoTicketCount() {
        String inputMoney = "7000";
        LottoTicket lottoTicket = new LottoTicket(inputMoney);

        assertThat(lottoTicket.getTicket().size()).isEqualTo(7);
    }
}