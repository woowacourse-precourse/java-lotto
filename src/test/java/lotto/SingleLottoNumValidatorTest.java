package lotto;

import lotto.model.MoneyParser;
import lotto.model.SingleLottoNumValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SingleLottoNumValidatorTest {
    private SingleLottoNumValidator singleLottoNumValidator;

    @BeforeEach
    void setUp() {
        singleLottoNumValidator = new SingleLottoNumValidator();
    }

    @DisplayName("1 미만이면 예외가 발생한다.")
    @Test
    void validateUnder1() {
        assertThatThrownBy(() -> singleLottoNumValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과면 예외가 발생한다.")
    @Test
    void validateOver45() {
        assertThatThrownBy(() -> singleLottoNumValidator.validate("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 ~ 9 이외의 문자 (한글, 알파벳, 특수기호 등) 포함 시 예외가 발생한다.")
    @Test
    void inputWithOtherChar() {
        assertThatThrownBy(() -> new MoneyParser().parse("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 자리수 이상인데 0으로 시작하면 예외가 발생한다.")
    @Test
    void inputStartWithZero() {
        assertThatThrownBy(() -> new MoneyParser().parse("09"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}