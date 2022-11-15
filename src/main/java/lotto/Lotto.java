package lotto;

import util.Validator;

import java.util.List;

public class Lotto {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final String NUMBER_LENGTH_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    private final List<Integer> numbers;




    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateLength(numbers, LOTTO_LENGTH);
        validator.validateDuplicate(numbers);
        validator.validateRange(numbers);
    }

    public int compareLottoNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }
    public List<Integer> getLottoNumbers() {
        return numbers;
    }

}
