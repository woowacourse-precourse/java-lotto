package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest(name = "입력된 구매 금액: {0}, 예외 던지기")
    @ValueSource(strings = {"1000j", "abc", " ", ""})
    void 구매_금액이_형식에_맞지_않으면_예외_던지기(String purchaseAmount) {
        assertThatThrownBy(() -> {
            InputValidator.validatePurchaseAmount(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "형식에 맞지 않는 당첨 번호: {0}")
    @ValueSource(strings = {
            "1,2,3,,4,5"
            , "12, 34 ,24, 45,1,2"
            , "1,2,3,4,5"
            , "1,2,3,4,5,6,7"
    })
    void 당첨번호_형식에_맞지_않으면_예외_던지기(String winningNumbers) {
        assertThatThrownBy(() -> {
            InputValidator.validateWinningNumbersFormat(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "중복이 있거나 범위 밖에 있는 당첨 번호: {0}")
    @MethodSource("winningNumbers")
    void 당첨번호_값이_범위_밖이거나_중복이_있으면_예외_던지기(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> {
            InputValidator.validateWinningNumbersRange(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<Arguments> winningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
                , Arguments.of(List.of(0, 2, 3, 4, 5, 6))
                , Arguments.of(List.of(1, 1, 2, 3, 4, 5))
                , Arguments.of(List.of(-3, 4, 5, 6, 7, 8))
        );
    }

    @ParameterizedTest(name = "범위와 형식에 맞지 않는 보너스 번호: {0}")
    @ValueSource(strings = {"0", "46", "-3", "", " ", "a"})
    void validateBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> {
            InputValidator.validateBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}