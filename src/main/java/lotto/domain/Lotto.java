package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplication(numbers);

        this.numbers = numbers;
    }

    public static void validateLottoIsNumeric(List<String> numbers) throws IllegalArgumentException {
        String pattern = "^[0-9]*$";
        for (String number : numbers) {
            if (!Pattern.matches(pattern, number)) {
                throw new IllegalArgumentException("[ERROR] 복권 번호는 양의 정수 형태이어야 합니다.");
            }
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void validateLottoSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 복권 번호 개수는 6개이어야만 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 복권 번호의 범위는 1 ~ 45 사이어야만 합니다.");
            }
        }
    }

    private void validateLottoDuplication(List<Integer> numbers) throws IllegalArgumentException {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.indexOf(numbers.get(index)) != index) {
                throw new IllegalArgumentException("[ERROR] 복권 번호는 중복이 허용되지 않습니다.");
            }
        }
    }

}
