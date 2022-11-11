package lotto;

import java.util.*;

public class Print {

    private HashMap<Rank, Integer> rankCount;
    void printPurchasedLotto(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    void printWinningHistory(HashMap<Rank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        this.rankCount = rankCount;
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NONE)
                .map(this::printRank)
                .forEach(System.out::println);
    }

    private String printRank(Rank rank) {
        String result = "";

        result += rank.getMatchCount() + "개 일치";
        if (rank == Rank.SECOND) {
            result += ", 보너스 볼 일치";
        }
        result += " (" + rank.getDottedWinningAmount() + "원) - ";
        result += rankCount.get(rank) + "개";

        return result;
    }
    void printWinningRate(float winningRate) {

    }
}
