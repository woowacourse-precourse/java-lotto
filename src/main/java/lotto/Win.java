package lotto;

import lotto.constant.Rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Win {
    private Map<Rank, Integer> ranking;

    public Win(Map<Rank, Integer> ranking) {
        this.ranking = ranking;
    }

    public static Win compare(Ticket ticket, List<Integer> winningNumbers, int bonusNumber) {
        int win;
        int bonus;
        Map<Rank, Integer> ranking = new LinkedHashMap<>();
        Comparison comparison = new Comparison();

        init(ranking);

        int count = ticket.size();
        for (int i = 0; i < count; i++) {
            Lotto lotto = ticket.get(i);
            win = comparison.countWinningNumbers(lotto, winningNumbers);
            bonus = comparison.countBonusNumber(lotto, bonusNumber);


            Rank rank = Rank.findByWinAndBonus(win, bonus);

            if (rank == Rank.ETC) {
                continue;
            }

            ranking.put(rank, ranking.get(rank) + 1);
        }

        return new Win(ranking);
    }

    private static void init(Map<Rank, Integer> ranking) {
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    // TODO 당첨 내역 출력

    // TODO 총 당첨금액 반환
}
