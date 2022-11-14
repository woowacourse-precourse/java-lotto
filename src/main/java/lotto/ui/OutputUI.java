package lotto.ui;

import lotto.domain.lottoData.Lotto;
import lotto.domain.Rank;
import lotto.domain.lottoData.TotalWinnerLotto;

import java.util.List;
import java.util.Map;

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

    public void printWinnerResult(Map<Rank, Integer> winnerPerRank) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank == Rank.NONE) continue;
            System.out.println(String.format("%d개 일치%s - %d개",
                    rank.getNormalNumbers(),
                    rank.getRewardString(),
                    winnerPerRank.get(rank)));
        }
    }

    public void printReturnRate(double returnRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", returnRate));
    }

}
