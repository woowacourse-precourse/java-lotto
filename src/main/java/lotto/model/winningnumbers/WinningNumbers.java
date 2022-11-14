package lotto.model.winningnumbers;

import lotto.model.lotto.Lotto;
import lotto.model.statistics.LottoResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);

        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchCount = 0;
        boolean doesBonusMatch = false;
        for(int lottoNumber: lottoNumbers) {
            if(lottoNumber == bonusNumber) {
                doesBonusMatch = true;
                continue;
            }
            if(numbers.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return getLottoResult(matchCount, doesBonusMatch);
    }

    private LottoResult getLottoResult(int matchCount, boolean doesBonusMatch) {
        if(matchCount == Lotto.LOTTO_NUMBER_LENGTH) {
            return LottoResult.FIRST;
        }
        if(matchCount == Lotto.LOTTO_NUMBER_LENGTH - 1) {
            if(doesBonusMatch) {
                return LottoResult.SECOND;
            }
            return LottoResult.THIRD;
        }
        if(matchCount == Lotto.LOTTO_NUMBER_LENGTH - 2) {
            return LottoResult.FOURTH;
        }
        if(matchCount == Lotto.LOTTO_NUMBER_LENGTH - 3) {
            return LottoResult.FIFTH;
        }
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
            if (!tmpSet.add(number)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameNumberOnList(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }
}
