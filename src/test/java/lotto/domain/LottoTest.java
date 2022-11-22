package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("중복된 숫자로 생성시 예외 발생")
    void DuplicateNumber() {
        assertThatThrownBy(() -> new Lotto("2,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 개수는 중복이 불가능합니다.");
    }

    @Test
    @DisplayName("숫자가 6개 미만")
    void LottoRangeTest() {
        assertThatThrownBy(() -> new Lotto("2,5,6")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 개수는 6개로 제한됩니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 없는 경우")
    void NotDuplicate() {
        assertThatNoException().isThrownBy(() -> new Lotto("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("문자열이 포함된 경우")
    void InStringNumber() {
        assertThatThrownBy(() -> new Lotto("1,aa,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
    }
}