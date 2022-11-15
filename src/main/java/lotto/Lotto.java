package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Money.BLANK;
import static lotto.LottoFactory.LOTTO_MAX_NUMBER;
import static lotto.LottoFactory.LOTTO_MIN_NUMBER;
import static lotto.WinningNumber.REPEAT_INITIAL_VALUE;

public class Lotto {

    private final static String SEPARATOR = ",";
    private static final int LOTTO_DEFAULT_LENGTH = 6;

    private final List<Integer> numbers;

    public static Lotto from(String winningNumber) {
        try {
            return new Lotto(Arrays.stream(winningNumber.split(SEPARATOR))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호가 숫자가 아닙니다.");
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int calculateMatchCount(Lotto lottoNumbers) {
        return lottoNumbers.compareLottoNumbers(this.numbers);
    }

    private int compareLottoNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }


    private void validate(List<Integer> numbers) {
        for (int i = REPEAT_INITIAL_VALUE; i < numbers.size(); i++) {
            validateBlank(i, numbers);
            validateLottoNumberRange(i, numbers);
        }
        validateLength(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateBlank(int initialValue, List<Integer> numbers) {
        if (String.valueOf(numbers.get(initialValue)).equals(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 숫자에 공백이 포함되어 있습니다.");
        }
    }

    private void validateLottoNumberRange(int initialValue, List<Integer> numbers) {
        if (numbers.get(initialValue) < LOTTO_MIN_NUMBER || numbers.get(initialValue) > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위를 벗어났습니다.");
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DEFAULT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 길이가 올바르지 않습니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if (tempNumbers.contains(number))
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
            tempNumbers.add(number);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}