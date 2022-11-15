package lotto.view;

import lotto.constant.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {
    @DisplayName("구매한 로또 티켓 수량과 각 티켓의 번호를 오름차순으로 출력한다.")
    @Test
    void showPurchaseListByAscendingOrder() {
        int purchaseCount = 2;
        List<List<Integer>> tickets = List.of (
                List.of(2, 4, 1, 9, 10, 34),
                List.of(11, 29, 41, 32, 7, 14)
        );

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView.showPurchaseList(tickets);
        assertThat(out.toString())
                .contains("2개를 구매했습니다.")
                .contains("[1, 2, 4, 9, 10, 34]")
                .contains("[7, 11, 14, 29, 32, 41]");
    }

    @DisplayName("당첨 정보를 주어진 형식에 맞게 출력한다.")
    @Test
    void showWinningResult() {
        Map<LotteryRank, Integer> winningCountByRank = new HashMap<>();
        winningCountByRank.put(LotteryRank.FIRST, 0);
        winningCountByRank.put(LotteryRank.SECOND, 0);
        winningCountByRank.put(LotteryRank.THIRD, 0);
        winningCountByRank.put(LotteryRank.FOURTH, 1);
        winningCountByRank.put(LotteryRank.FIFTH, 3);
        int numberOfAllTickets = 20;
        long totalReward = 65_000;

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView.showWinningResult(winningCountByRank, numberOfAllTickets, totalReward);
        assertThat(out.toString()).contains(
                "당첨 통계",
                "3개 일치 (5,000원) - 3개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 325.0%입니다."
        );
    }
}
