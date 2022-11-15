package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String LOTTO_NUMBER_RANGE_MISMATCH_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_SIZE_MISMATCH_MESSAGE = "[ERROR] 로또 한 장의 번호 개수는 6개입니다.";
    public static final String LOTTO_IS_NOT_UNIQUE_MESSAGE ="[ERROR] 로또 번호에 중복이 존재할 수 없습니다.";
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersRange(numbers);
        validateLottoIsUnique(numbers);
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoIsUnique(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (lottoNumbers.contains(number)) {
                throw new IllegalArgumentException(LOTTO_IS_NOT_UNIQUE_MESSAGE);
            }
            lottoNumbers.add(number);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_MISMATCH_MESSAGE);
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    protected void validateLottoNumberRange(int number) {
        if (isNotInLottoNumberRange(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_MISMATCH_MESSAGE);
        }
    }

    private boolean isNotInLottoNumberRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }

    public int match(WinningLotto winningLotto) {
        int matchCount = 0;
        for (int number : winningLotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchCount = matchCount + 1;
            }
        }
        return matchCount;
    }

    public boolean matchBonus(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}