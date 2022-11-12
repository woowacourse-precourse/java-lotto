package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("구입 금액에 숫자 이외의 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void inputMoneyByCharacter() {
        assertThatThrownBy(() -> new Purchase("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
