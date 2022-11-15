package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayTest {

    @DisplayName("구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Pay("5030"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Pay("3f40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
