package lotto.domain;

import lotto.entity.Place;

import java.util.*;

public class Rank {
    public Map<Place, Integer> winningRanks = new HashMap<>();
    private Bonus bonus;
    Lotto lotto;

    public Rank(List<Integer> numbers) {
        for (Place rank : Place.values()) {
            winningRanks.put(rank, 0);
        }
        this.lotto = new Lotto(numbers);
    }

    public void countWinningRanks(List<List<Integer>> userLottoTickets, int bonusNumber) {
        setBonus(bonusNumber);
        for (List<Integer> userLottoNumbers : userLottoTickets) {
            if (lotto.checkNumbers(userLottoNumbers) < 3) {
                continue;
            }
            Place place = determine((lotto.checkNumbers(userLottoNumbers)), bonus.checkNumber(userLottoNumbers));
            winningRanks.put(place, winningRanks.get(place)+1);
        }
    }

    //15줄 넘음
    private Place determine(int matchingNumber, boolean checkBonus) {
        if (matchingNumber == Place.FIRST.getMatchingNumber()) {
            return Place.FIRST;
        }
        if (matchingNumber == Place.SECOND.getMatchingNumber() && checkBonus) {
            return Place.SECOND;
        }
        if (matchingNumber == Place.THIRD.getMatchingNumber() && !checkBonus) {
            return Place.THIRD;
        }
        if (matchingNumber == Place.FOURTH.getMatchingNumber()) {
            return Place.FOURTH;
        }
        if (matchingNumber == Place.FIFTH.getMatchingNumber()) {
            return Place.FIFTH;
        }
        return null;
    }

    private void setBonus(int bonusNumber) {
        this.bonus = new Bonus(lotto.getNumbers(), bonusNumber);
    }
}
