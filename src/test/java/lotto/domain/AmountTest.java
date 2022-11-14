package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 예외를 던지는지 테스트한다")
    @Test
    void validateCanDivideIntoOneThousand() {
        //given
        int value = 1200;
        //when
        //then
        assertThatThrownBy(() -> {
            new Amount(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액을 로또 금액으로 나누었을때 로또 수량이 잘 반환되는지 테스트")
    @Test
    void calculateLottoCount() {
        //given
        Amount amount = new Amount(3000);
        //when
        int lottoCount = amount.calculateLottoCount();
        //then
        assertThat(lottoCount).isEqualTo(3);
    }
}