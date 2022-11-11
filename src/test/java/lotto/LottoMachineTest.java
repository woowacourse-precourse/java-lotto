package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("로또 구입금액이 1000원 미만일 경우 예외가 발생한다.")
    @Test
    void createLessThanMinMoney() {
        assertThatThrownBy(() -> lottoMachine.inputMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createWrongMoneyUnit() {
        assertThatThrownBy(() -> lottoMachine.inputMoney(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액에 맞춰 여러개의 로또가 발행된다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "5000, 5", "10000, 10"})
    void publishLotto(int money, int expected) {
        lottoMachine.inputMoney(money);
        List<Lotto> publishedLotto = lottoMachine.publishLotto();
        assertThat(publishedLotto).hasSize(expected);
    }

    @DisplayName("입력된 당첨 번호를 가지고 당첨 로또가 발행된다.")
    @Test
    void publishWinningLotto() {
        Lotto lotto = lottoMachine.publishWinningLotto("1,2,3,4,5,6");
        boolean result = lotto.equals(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(result).isTrue();
    }
}