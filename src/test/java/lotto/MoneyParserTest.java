package lotto;

import lotto.model.MoneyParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyParserTest {
    @DisplayName("구입금액에 0 ~ 9 이외의 문자 (한글, 알파벳, 특수기호 등) 포함 시 예외가 발생한다.")
    @Test
    void inputMoneyWithOtherChar() {
        assertThatThrownBy(() -> new MoneyParser().parse("abc123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0이면 예외가 발생한다.")
    @Test
    void inputMoneyisZero() {
        assertThatThrownBy(() -> new MoneyParser().parse("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 자리수 이상인데 구입금액이 0으로 시작하면 예외가 발생한다.")
    @Test
    void inputMoneyStartWithZero() {
        assertThatThrownBy(() -> new MoneyParser().parse("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void inputMoneyModPriceIsNotZero() {
        assertThatThrownBy(() -> new MoneyParser().parse("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
