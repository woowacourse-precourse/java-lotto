package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoShopTest {

    private final LottoShop lottoShop = new LottoShop();

    @Test
    public void 로또구매() {
        assertThatCode(() -> lottoShop.buy(50_000)).doesNotThrowAnyException();
    }

    @Test
    public void 로또구매_음수() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> lottoShop.buy(-50_000));
        assertThat(exception.getMessage()).contains("로또를 구매할 수 없습니다.");
    }

    @Test
    public void 로또구매_나누어떨어지지않음() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> lottoShop.buy(50_001));
        assertThat(exception.getMessage()).contains("나누어떨어지지");
    }
}