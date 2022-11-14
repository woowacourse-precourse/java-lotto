package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 구매 금액은 양수이여야한다.")
    @Test
    void checkLottoMoney(){
        assertThatThrownBy(() -> new LottoMoney(-100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액은 1000원 단위이여야한다.")
    @Test
    void checkLottoMoneyUnit(){
        assertThatThrownBy(() -> new LottoMoney(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위면 정상 실행된다.")
    @Test
    void correctLottoMoney(){
        assertThatNoException().isThrownBy(() -> new LottoMoney(100000));
    }
}