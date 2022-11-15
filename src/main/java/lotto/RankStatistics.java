package lotto;

import java.util.HashMap;
import java.util.Map;

public class RankStatistics {
    private final Map<Rank, Integer> map = new HashMap<>();
    private long prize = 0;
    private long userInput = 0;

    public RankStatistics() {
        map.put(Rank.FIRST, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.FIFTH, 0);
        map.put(Rank.NONE, 0);
    }

    public void addRankData(Rank rank) {
        if (map.containsKey(rank)) {
            int value = map.get(rank) + 1;
            map.put(rank, value);
            prize += rank.getPrize();
            return;
        }
        map.put(rank, 0);
        prize += rank.getPrize();
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public void printStatistics() {
        System.out.printf("%d개 일치 (5,000원) - %d개\n", Rank.FIFTH.getMatch(), map.get(Rank.FIFTH));
        System.out.printf("%d개 일치 (50,000원) - %d개\n", Rank.FOURTH.getMatch(), map.get(Rank.FOURTH));
        System.out.printf("%d개 일치 (1,500,000원) - %d개\n", Rank.THIRD.getMatch(), map.get(Rank.THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", Rank.SECOND.getMatch(), map.get(Rank.SECOND));
        System.out.printf("%d개 일치 (2,000,000,000원) - %d개\n", Rank.FIRST.getMatch(), map.get(Rank.FIRST));
        System.out.printf("총 수익률은 %s%%입니다.", String.format("%.1f",prize*100/(double)userInput));
    }
}
