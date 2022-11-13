package lotto.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.validation.InputValidation;
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
    @ParameterizedTest
    @ValueSource(strings = {" ", "1234a"})
    void checkInputIsNumber(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
        });
    }

    @DisplayName("입력받은 값은 1000원 단위여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "9998", "1002"})
    void checkInputIsThousand(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ErrorMessage.LOTTO_MUST_THOUSAND_PRICE);
        });
    }

    @DisplayName("입력받은 당첨번호는 숫자여야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,a", "1000:a,b,c,d"}, delimiter = ':')
    void checkWinningNumberIsNumeric(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
        });
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
    @CsvSource(value = {"1000:1,2,3,4,5,6,7", "1000:1,2,3,4"}, delimiter = ':')
    void checkWinningNumberSize(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_IS_SIX);
        });
    }

    @DisplayName("입력받은 당첨번호는 중복이 없어야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,3,2,1", "1000:1,2,3,4,5,5"}, delimiter = ':')
    void checkWinningNumberDuplicated(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_IS_DISTINCT);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}