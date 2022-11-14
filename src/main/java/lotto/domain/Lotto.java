package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 개수는 중복이 불가능합니다.";
    private static final int LOTTO_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoDuplicate(numbers);

    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto (String input){
        String[] stringArr = input.split(DELIMITER);
        validateLottoNumbers(stringArr);
        this.numbers = convertStringArrToIntegerList(stringArr);
    }

    private void validateLottoNumbers(String[] stringArr) {
        validateLottoCount(stringArr);
        validateDuplicateCount(stringArr);
    }

    private void validateLottoCount(String[] array) {
        if (array.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 개수는 " + LOTTO_COUNT + "개로 제한됩니다."));
        }
    }

    private void validateDuplicateCount(String[] arr) {
        int distinctCount = calDistinctCountFromArray(arr);

        if (arr.length != distinctCount) {
            throw new IllegalArgumentException(String.format(DUPLICATE_ERROR));
        }
    }

    private int calDistinctCountFromArray(String[] arr) {
        return (int) Arrays.stream(arr)
                .distinct()
                .count();
    }

    private List<Integer> convertStringArrToIntegerList(String[] array) {
        return Arrays.stream(array)
                .map(Integer::parseInt)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto of() {
        List<Integer> randomLottoNumbers = generateRandomLottoNumbers();
        return new Lotto(randomLottoNumbers);
    }

    private static List<Integer> generateRandomLottoNumbers() {
        List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
        return randomLottoNumbers;
    }

    public boolean contains(int otherLottoNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(otherLottoNumber));
    }

    public int calculateSameCount(Lotto otherLottoNumbers) {
        return otherLottoNumbers.compareLottoNumbers(numbers);
    }

    private int compareLottoNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }
}
