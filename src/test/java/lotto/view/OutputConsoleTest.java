package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.WinningHistory;
import lotto.domain.vo.LottoTicketResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputConsoleTest extends NsTest {

    OutputConsole outputConsole;

    public OutputConsoleTest() {
        this.outputConsole = new OutputConsole();
    }

    @Test
    @DisplayName("구매 했을 때 로또 몇개를 구매했는지 출력되어야 한다.")
    void purchaseLottoPrintCount() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));

        // when
        outputConsole.checkPurchaseLotto(lottos);

        // then
        assertThat(output()).contains("5개를 구매했습니다.");
    }

    @Test
    @DisplayName("로또 History를 주면 결과를 출력 해야 한다.")
    void giveLottoHistoryPrintResult() {
        // given
        List<LottoTicketResult> results = new ArrayList<>();
        results.add(new LottoTicketResult(6, false));
        WinningHistory winningHistory = new WinningHistory(results);

        // when
        outputConsole.showWinningStatistics(winningHistory);

        // then
        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 200,000,000.0%입니다."
        );
    }

    @Override
    protected void runMain() {

    }
}