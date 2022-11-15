package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningCreateTest {


    @Test
    void constructor_success_test() {
        LottoWinningCreate lottoWinningCreate = new LottoWinningCreate("1,2,3,4,5,6");
        lottoWinningCreate.setBonusNumber("12");
        assertThat(lottoWinningCreate.getBonusNumber()).isEqualTo(12);
        assertThat(lottoWinningCreate.getWinningNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void constructor_fail_test() {
        Assertions.assertThatThrownBy(() -> new LottoWinningCreate("123,123,123,123,123,123")).isInstanceOf(IllegalArgumentException.class);

    }
}