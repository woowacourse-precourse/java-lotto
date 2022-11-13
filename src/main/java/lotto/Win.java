package lotto;

import lotto.constant.Rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.Rank.*;

public class Win {
    private Map<Rank, Integer> ranking;

    public Win(Map<Rank, Integer> ranking) {
        this.ranking = ranking;
    }

    public static Win compare(Ticket ticket, List<Integer> winningNumbers, int bonusNumber) {
        int count = ticket.size();
        Map<Rank, Integer> ranking = new LinkedHashMap<>();
        Comparison comparison = new Comparison();

        init(ranking);

        for (int i = 0; i < count; i++) {
            Lotto lotto = ticket.get(i);
            int win = comparison.countWinningNumbers(lotto, winningNumbers);
            int bonus = comparison.countBonusNumber(lotto, bonusNumber);

            Rank rank = findByWinAndBonus(win, bonus);

            if (rank == ETC) {
                continue;
            }

            ranking.put(rank, ranking.get(rank) + 1);
        }

        return new Win(ranking);
    }

    private static void init(Map<Rank, Integer> ranking) {
        for (Rank rank : values()) {
            ranking.put(rank, 0);
        }
    }

    // TODO 당첨 내역 출력

    // TODO 총 당첨금액 반환
}
