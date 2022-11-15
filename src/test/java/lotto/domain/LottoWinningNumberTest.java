package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {
    @Test
    void 당첨_번호_생성_테스트() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(lottoWinningNumber).isInstanceOf(LottoWinningNumber.class);
        assertThat(lottoWinningNumber.getBonusNumber()).isEqualTo(7);
        assertThat(lottoWinningNumber.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호_보너스_번호_중복_예외_발생() {
        assertThatThrownBy(() -> new LottoWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }


}