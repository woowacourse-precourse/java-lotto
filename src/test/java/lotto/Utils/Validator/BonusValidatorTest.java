package lotto.Utils.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusValidatorTest {
    public static List<Integer> lotto = List.of(1,2,3,4,5,6);

    @DisplayName("입력받은 보너스 번호가 숫자가 아니면 예외를 발생한다.")
    @Test
    void createBonusByNotInteger() {
        String input = "a";
        assertThatThrownBy(() -> new BonusValidator(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 1~45 사이의 정수가 아니면 예외를 발생한다.")
    @Test
    void createBonusByNotRange() {
        String input = "-1";
        assertThatThrownBy(() -> new BonusValidator(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 당첨로또에 포함되면 예외를 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        String input = "6";
        assertThatThrownBy(() -> new BonusValidator(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
