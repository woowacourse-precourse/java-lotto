package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoPriceExceptionTest {

    @Test
    void 로또금액_숫자인지_확인() {
        assertThatThrownBy(() -> LottoPriceException.changePriceToInteger("가나다"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.changePriceToInteger("test"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.changePriceToInteger("1000가"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.changePriceToInteger("test1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또금액_천_이하_확인() {
        assertThatThrownBy(() -> LottoPriceException.checkLessThanOneThousand(900))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.checkLessThanOneThousand(10))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.checkLessThanOneThousand(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또금액_천단위_확인() {
        assertThatThrownBy(() -> LottoPriceException.checkThousandUnits(1001))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.checkThousandUnits(101010))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoPriceException.checkThousandUnits(2220))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
