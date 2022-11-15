package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void getInputByNonNumeric() {
        assertThatThrownBy(() -> new InputView().validateNumeric("-10000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호에 숫자와 구분자(,) 외 다른 입력이 들어오면 예외가 발생한다.")
    @Test
    void getInputByUnValidSeparator() {
        assertThatThrownBy(() -> new InputView().validateSeparator("1,4,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자를 쉼표(,)로 구분하여 입력하세요.");
    }

    @DisplayName("입력 문자열 숫자 리스트로 변환하기")
    @Test
    void changeStringToListTest() {
        String input = "1,4,5,2,7";
        List<Integer> result = List.of(1, 4, 5, 2, 7);
        assertThat(new InputView().changeStringToList(input))
                .isEqualTo(result);
    }

    @DisplayName("보너스 번호는 1이상 45이하의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateNumberRangeTest() {
        int input = 0;
        assertThatThrownBy(() -> new InputView().validateNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1이상 45이하의 숫자만 가능합니다.");
    }
}