package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 숫자가_아닌_입력_체크(){
        assertThatThrownBy(() -> new Money("ㅁㄴㅇ"))
                .isInstanceOf(NoSuchElementException.class);
    }
    @Test
    void 나누어_지지_않는_금액_체크(){
        assertThatThrownBy(() -> new Money("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_음수_체크(){
        assertThatThrownBy(() -> new Money("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}