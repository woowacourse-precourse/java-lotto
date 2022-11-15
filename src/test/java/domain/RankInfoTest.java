package domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Money.Money;
import domain.RankInfo.RankInfoController;
import domain.Bonus.Bonus;
import domain.Lotto.Lotto;
import domain.RankInfo.RankInfo;
import domain.UserLotto.UserLotto;
import org.junit.jupiter.api.Test;
import view.OutputMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankInfoTest extends NsTest {
    RankInfoController rankInfoController = new RankInfoController();
    OutputMessage outputMessage = new OutputMessage();

    @Test
    void 통계_테스트1() {
        Money money = new Money(5000);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        RankInfo rankInfo = rankInfoController.getRankInfo(
                rankInfoController.createRankInfo(),
                lotto,
                new UserLotto(List.of(
                        List.of(1,2,3,7,8,9), // 3개 일치
                        List.of(11,12,13,14,15,17),
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,43,25,22),
                        List.of(11,12,13,43,25,22))),
                new Bonus(7, lotto));
        outputMessage.printStatistic(rankInfo, rankInfoController.getYield(rankInfo, money));

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 100.0%입니다."
        );
    }

    @Test
    void 통계_테스트2() {
        Money money = new Money(5000);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        RankInfo rankInfo = rankInfoController.getRankInfo(
                rankInfoController.createRankInfo(),
                lotto,
                new UserLotto(List.of(
                        List.of(1,2,3,7,8,9), // 3개 일치
                        List.of(1,2,3,7,8,9), // 3개 일치
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,43,25,22),
                        List.of(11,12,13,43,25,22))),
                new Bonus(7, lotto));
        outputMessage.printStatistic(rankInfo, rankInfoController.getYield(rankInfo, money));

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 200.0%입니다."
        );
    }

    @Test
    void 통계_테스트3() {
        Money money = new Money(5000);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        RankInfo rankInfo = rankInfoController.getRankInfo(
                rankInfoController.createRankInfo(),
                lotto,
                new UserLotto(List.of(
                        List.of(1,2,3,4,5,9), // 5개 일치
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,43,25,22),
                        List.of(11,12,13,43,25,22))),
                new Bonus(7, lotto));
        outputMessage.printStatistic(rankInfo, rankInfoController.getYield(rankInfo, money));

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 30,000.0%입니다."
        );
    }

    @Test
    void 통계_테스트4() {
        Money money = new Money(5000);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        RankInfo rankInfo = rankInfoController.getRankInfo(
                rankInfoController.createRankInfo(),
                lotto,
                new UserLotto(List.of(
                        List.of(1,2,3,4,15,22), // 4개 일치
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,14,15,22),
                        List.of(11,12,13,43,25,22),
                        List.of(11,12,13,43,25,22))),
                new Bonus(7, lotto));
        outputMessage.printStatistic(rankInfo, rankInfoController.getYield(rankInfo, money));

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 1,000.0%입니다."
        );
    }
    @Override
    protected void runMain() { }
}
