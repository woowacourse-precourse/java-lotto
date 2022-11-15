package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.strategy.FixedLottoGenerateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @DisplayName("로또 목록 중 당첨 번호와 겹치는 수 6개 있는 로또 두 개 발견")
    @Test
    void contains3NumberEach2Lotto() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(2, new FixedLottoGenerateStrategy());
        Map<Prize, Integer> prizeBoard = LottoMachine.checkPrizes(winningNum, lottos,
            new Bonus(7, winningNum));
        Assertions.assertThat(prizeBoard.get(Prize.ALL)).isEqualTo(2);
    }
}
