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

    @DisplayName("로또 번호 중 중복 번호가 있으면 예외 발생")
    @Test
    void validateDuplication() {
        assertThatThrownBy(() -> LottoValidationUtils.validate(List.of(1, 2, 3, 3, 3, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복 된 숫자가 없어야합니다.");
    }

    @DisplayName("로또 번호 중 0이 있으면 예외 발생")
    @Test
    void validateMinimumRange() {
        assertThatThrownBy(() -> LottoValidationUtils.validate(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }

    @DisplayName("로또 번호 중 46이 있으면 예외 발생")
    @Test
    void validateMaximumRange() {
        assertThatThrownBy(() -> LottoValidationUtils.validate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.");
    }
}
