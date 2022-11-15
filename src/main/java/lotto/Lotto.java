package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

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
    public List<Integer>[] drawLottoNumbers(int lottoCount) {
        List<Integer>[] lottoNumbers = new ArrayList[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers[i] = new ArrayList<>();
            lottoNumbers[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers[i]);
        }
        return lottoNumbers;
    }

    public void compareLotto(List<Integer> numbers, List<Integer>[] lottoNumbers, int bonusNumber) {
        int count;
        boolean bonus;
        List<Integer> countWinning = List.of(0, 0, 0, 0, 0);

        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                count = compareNumbers(numbers.get(j), lottoNumbers[i]);
                bonus = compareBonusNumber(lottoNumbers[i], bonusNumber);
                getRanking(countWinning, count, bonus);
            }
        }
    }
    public int compareNumbers(int numbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (numbers == lottoNumbers.get(i)) {
                count++;
            }
        }
        return count;
    }
    public boolean compareBonusNumber(List<Integer> lottoNumbers, int bonus) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (bonus == lottoNumbers.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void getRanking(List<Integer> countWinning, int count, boolean bonus) {
        int rankingCount;
        if (count == 6) {
            rankingCount = countWinning.get(4) + 1;
            countWinning.set(4, rankingCount);
            return;
        }
        if (count == 5) {
            if (bonus) {
                rankingCount = countWinning.get(3) + 1;
                countWinning.set(3, rankingCount);
                return;
            }
            rankingCount = countWinning.get(2) + 1;
            countWinning.set(2, rankingCount);
            return;
        }
        if (count == 4) {
            rankingCount = countWinning.get(1) + 1;
            countWinning.set(1, rankingCount);
            return;
        }
        if (count == 3) {
            rankingCount = countWinning.get(0) + 1;
            countWinning.set(0, rankingCount);
            return;
        }
        return;
    }
}