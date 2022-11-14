package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @DisplayName("구입금액이 정상적이면 로또가 발행된다.")
    @Test
    void createMoneyByDivisible1000() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // when
        List<Lotto> lottos = lottoTicket.buyLotto("1000");

        // then
        assertThat(lottos.size())
                .isEqualTo(1);
    }

    @DisplayName("구입금액에 숫자가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotInteger() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // expect
        assertThatThrownBy(() -> lottoTicket.buyLotto("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @DisplayName("구입금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyByLessThan1000() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // expect
        assertThatThrownBy(() -> lottoTicket.buyLotto("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 이상을 입력해 주세요.");
    }

    @DisplayName("사용자의 입력이 1,000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createBuyLotto() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // expect
        assertThatThrownBy(() -> lottoTicket.buyLotto("3800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
    }
}
