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
        validate(winningNumbers);

        bonusNumber = UI.enterBonusNumber();
        List<Integer> numbersWithBonusNumber = new ArrayList<>(winningNumbers);
        numbersWithBonusNumber.add(bonusNumber);

        validateDuplication(numbersWithBonusNumber);
        validateNumberRange(numbersWithBonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개입니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);

        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45 범위입니다.");
            }
        }
    }

    public void compareLotteries() {
        List<Lotto> lotteries = lottoBuyer.getLotteries();

        for (Lotto lotto : lotteries) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            boolean bonusNumberMatched = lottoNumbers.contains(bonusNumber);
            lottoNumbers.retainAll(winningNumbers);
            int matched = lottoNumbers.size();
            System.out.println(matched);

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
