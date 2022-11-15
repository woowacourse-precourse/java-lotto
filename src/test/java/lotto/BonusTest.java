package lotto;

import static lotto.util.ConsoleUtility.writeConsole;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.InputUtility;
import lotto.util.Type;
import lotto.util.ValidationUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {


    @DisplayName("보너스 input 확인- 숫자가 아닌 문자열이 들어온 경우")
    @Test
    void bonusIsNotDigit() {
        writeConsole("D");
        assertThatThrownBy(() -> InputUtility.readLine(Type.BONUS.getValue()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 input 확인- 1-45이외의 숫자가 들어온경우")
    @Test
    void bonusIsOutOfRange() {
        writeConsole("46");
        assertThatThrownBy(() -> InputUtility.readLine(Type.BONUS.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 input 확인- 로또와 중복되는 값이 있는 경우")
    @Test
    void bonusIsDuplicated() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        writeConsole("1");
        assertThatThrownBy(() -> ValidationUtility.isValidBonus(lotto, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }


}
