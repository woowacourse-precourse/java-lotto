package lotto.domain;

import java.util.List;

public class Report {
    public static Integer[] winningCount = {0, 0, 0, 0, 0, 0};
    private Rank rank;

    public Report(Rank rank) {
        this.rank = rank;
    }

    public static int totalPrize(List<Lotto> allLotto) {
        Compare compare = new Compare();
        int totalPrize = 0;
        for (int i = 0; i < allLotto.size(); i++) {
            List<Integer> lotto = allLotto.get(i).getNumbers();
            int matchNumber = compare.matchCount(lotto, Winning.numbers);
            boolean matchBonus = compare.matchBonus(lotto, Winning.numbers);

            Rank rank = Rank.valueOf(matchNumber, matchBonus);

            Report report = new Report(rank);
            report.winningCount(matchNumber, matchBonus);

            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    public static double returnRate(int inputMoney, int totalPrize) {
        double returnRate = totalPrize / (double) inputMoney * 100;
        return ((double) Math.round(returnRate * 100) / 100);
    }

    public void winningCount(int matchNumber, boolean matchBonus) {
        if (rank != Rank.valueOf(matchNumber, matchBonus)) {
            return;
        }
        winningCount[rank.ordinal()]++;
    }
}