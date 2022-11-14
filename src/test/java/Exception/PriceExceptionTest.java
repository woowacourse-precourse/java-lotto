package Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceExceptionTest {
    @Test
    void priceContainCharacterException() {
        Assertions.assertThatThrownBy(()
                -> PriceException.checkException("100k")).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void priceNotUnitOf1000Exception() {
        Assertions.assertThatThrownBy(()
                -> PriceException.checkException("1500")).isInstanceOf(IllegalArgumentException.class);
    }

}