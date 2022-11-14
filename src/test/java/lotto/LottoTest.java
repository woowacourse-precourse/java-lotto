package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoNumberException;
import lotto.exception.MoneyNotDividedByPriceException;
import lotto.exception.MoneyRangeException;
import lotto.exception.WrongLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개 이하이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(WrongLengthException.class);
    }

    @DisplayName("로또 번호가 1이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoNumberException.class);
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDividedByPrice() {
        assertThatThrownBy(() -> new Money(1400))
                .isInstanceOf(MoneyNotDividedByPriceException.class);
    }

    @DisplayName("구입 금액이 로또 1장 가격보다 작으면 예외가 발생한다.")
    @Test
    void moneyUnderLottoPrice() {
        assertThatThrownBy(() -> new Money(800))
                .isInstanceOf(MoneyRangeException.class);
    }
}
