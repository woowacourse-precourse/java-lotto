package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoDraw {
    private static final int BONUS_NUMBER_MATCHED = 100;

    private final LottoBuyer lottoBuyer;
    private int totalPrizeMoney;
    private Map<Integer, Integer> numberOfMatching = new HashMap<>();
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoDraw(LottoBuyer lottoBuyer) {
        this.lottoBuyer = lottoBuyer;

        this.totalPrizeMoney = 0;
        for (int matched = 3; matched <= 6; matched++) {
            numberOfMatching.put(matched , 0);
        }
        numberOfMatching.put(BONUS_NUMBER_MATCHED, 0);

        winningNumbers = UI.enterWinningNumber();
        Validation.validate(winningNumbers);

        bonusNumber = UI.enterBonusNumber();
        List<Integer> numbersWithBonusNumber = new ArrayList<>(winningNumbers);
        numbersWithBonusNumber.add(bonusNumber);

        Validation.validateDuplication(numbersWithBonusNumber);
        Validation.validateNumberRange(numbersWithBonusNumber);
    }

    public void compareLotteries() {
        List<Lotto> lotteries = lottoBuyer.getLotteries();

        for (Lotto lotto : lotteries) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            boolean bonusNumberMatched = lottoNumbers.contains(bonusNumber);
            lottoNumbers.retainAll(winningNumbers);
            int matched = lottoNumbers.size();

            if (matched == 5 && bonusNumberMatched) {
                matched = BONUS_NUMBER_MATCHED;
            }

            if (matched >= 3) {
                numberOfMatching.put(matched, numberOfMatching.get(matched) + 1);
            }
        }
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public Map<Integer, Integer> getNumberOfMatching() {
        return numberOfMatching;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
