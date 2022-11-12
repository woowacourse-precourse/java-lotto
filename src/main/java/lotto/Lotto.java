package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.constant.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }

        Set<Integer> lottoSet = new HashSet<>(numbers);
        if (lottoSet.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
        return numbers;
    }

    public boolean isContained(int num) {
        return numbers.contains(num);
    }

    public void printSortedLottoNumber() {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            sortedNumbers.add(numbers.get(i));
        }
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
