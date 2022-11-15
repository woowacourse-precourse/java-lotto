package lotto.domain;

import lotto.standard.Place;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {
    public static Map<Place, Integer> winningRanks = new HashMap<>();
    private Bonus bonus;
    private Lotto lotto;

    public Rank(List<Integer> numbers) {
        for (Place rank : Place.values()) {
            winningRanks.put(rank, 0);
        }
        this.lotto = new Lotto(numbers);
    }

    public void countWinningRanks(List<List<Integer>> userLottoTickets, int bonusNumber) {
        setBonus(bonusNumber);
        for (List<Integer> userLottoNumbers : userLottoTickets) {
            //5등의 일치 개수보다 적은 일치 개수는 넘어간다.
            if (lotto.checkNumbers(userLottoNumbers) < Place.FIFTH.getMatchingNumber()) {
                continue;
            }
            Place place = determine((lotto.checkNumbers(userLottoNumbers)),
                    bonus.checkNumber(userLottoNumbers));
            winningRanks.put(place, winningRanks.get(place) + 1);
        }
    }

    private Place determine(int matchingNumber, boolean checkBonus) {
        for (Place place : Place.values()) {
            if (matchingNumber == place.SECOND.getMatchingNumber() && checkBonus) {
                return place.SECOND;
            }
            if (matchingNumber == place.getMatchingNumber()) {
                return place;
            }
        }
        return null;
    }

    private void setBonus(int bonusNumber) {
        this.bonus = new Bonus(lotto.getNumbers(), bonusNumber);
    }
}