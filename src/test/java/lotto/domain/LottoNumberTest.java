package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @DisplayName("보너스 번호가 1~45 범위 밖이면 예외가 발생한다.")
    @Test
    void createWinningResultByRange() {
        assertThatThrownBy(() -> new LottoNumber(55))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위 밖의 숫자가 포함되어 있습니다.");
    }
}