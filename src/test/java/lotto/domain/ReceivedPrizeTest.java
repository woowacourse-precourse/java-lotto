package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lottoenum.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReceivedPrizeTest {
    private ReceivedPrize receivedPrize;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 7);

        receivedPrize = new ReceivedPrize(lottos, winningLotto);
    }

    @DisplayName("로또 당첨 결과에 따른 수익률 계산을 테스트한다")
    @Test
    void calculateRateOfReturnTest() {
        int money = 8000;
        long prizeMoneySum = Prize.FIFTH.getMoney();
        double result = (double) prizeMoneySum / money * 100;

        assertThat(receivedPrize.calculateRateOfReturn(money)).isEqualTo(result);
    }

}
