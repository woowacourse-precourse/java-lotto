package lotto;

import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {


    @DisplayName("1000원단위의 돈이 아니면 예외처리")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Money(12500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원에 로또 한장")
    @Test
    void lottoCountTest() {
        Money money = new Money(5000);

        assertThat(money.lottoCount()).isEqualTo(5);
    }
}
