package lotto.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumber;
import lotto.generator.RandomsNumberGenerator;
import lotto.result.RewardEnum;
import lotto.ui.Input.ConsoleParameterInput;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @Test
    void makeStatistics() {
        List<Lotto> lottoList = new ArrayList<>(
                List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        );
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoManager manager = new LottoManager(new RandomsNumberGenerator(), new ConsoleParameterInput());

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.WIN_6))
                .isEqualTo(1);

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.WIN_5_BONUS))
                .isEqualTo(1);

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.WIN_5))
                .isEqualTo(1);

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.WIN_4))
                .isEqualTo(1);

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.WIN_3))
                .isEqualTo(1);

        assertThat(manager.makeStatistics(lottoList, winningNumber)
                .get(RewardEnum.NONE))
                .isEqualTo(0);
    }
}