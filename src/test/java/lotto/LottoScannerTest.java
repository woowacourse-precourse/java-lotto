package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoScannerTest extends NsTest {
    @DisplayName("1000원으로 나누어떨어지지 않으면 예외를 던져야한다.")
    @Test
    public void throwExceptionWhen1000DoesNotDivideMoney() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() ->
                    run("25200")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LottoScanner.SHOULD_BE_DIVIDED_BY_1000);
        });
    }

    @DisplayName("숫자가 아닌 경우 예외를 던져야한다.")
    @Test
    public void throwExceptionWhenInputIsNaN() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() ->
                    run("1234j")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LottoScanner.REQUIRE_NUMERIC_VALUE);
        });
    }

    @Override
    protected void runMain() {
        LottoScanner.readMoney();
    }
}
