package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculatorTest {

    private Calculator calculator;
    private Lotto wonLotto;
    private int bonusNumber;
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        wonLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        userLottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        calculator = new Calculator(wonLotto, bonusNumber, userLottos);
    }


    @Test
    @DisplayName("로또 순위 개수 계산 테스트")
    void countLottoRanksTest() {
        Assertions.assertThat(calculator.countLottoRanks(userLottos)).isEqualTo(List.of(7, 0, 0, 0, 0, 1));
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void calculateEarningRateTest() {
        // given
        calculator.countLottoRanks(userLottos);

        // then
        Assertions.assertThat(calculator.calculateEarningRate()).isEqualTo(62.5);
    }
}