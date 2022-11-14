package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationUtilsTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외 발생")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> LottoValidationUtils.validate(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개 이어야 합니다.");
    }
}
