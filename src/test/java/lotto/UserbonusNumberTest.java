package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.UserbonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserbonusNumberTest {

    @DisplayName("잘못된 형식으로 입력하면 예외가 발생한다.")
    @Test
    void bugInput() {
        assertThatThrownBy(() -> new UserbonusNumber("1 2")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserbonusNumber("1 2@")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserbonusNumber("1@ 2")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserbonusNumber("1 25 d")).isInstanceOf(
            IllegalArgumentException.class);
    }


}
