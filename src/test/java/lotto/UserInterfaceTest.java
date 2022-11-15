package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInterfaceTest {
    @DisplayName("로또 구입 금액 입력이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyCanNotDeivdedOneThousand() {
        assertThatThrownBy(() -> UserInterface.checkDividedOneThousand(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

}