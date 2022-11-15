package lotto.view.vlidation;

import lotto.utils.ConvertUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.view.vlidation.InputCorrectLottoValidator.validate;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputCorrectLottoValidatorTest {

    @DisplayName("정상적인 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,22,33,10,25", "42,32,13,23,40,11"})
    void normalInput(String input) {
        List<Integer> integers = ConvertUtil.convertInputToIntegerList(input);
        assertThatNoException()
                .isThrownBy(() -> validate(integers));
    }

    @DisplayName("7개 이상 숫자 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,6,42", "1,2,22,33,10,25,2", "42,32,13,23,40,11,1"})
    void overSixNumberTest(String input) {
        List<Integer> integers = ConvertUtil.convertInputToIntegerList(input);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(integers));

        // then
        assertEquals("[ERROR] 6개의 수만 입력할 수 있습니다.", exception.getMessage());
    }

    @DisplayName("7개 이상 숫자 입력")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1,2,3,4,5,2", "1,2,22,33,10,22", "42,31,31,23,40,11"})
    void duplicatedNumberTest(String input) {
        List<Integer> integers = ConvertUtil.convertInputToIntegerList(input);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> validate(integers));

        // then
        assertEquals("[ERROR] 중복된 수를 가질 수 없습니다.", exception.getMessage());
    }

}