package lotto;

import lotto.exception.LottoInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    @DisplayName("1000단위로 돈이 들어오지 않았을 때 예외를 처리한다.")
    void if_not_divide_1000() {
        try {
            new Money(1234);
        } catch (LottoInputException e) {
            assertThat(e.getMessage()).contains("[ERROR]");
        }
    }
}
