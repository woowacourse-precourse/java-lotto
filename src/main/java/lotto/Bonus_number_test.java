package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Bonus_number_test {

    @DisplayName("보너스 번호의 개수가 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Bonus_number("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
