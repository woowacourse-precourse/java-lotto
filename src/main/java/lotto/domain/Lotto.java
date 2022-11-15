package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    static final String LOTTO_NUMBERS_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호 개수가 6개가 아닙니다.";
    static final String LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 있습니다.";
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbersCount(numbers);
        checkLottoNumbersDuplicate(numbers);

        this.numbers = numbers;
    }

    private void checkLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_ERROR_MESSAGE);
        }
    }

    public void checkLottoNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> pickLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBERS_COUNT);

        List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);

        List<Integer> sortedNumbers = new ArrayList<>(unmodifiableNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}