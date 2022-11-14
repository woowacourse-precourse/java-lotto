package lotto;

import java.util.*;
import static Constant.GameMessage.*;

public class UserInterface {

    private HashMap<Rank, Integer> rankCount;

    void printEnterAmout() {
        System.out.println(ENTER_AMOUNT);
    }

    void printEnterWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER);
    }
    void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
    }

    void printWinningHistory(HashMap<Rank, Integer> rankCount) {
        System.out.println(WINNING_STATISTICS);
        this.rankCount = rankCount;
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.NONE)
                .map(this::printRank)
                .forEach(System.out::println);
    }

    private String printRank(Rank rank) {
        String result = "";

        result += rank.getMatchCount() + MATCHING;
        if (rank == Rank.SECOND) {
            result += BONUS_MATCHING;
        }
        result += " (" + rank.getDottedWinningAmount() + "원) - ";
        result += rankCount.get(rank) + "개";

        return result;
    }

    void printWinningRate(float winningRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", winningRate));
    }
}
