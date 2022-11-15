package Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceExceptionTest {
    @DisplayName("구입금액에 문자가 입력되면 예외가 발생한다.")
    @Test
    void priceContainCharacterException() {
        Assertions.assertThatThrownBy(()
                -> PriceException.checkException("100k")).isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("구입금액이 1000원 단위로 입력 하지 않으면 예외가 발생한다.")
    @Test
    void priceNotUnitOf1000Exception() {
        Assertions.assertThatThrownBy(()
                -> PriceException.checkException("1500")).isInstanceOf(IllegalArgumentException.class);
    }

}