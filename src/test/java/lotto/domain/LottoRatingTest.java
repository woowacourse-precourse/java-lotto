package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRatingTest {
    @DisplayName("로또 번호와 당첨 번호 비교 테스트")
    @Test
    void compareLottoTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoTicket = List.of(lotto);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 5, 6, 33, 39, 43), 7);
        LottoRating lottoRating = new LottoRating(lottoTicket, winningLotto);

        assertThat(lottoRating.compareLotto(lotto)).isEqualTo(3);
    }
}