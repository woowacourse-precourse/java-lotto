package lotto;

import lotto.logic.CalcLotto;
import lotto.object.Lotto;
import lotto.object.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcLottoTest {
    @DisplayName("로또 번호들을 입력했을 때, 올바른 당첨 횟수를 구해야 한다.")
    @Test
    void calcWinningTimes() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));

        WinningNumbers winningNumbers =
                new WinningNumbers(List.of(2, 3, 4, 5, 6, 7), 1);

        CalcLotto.resetWinningHistory();
        CalcLotto.setWinningNumbers(winningNumbers);

        CalcLotto.calcWinningTimes(lottos);

        assertThat(CalcLotto.getHistory().getHistory().get(-1).getAmount()).isEqualTo(1);
    }
}
