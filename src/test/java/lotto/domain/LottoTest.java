package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest extends NsTest {
    @DisplayName("입력한 값은 숫자여야만 한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "1234a"})
    void checkInputIsNumber(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(Validation.LOTTO_INPUT_MUST_NUMBER);
        });
    }

    @DisplayName("입력받은 값은 1000원 단위여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "9998", "1002"})
    void checkInputIsThousand(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(Validation.LOTTO_MUST_THOUSAND_PRICE);
        });
    }

    @DisplayName("입력받은 2자리수 이상의 금액은 맨 앞자리가 0이될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"01", "01000"})
    void checkFirstNumberIsNotZero(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(Validation.FIRST_NUMBER_IS_NOT_ZERO);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
