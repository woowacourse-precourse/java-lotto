package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusNumTest {
    @DisplayName("보너스 번호가 숫자가 아니면 예외처리를 한다.")
    @Test
    void createBonusNumByNotNumber() {
        assertThatThrownBy(() -> new BonusNum("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상일 때")
    @Test
    void createBonusNum() {
        assertThatCode(() -> { new BonusNum("12"); }).doesNotThrowAnyException();
    }
}
