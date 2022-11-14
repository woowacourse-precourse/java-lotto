package lotto.domain;

public class Report {
    private Rank rank;
    public static Integer[] winningCount = {0, 0, 0, 0, 0, 0};

    public Report(Rank rank){
        this.rank = rank;
    }

    public void winningCount(int matchNumber, boolean matchBonus) {
        if (rank != Rank.valueOf(matchNumber, matchBonus)) {
            return;
        }
        winningCount[rank.ordinal()]++;
    }
}