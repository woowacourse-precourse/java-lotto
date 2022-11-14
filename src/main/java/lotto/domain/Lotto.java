package lotto.domain;

import java.util.regex.Pattern;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoRange(numbers);
        validateLottoDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR} 복권 번호 개수는 6개이어야만 합니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호 개수");
        }
    }
    
    private void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                System.out.println("[ERROR} 복권 번호의 범위는 1 ~ 45 사이어야만 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호 범위");
            }
        }
    }

    private void validateLottoDuplication(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.indexOf(numbers.get(index)) != index) {
                System.out.println("[ERROR} 복권 번호는 중복이 허용되지 않습니다.");
                throw new IllegalArgumentException("[ERROR] 복권 번호의 중복");
            }
        }
    }

    public static void validateLottoIsNumeric(List<String> numbers) {
        String pattern = "^[0-9]*$";
        for (String number : numbers) {
            if (!Pattern.matches(pattern, number)) {
                System.out.println("[ERROR} 복권 번호는 양의 정수 형태이어야 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 복권 번호");
            }
        }
    }

}
