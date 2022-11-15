package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roulette {
    public Map<String, Integer> lottoStatus = new HashMap<>();
    List<Integer> winningNumber;
    int bonusNumber;

    public Roulette(List<Integer> numbers, int number) {
        this.winningNumber = numbers;
        this.bonusNumber = number;
    }

    public void setLottoStatus() {
        for (Rank rank : Rank.values()) {
            lottoStatus.put(rank.name(), 0);
        }
    }

    public int compareWithWinningNumber(List<Integer> myLotto) {
        int count = 0;
        for (int number : myLotto) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void countLotto(List<Integer> myLotto, int count) {
        String rank;
        if (count == 5) {
            rank = hasBonusNumber(myLotto);
        } else {
            rank = Rank.of(count);
        }
        lottoStatus.put(rank, lottoStatus.get(rank) + 1);
    }

    public String hasBonusNumber(List<Integer> myLotto) {
        if (myLotto.contains(bonusNumber)) {
            return Rank.SECOND.name();
        }
        return Rank.THIRD.name();
    }
}
