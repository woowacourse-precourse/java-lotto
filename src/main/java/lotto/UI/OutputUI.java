package lotto.UI;

import lotto.Lotto;
import lotto.Rank;
import lotto.ResultLotto;

import java.util.List;

public class OutputUI {

    public OutputUI() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public void printWinnerResult(ResultLotto resultLotto) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            System.out.println(String.format("%d개 일치 (%s) - %d개",
                    rank.getHitCount(),
                    rank.getRewardString(),
                    resultLotto.getResultWithRank(rank.getRankInt())));

        }
    }

    public void printReturnReate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate +"%입니다.");
    }
}
