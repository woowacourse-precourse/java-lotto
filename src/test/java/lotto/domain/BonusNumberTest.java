package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {
    @DisplayName("보너스 숫자 1부터 45까지는 문제 없이 생성된다")
    @ValueSource(ints = {1, 11, 22, 33, 44, 45})
    @ParameterizedTest
    void BonusNumber_생성자_정상작동(int input) {
        assertDoesNotThrow(() -> new BonusNumber(input));
    }

    @DisplayName("보너스 숫자가 범위 밖이면 에러를 발생시킨다")
    @ValueSource(ints = {0, 46, -33})
    @ParameterizedTest
    void BonusNumber_생성자_범위밖_예외(int input) {
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));
    }

    @DisplayName("isBonusNumber 메서드는 보너스 숫자와 일치하는지 여부를 반한한다")
    @ValueSource(ints = {1, 33, 45})
    @ParameterizedTest
    void isBonusNumber_메서드_정상작동(int input) {
        assertThat(new BonusNumber(input).isBonusNumber(input)).isTrue();
        assertThat(new BonusNumber(input).isBonusNumber(input + 1)).isFalse();
    }
}
