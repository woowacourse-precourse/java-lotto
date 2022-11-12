package lotto.domain;

import lotto.domain.Guide;
import java.util.regex.Pattern;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR} 복권 번호 개수는 6개이어야만 합니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호 개수");
        }
    }
    
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                System.out.println("[ERROR} 복권 번호의 범위는 1 ~ 45 사이어야만 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호 범위");
            }
        }
    }

    public void validateIsNumeric(List<String> numbers) {
        String pattern = "^[0-9]*$";
        for (String number : numbers) {
            if (!Pattern.matches(pattern, number)) {
                System.out.println("[ERROR} 복권 구입 금액은 양의 정수 형태이어야 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 복권 구입 금액");
            }
        }
    }


}
