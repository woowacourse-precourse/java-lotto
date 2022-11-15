package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    private static final List<Integer> NUMBER = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Bonus(NUMBER, "50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 문자를 입력하면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Bonus(NUMBER, "j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호랑 중복이면 예외가 발생한다.")
    @Test
    void createLottoBy() {
        assertThatThrownBy(() -> new Bonus(NUMBER, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
