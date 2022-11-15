package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;
import org.junit.jupiter.api.Test;

class LottoDrawServiceTest {
    @Test
    void 로또_추첨_기능_테스트() {
        LottoTicket lottoTicket = new LottoTicket(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 11, 12, 13))));
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertThat(LottoDrawService.drawLotto(lottoTicket, lottoWinningNumber)).isInstanceOf(Map.class);
    }
}