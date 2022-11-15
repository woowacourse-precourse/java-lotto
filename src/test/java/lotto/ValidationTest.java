package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest extends NsTest {
    @DisplayName("입력 값이 숫자인지 확인한다.")
    @Test
    void isNumber() {
        String input1 = "NOT_A_NUMBER";
        assertThatThrownBy(() -> Validation.isNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매할 수 있는 금액인지(1000원으로 나눌 수 있는지) 확인한다.")
    @Test
    void appropriatePurchase() {
        int input1 = 8100;
        assertThatThrownBy(() -> Validation.multipleBasicAmount(input1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 쉼표로 나뉜 6개의 숫자인지 확인한다.")
    @Test
    void separatedByComma() {
        String input1 = "1,2,3,4,5";
        assertThatThrownBy(() -> Validation.canSplit(input1.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "1 2 3 4 5 6";
        assertThatThrownBy(() -> Validation.canSplit(input2.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "1.2.3.4.5.6";
        assertThatThrownBy(() -> Validation.canSplit(input3.split(",")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 안에서 중복되는 값이 있는지 확인한다.")
    @Test
    void repetition() {
        String input1 = "1,2,3,4,5,5";
        assertThatThrownBy(() -> Validation.noDuplication(input1.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int number1 = 5;
        assertThatThrownBy(() -> Validation.noDuplication(number1, numbers1))
                .isInstanceOf(IllegalArgumentException.class);

        List<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> Validation.noDuplication(numbers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 범위 내 값인지 확인한다.")
    @Test
    void inRange() {
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 47));
        assertThatThrownBy(() -> Validation.inRange(numbers1))
                .isInstanceOf(IllegalArgumentException.class);
        List<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 0));
        assertThatThrownBy(() -> Validation.inRange(numbers2))
                .isInstanceOf(IllegalArgumentException.class);
        int number1 = 47;
        assertThatThrownBy(() -> Validation.inRange(number1))
                .isInstanceOf(IllegalArgumentException.class);
        int number2 = 0;
        assertThatThrownBy(() -> Validation.inRange(number2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 리스트의 크기가 세팅 값의 번호 갯수와 일치하는지 확인한다.")
    @Test
    void correctSize() {
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> Validation.validNumbersSize(numbers1))
                .isInstanceOf(IllegalArgumentException.class);
        List<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> Validation.validNumbersSize(numbers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
