package lotto;

import lotto.constant.Rank;
import lotto.view.LottoView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.Rank.*;

public class Win {
    private static final String UNIT = "개";
    private static final String SEPARATOR = "---";
    private static final String WINNING_STATS_WORD = "당첨 통계";
    private static final String BLANK_LINE = "\n";


    private Map<Rank, Integer> ranking;
    private LottoView view;

    public Win(Map<Rank, Integer> ranking, LottoView view) {
        this.ranking = ranking;
        this.view = view;
    }

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

        return new Win(ranking, new LottoView());
    }

    private static void init(Map<Rank, Integer> ranking) {
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    public void printWinningStats() {
        StringBuilder context = new StringBuilder();

        view.printBlankLine();
        view.printMessage(WINNING_STATS_WORD);
        view.printMessage(SEPARATOR);

        for (Rank rank : ranking.keySet()) {
            if (rank == ETC) {
                continue;
            }

            context.append(rank.getWinningStats()).
                    append(ranking.get(rank)).append(UNIT).append(BLANK_LINE);
        }

        view.printMessage(context.toString());
    }

    public double getWinnings() {
        double total = 0;

        for (Rank rank : Rank.values()) {
            total += rank.getWinnings() * ranking.get(rank);
        }

        return total;
    }
}
