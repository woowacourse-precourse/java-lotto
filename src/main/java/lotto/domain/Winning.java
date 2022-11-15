package lotto.domain;

import java.util.List;

public class Winning {
    List<Integer> lottoNumbers;
    int bonus, rank;

    public Winning(List<Integer> lottoNumbers, int bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public int checkWinning(List<Integer> userNumbers) {
        if(lottoNumbers.containsAll(userNumbers)) {
            return rank = 1; // 6개 일치
        } else if(lottoNumbers.contains(userNumbers)) {
            rank = compareNumbers(userNumbers);

            if(rank > 2) {
                return rank;
            }
        }

        return 0;
    }

    private int compareNumbers(List<Integer> userNumbers) {
        int count = 0;

        for(int i = 0; i < 6; i++) {
            if(lottoNumbers.contains(userNumbers.get(i))) {
                count++;
            }
        }

        if(count == 5 && userNumbers.contains(bonus)) {
            return 2;
        }

        return count;
    }
}
