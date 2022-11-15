package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoMoney;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {
    @DisplayName("로또 구입 금액이 1,000보다 작을 경우 예외가 발생한다.")
    @Test
    void createMoneyByLessSize() {
        assertThatThrownBy(() -> new LottoMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createMoneyByDifferentUnit() {
        assertThatThrownBy(() -> new LottoMoney(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행할 로또 티켓 수량 구하기")
    @Test
    void createLottoTicketCount() {
        assertSimpleTest(() -> {
            LottoMoney lottoMoney = new LottoMoney(5000);
            lottoMoney.calculateLottoTicketCount();
            assertThat(lottoMoney.getLottoTicketCount()).isEqualTo(5);
        });
    }
}
