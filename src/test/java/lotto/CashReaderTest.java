package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import input.LottoMaker;

public class CashReaderTest {
    @DisplayName("로또 금액이 1000으로 나눠 떨어지지 않으면 예외가 발생한다.")
    @Test
    void insertMoneyThatIsNotDivisibleBy1000(){
        assertThatThrownBy(() -> new LottoMaker("1200"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
