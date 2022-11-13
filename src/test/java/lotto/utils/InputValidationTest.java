package lotto.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.views.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class InputValidationTest extends NsTest {

    private InputValidation inputValidation;

    @BeforeEach
    void beforeEach() {
        inputValidation = new InputValidation();
    }

    @DisplayName("입력한 값은 숫자여야만 한다.")
    @Test
    void checkInputIsNumber() {
        String input = "1000a";

        assertThatThrownBy(() -> inputValidation.checkNumber(input, Constant.REGEX_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값은 1000원 단위여야 한다.")
    @Test
    void checkInputIsThousand() {
        String input = "1200";

        assertThatThrownBy(() -> inputValidation.checkThousandMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨번호는 숫자여야한다.")
    @Test
    void checkWinningNumberIsNumeric() {
        String input = "1,2,3,4,a,6";

        assertThatThrownBy(() -> inputValidation.checkNumber(input, Constant.REGEX_WINNING_NUMBER_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨번호는 List<Integer>로 변환되서 받아져야한다.")
    @Test
    void checkWinningNumberIsConvert() {
        String answer = "1,2,3,4,5,6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        Input input = new Input();

        assertThat(input.convertToList(answer)).isEqualTo(result);
    }

    @DisplayName("입력받은 당첨번호는 개수가 총 6개여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6,7", "1000:1,2,3,4"} ,delimiter = ':')
    void checkWinningNumberSize(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_IS_SIX);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}