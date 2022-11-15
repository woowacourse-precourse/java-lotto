package lotto;

import lotto.domain.RandomLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomLottoTest {

    @Test
    @DisplayName("한 개 미만의 로또가 생성되면 예외가 발생")
    void createMoneyByOutArrange() {
        assertThatThrownBy(() -> new RandomLotto(of(), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한 개 미만의 로또가 생성되면 예외가 발생")
    void createMoneyByNotExistLotto() {
        assertThatThrownBy(() -> new RandomLotto(of(of(), of()), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성된 로또의 수가 구매한 로또의 수와 일치하지 않으면 예외 발생")
    void createMoneyByNotSameLottosAndBoughtLottos() {
        assertThatThrownBy(() -> new RandomLotto(
                of(of(1,2,3,4,5,6), of(2,3,4,5,6,7), of(3,4,5,6,6,7,8))
                , 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}