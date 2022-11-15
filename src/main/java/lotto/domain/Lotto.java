package lotto.domain;

import static lotto.exception.ExceptionCode.INVALID_LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> numbers;

    public static Lotto generateRandomLotto() {
        try {
            return new Lotto(getRandomLottoNumbers());
        } catch (IllegalArgumentException e) {
            return generateRandomLotto();
        }
    }

    private static List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumber.LOWER_BOUND,
                LottoNumber.UPPER_BOUND,
                Lotto.LOTTO_SIZE);
    }

    public Lotto(List<Integer> inputNumbers) {
        this.numbers = getValidLottoNumbers(inputNumbers);
    }

    private Set<LottoNumber> getValidLottoNumbers(List<Integer> inputNumbers) {
        validate(inputNumbers);
        Set<LottoNumber> uniqueLottoNumbers = getUniqueLottoNumbers(inputNumbers);
        validate(uniqueLottoNumbers);
        return uniqueLottoNumbers;
    }

    private Set<LottoNumber> getUniqueLottoNumbers(List<Integer> inputNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>();
        for (Integer inputNumber : inputNumbers) {
            uniqueLottoNumbers.add(new LottoNumber(inputNumber));
        }
        return uniqueLottoNumbers;
    }

    private void validate(Collection<?> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    public int countOfMatch(Lotto lotto) {
        int countOfMatch = 0;
        for (LottoNumber number : numbers) {
            countOfMatch += getMatchingCount(lotto, number);
        }
        return countOfMatch;
    }

    private int getMatchingCount(Lotto lotto, LottoNumber number) {
        if (lotto.isContains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean isContains(LottoNumber bonusNo) {
        return numbers.contains(bonusNo);
    }

    @Override
    public String toString() {
        TreeSet<LottoNumber> sortedLottoNumber = new TreeSet<>(numbers);
        return sortedLottoNumber.toString();
    }
}
