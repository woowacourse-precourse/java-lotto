package lotto.domain;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoComparator {
    final int CHECK_BONUS = 5;
    public Map<String, Integer> lottoStatus = new HashMap<>();
    List<Integer> winningNumber;
    int bonusNumber;

    public LottoComparator(List<Integer> numbers, int number) {
        this.winningNumber = numbers;
        this.bonusNumber = number;
    }

    public void runComparator(List<Lotto> myLotto) {
        setLottoStatus();
        for (Lotto one : myLotto) {
            int sameNumber = compareWithWinningNumber(one.getNumbers());
            if (sameNumber < 3) {
                continue;
            }
            countLotto(one.getNumbers(), sameNumber);
        }
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
        String rank = setLottoRank(myLotto, count);
        lottoStatus.put(rank, lottoStatus.get(rank) + 1);
    }

    public String setLottoRank(List<Integer> myLotto, int count) {
        if (count == CHECK_BONUS) {
            return hasBonusNumber(myLotto);
        }
        return Rank.of(count);
    }

    public String hasBonusNumber(List<Integer> myLotto) {
        if (myLotto.contains(bonusNumber)) {
            return Rank.SECOND.name();
        }
        return Rank.THIRD.name();
    }
}
