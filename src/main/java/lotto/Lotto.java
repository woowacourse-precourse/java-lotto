package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    public void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6자리 당첨번호를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void validateNumbersRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                System.out.println("[ERROR] 당첨 번호는 1~45 사이의 숫자만 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public int size() {
        return numbers.size();
    }

    public int get(int order) {
        return numbers.get(order);
    }

    public boolean contains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<Integer> printLotto() {
        return this.numbers;
    }
}
