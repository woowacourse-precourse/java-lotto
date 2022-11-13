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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

    @DisplayName("입력받은 2자리수 이상의 금액은 맨 앞자리가 0이될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"01", "01000"})
    void checkFirstNumberIsNotZero(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ErrorMessage.FIRST_NUMBER_IS_NOT_ZERO);
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

    @DisplayName("입력받은 당첨번호는 정렬이 되어있어야 한다.")
    @Test
    void checkWinningNumberSorted() {
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        InputStream in = new ByteArrayInputStream("6,5,4,3,2,1".getBytes());
        System.setIn(in);

        Input input = new Input();
        List<Integer> answer = input.getWinningNumber();

        assertThat(answer).isEqualTo(result);
    }

    @DisplayName("입력받은 당첨번호는 1~45의 범위안에 들어가야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,0,4,5,6", "1000:46,1,2,3,4,5"}, delimiter = ':')
    void checkWinningNumberInRange(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_NUMBER_IN_RANGE);
        });
    }

    @DisplayName("입력받은 보너스 번호는 숫자여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6:a", "1000:1,2,3,4,5,6:2a"}, delimiter = ':')
    void checkBonusNumberInRange(String firstInput, String secondInput, String thirdInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput, thirdInput);
            assertThat(output()).contains(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}