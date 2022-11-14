package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static List<Integer> winNumbers;
    private static Integer bonusNumber;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        Validator.lottoNumber(numbers);
        Collections.sort(sorted);
        this.numbers = sorted;
    }

    public Lotto(List<Integer> winNumbers, Integer bonusNumber) {
        Lotto.winNumbers =  winNumbers;

        Validator.bonusNumber(bonusNumber);
        Lotto.bonusNumber = bonusNumber;

        this.numbers = null;
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.SIZE);
    }

    public static Boolean isContainedWinNumber(Integer bonusNumber) {
        return Lotto.winNumbers.contains(bonusNumber);
    }

    public void printLotto() {
        System.out.println(this.numbers);
    }

    public Integer matchWinNumbers() {
        Integer match = 0;
        for (Integer number : this.numbers) {
            if (winNumbers.contains(number)) {
                match += 1;
            }
        }
        return match;
    }

    public Boolean matchBonusNumber() {
        return this.numbers.contains(Lotto.bonusNumber);
    }
}
