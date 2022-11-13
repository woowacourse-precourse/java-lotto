package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Integer> WINNING_NUMBERS;
    private final int BONUS_NUMBER;

    private List<Lotto> lottos = new ArrayList<>();
    private Map<Prize, Integer> result = new HashMap<>();

    LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.WINNING_NUMBERS = winningNumbers;
        this.BONUS_NUMBER = bonusNumber;
        initResult();
    }

    private void initResult() {
        this.result.put(Prize.FIRST, 0);
        this.result.put(Prize.SECOND, 0);
        this.result.put(Prize.THIRD, 0);
        this.result.put(Prize.FOURTH, 0);
        this.result.put(Prize.FIFTH, 0);
        this.result.put(Prize.NONE, 0);
    }

    Map<Prize, Integer> showResult() {
        return new HashMap<>(result);
    }

    void insertLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    void saveAllResult() {
        for (Lotto lotto : lottos) {
            int matches = howManyMatches(lotto);
            boolean isContainBonus = false;
            if (matches == 5) {
                isContainBonus = checkBonusNumber(lotto);
            }
            Prize prize = getPrize(matches, isContainBonus);
            this.result.put(prize, this.result.get(prize) + 1);
        }
    }

    int howManyMatches(Lotto lotto) {
        int matches = 0;
        for (Integer number : lotto.showNumbers()) {
            if (this.WINNING_NUMBERS.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    boolean checkBonusNumber(Lotto lotto) {
        return lotto.showNumbers().contains(BONUS_NUMBER);
    }

    Prize getPrize(int matches, boolean isContainBonus) {
        if (matches == 6) {
            return Prize.FIRST;
        }
        if (isContainBonus) {
            return Prize.SECOND;
        }
        if (matches == 5) {
            return Prize.THIRD;
        }
        if (matches == 4) {
            return Prize.FOURTH;
        }
        if (matches == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    void printEachPrizeWinCount(){
        printPrizeWinCount(Prize.FIRST);
        printPrizeWinCount(Prize.SECOND);
        printPrizeWinCount(Prize.THIRD);
        printPrizeWinCount(Prize.FOURTH);
        printPrizeWinCount(Prize.FIFTH);
    }

    void printPrizeWinCount(Prize prize){
        System.out.println(Prize.prizeInfo(prize) + " - " + result.get(prize));
    }
}
