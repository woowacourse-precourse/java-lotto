package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    @DisplayName("랜덤으로 생성된 로또 티켓의 로또 개수가 구입한 로또 개수와 다르면 예외를 발생시킨다.")
    void createGenerateLottoTicketOutOfLottoAmount() {
        List<Lotto> lottoTicket = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lottoTicket.add(Lotto.generateRandomLotto());
        }

        assertThatThrownBy(() -> new LottoTicket(lottoTicket, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}