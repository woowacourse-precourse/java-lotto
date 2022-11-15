package lotto.system;

import lotto.exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ParserTest {

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_구입_금액() {
        assertThatThrownBy(() ->
                new Parser().validatePurchaseAmount("숫자가아님")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 천원_단위가_아닌_구입_금액() {
        assertThatThrownBy(() ->
                new Parser().validatePurchaseAmount("123,455")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_구입_금액() {
        assertThat(new Parser().validatePurchaseAmount("13,000")).isEqualTo(13000);
    }
}
