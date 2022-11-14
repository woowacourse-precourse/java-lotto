package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static int[] rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameCount(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
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
        if (matchCount == 5 && matchBonus) {
            return Rank.SECOND.getIndex();
        }
        return matchCount;
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
        rank = new int[8];
        for (List<Integer> lotto : playerLotto) {
            rankIndex = compareLotto(lotto, bonusNumber);
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

    private void checkSameCount(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 중복되는 값이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
