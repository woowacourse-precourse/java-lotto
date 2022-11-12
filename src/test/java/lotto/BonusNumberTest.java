package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호에 숫자 이외의 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void inputBonusNumberByCharacter() {
        assertThatThrownBy(() -> new BonusNumber("ab-"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("."))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
