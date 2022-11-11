package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }

        Set<Integer> lottoSet = new HashSet<>(numbers);
        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> createLottoNumber() {
        //TODO : 정렬기능 필요
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }

    public boolean isContained(int num) {
        return  numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
