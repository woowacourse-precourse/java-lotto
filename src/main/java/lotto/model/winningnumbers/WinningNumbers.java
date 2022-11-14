package lotto.model.winningnumbers;

import lotto.model.lotto.Lotto;
import lotto.model.statistics.LottoResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);

        this.numbers = new ArrayList<>();
        for(int number: numbers) {
            this.numbers.add(number);
        }

        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLotto(Lotto lotto) {
        // TODO 구현 필요
        return LottoResult.MISS;
    }

    private static void validate(List<Integer> numbers, int bonusNumber) {
        if(doesNotHaveRightLength(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.LOTTO_NUMBER_LENGTH + "개여야 합니다.");
        }
        if(hasNumberOutOfRange(numbers) || isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.MINIMUM_NUMBER + "부터 " + Lotto.MAXIMUM_NUMBER + " 사이의 숫자여야 합니다.");
        }
        if(haveDuplicate(numbers) || isSameNumberOnList(bonusNumber, numbers)) {
            throw new IllegalArgumentException("로또 번호가 중복되어서는 안 됩니다.");
        }
    }

    private static boolean doesNotHaveRightLength(List<Integer> numbers) {
        return numbers.size() != Lotto.LOTTO_NUMBER_LENGTH;
    }

    private static boolean isOutOfRange(int number) {
        return number < Lotto.MINIMUM_NUMBER || number > Lotto.MAXIMUM_NUMBER;
    }

    private static boolean hasNumberOutOfRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(isOutOfRange(number)) {
                return true;
            }
        }
        return false;
    }

    private static boolean haveDuplicate(List<Integer> numbers) {
        Set<Integer> tmpSet = new HashSet<>();

        for (int number : numbers) {
            if (tmpSet.add(number) == false) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameNumberOnList(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }
}
