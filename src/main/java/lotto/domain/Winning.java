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
        }

        rank = compareNumbers(userNumbers);

        if(rank == 2) {
            return 2;
        } else if(rank == 5) {
            return 3;
        } else if(rank == 4) {
            return 4;
        } else if (rank == 3) {
            return 5;
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

        if(count < 3) {
            return 0;
        }

        return count;
    }
}
