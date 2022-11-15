package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.InputViewConsole;
import lotto.view.OutputView;
import lotto.view.OutputViewConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTest extends NsTest {
    @BeforeEach
    void clearRank(){
        Rank.clearCount();
    }

    @DisplayName("멤버로 갖는 로또들의 당첨결과를 계산하는 메소드 출력")
    @Test
    void calculateRankWithWinningNumbers() {
        //given
        OutputView ov = new OutputViewConsole();
        Lottery lottery = Lottery.buy(new PurchaseAmount(10000));
        WinningNumbers winningNumbers = new WinningNumbers(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        lottery.calculateRankWithWinningNumbers(winningNumbers);

        //then
        ov.printWinningHistory();
        ov.printProfitRatio(10000);
    }

    @DisplayName("멤버로 갖는 로또들의 당첨결과를 계산하는 메소드 Assertions")
    @Test
    void assertCalculateRankWithWinningNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("assertCalculateRankWithWinningNumbers 메소드에서만 사용")
    @Override
    protected void runMain() {
        InputView iv = new InputViewConsole();
        OutputView ov = new OutputViewConsole();
        PurchaseAmount purchaseAmount = new PurchaseAmount(iv.askPurchaseAmount());
        Lottery lottery = Lottery.buy(purchaseAmount);
        WinningNumbers winningNumbers = new WinningNumbers(iv.askWinningNumbers(), iv.askBonusNumber());

        lottery.calculateRankWithWinningNumbers(winningNumbers);

        ov.printWinningHistory();
    }
}