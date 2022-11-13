package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.ResultLotto;

import java.util.List;

public class OutputUI {

    public OutputUI() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public void printWinnerResult(ResultLotto resultLotto) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(String.format("%d개 일치%s - %d개",
                    rank.getHitCount(),
                    rank.getRewardString(),
                    resultLotto.getResultWithRank(rank.getRankInt())));

        }
    }

    public void printReturnRate(double returnRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", returnRate));
    }
}
