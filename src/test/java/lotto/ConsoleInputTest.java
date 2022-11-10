package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleInputTest {
    @Test
    void 구매금액_예외처리_테스트(){
        assertThat(
                ConsoleInput.validatePurchaseInputForTest("12000")
        ).isEqualTo(true);

        assertThat(
                ConsoleInput.validatePurchaseInputForTest("200")
        ).isEqualTo(false);

        assertThat(
                ConsoleInput.validatePurchaseInputForTest("0")
        ).isEqualTo(false);

        assertThat(
                ConsoleInput.validatePurchaseInputForTest("101000")
        ).isEqualTo(false);

    }
}
