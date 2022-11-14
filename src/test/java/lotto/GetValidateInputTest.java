package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetValidateInputTest {

    @DisplayName("숫자가 아닌 수를 넣었을때 예외가 발생한다.")
    @Test
    void getNumberByNotNumber() {
        String number = "112+";
        GetValidateInput getValidateInput = new GetValidateInput(number);

        assertThatThrownBy(() -> getValidateInput.getMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 수들을 넣었을때 예외가 발생한다.")
    @Test
    void getNumberByNotNumbers() {
        String number = "1,2,3,+,5,6";
        GetValidateInput getValidateInput = new GetValidateInput(number);

        assertThatThrownBy(() -> getValidateInput.getNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가, 로또에 포함된 수이면 예외가 발생한다.")
    @Test
    void getNumberByContainBonus() {
        String number = "17";
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 17);
        GetValidateInput getValidateInput = new GetValidateInput(number);

        assertThatThrownBy(() -> getValidateInput.getBonus(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위 안에 있는지 확인 발생한다.")
    @Test
    void getNumberByNotInRange() {
        String number = "17";
        List<Integer> lotto = List.of(1, 2, 3, 49, 5, 17);
        GetValidateInput getValidateInput = new GetValidateInput(number);

        assertThatThrownBy(() -> getValidateInput.getBonus(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}