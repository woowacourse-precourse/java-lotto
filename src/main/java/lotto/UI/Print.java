package lotto.UI;

import lotto.domain.Rank;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class Print {

    static final String ERROR_PREFIX = "[ERROR] ";
    public void infoLottos(List<Lotto> lottos){
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

    public void infoRank(Map<Rank, Integer> totalRank){
        System.out.println("당첨 통계");
        System.out.println("---");
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks){
            System.out.println(String.format("%s%d개", rank.getResultText(), totalRank.get(rank)));
        }
    }

    public void infoProfit(double profit){
        System.out.println(String.format("총 수익률은 %.1f%%입니다", profit));
    }

    public void infoError(String message){
        System.out.println(ERROR_PREFIX + message);
    }
}
