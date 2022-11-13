package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getWinningLotto() {
        return numbers;
    }
    // TODO: 추가 기능 구현
    private void validate(List<Integer> numbers) {
        if (! isValidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 총 6개의 숫자를 입력해주세요.");
        }
        if (! isValidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45 이하의 숫자를 입력하셔야 합니다.");
        }
        if (! isValidUnique(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().noneMatch(number -> number < 1 || 45 < number);
    }

    private boolean isValidUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == 6;
    }
    public static boolean isDiff(int number) {

        return false;
    }

    private boolean isDifferent(int number) {
        return ! numbers.contains(number);
    }

}
