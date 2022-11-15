package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("1미만의 숫자면 예외가 발생한다.")
    @Test
    void underMin() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45초과인 숫자면 예외가 발생한다.")
    @Test
    void overMax() {
        assertThatThrownBy(() -> new LottoNumber(60))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
