package lotto.common.exception;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    Validator validator;

    @BeforeEach()
    void init(){
        validator = new Validator();
    }

    @DisplayName("정수로 input이 들어오지 않았을 때 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(strings = { "" , "100p", "!!", "!@#","a","abcd"})
    void validateIntTest(String str) {
        assertThatThrownBy(() -> validator.validateInt(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격이 1000원 단위가 아니면 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(ints = { 0,1,999,123})
    void validatePriceTest(int price) {
        assertThatThrownBy(() -> validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 패턴으로 입력되지 않으면 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(strings = { "1,2,3,4,5,6,7","1, 2, 3, 4, 5, 6","1,2,3,4,5"," 1,2,3,4,5,6"})
    void validateLottoNumbersTest(String str) {
        assertThatThrownBy(() -> validator.validateLottoNumbers(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> validator.validateDifferentLottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45를 초과하는 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> validator.validateRangeLottoNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1미만인 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> validator.validateRangeLottoNumbers(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}