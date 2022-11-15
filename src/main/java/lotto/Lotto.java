package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        checkDuplicate(numbers);
    }

    private void checkDuplicate(List<Integer> numbers) {
        long numbersCount = numbers.stream().distinct().count();
        if (numbersCount != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 값을 입력할 수 없습니다.");
        }
    }

    public long getWinLottoCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::isExistInNumbers)
                .count();
    }

    public boolean isExistInNumbers(long lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public String toString() {
        return numbers.toString();
    }
}
