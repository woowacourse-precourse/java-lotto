package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("입력된 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByCharacter() {
        assertThatThrownBy(() -> new Money("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}