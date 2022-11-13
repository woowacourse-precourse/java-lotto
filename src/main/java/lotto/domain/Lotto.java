package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static int[] rank = {0, 0, 0, 0, 0};

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private int compareLotto(List<Integer> playerLotto, int bonusNumber) {
        int matchCount = 0;
        boolean matchBonus = numbers.contains(bonusNumber);
        for (Integer lotto : playerLotto) {
            if (numbers.contains(lotto)) {
                matchCount++;
            }
        }
        if (matchCount == 5 && !matchBonus) {
            return 4;
        }
        return 6 - matchCount;
    }

    public int getPrizeMoney(List<List<Integer>> playerLotto, int bonusNumber) {
        makeRank(playerLotto, bonusNumber);
        int prizeMoney = 0;
        for (Rank value : Rank.values()) {
            prizeMoney += rank[value.getIndex()] * value.getWinningsPrice();
        }
        return prizeMoney;
    }

    private void makeRank(List<List<Integer>> playerLotto, int bonusNumber) {
        int rankIndex;
        for (List<Integer> lotto : playerLotto) {
            rankIndex = compareLotto(lotto, bonusNumber);
            if (rankIndex > 4) {
                continue;
            }
            rank[rankIndex]++;
        }
    }

    public void showWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank value : Rank.values()) {
            System.out.println(value.getText() + rank[value.getIndex()] + "개");
        }
    }
}
