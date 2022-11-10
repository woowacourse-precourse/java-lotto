package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int inputMoney;

    public Lotto(List<Integer> numbers) { // 생성자
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { // 예외사항
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 여섯자리여야 합니다.");
        }

        if(inputMoney % 1000 != 0){
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    // TODO: 추가 기능 구현
}
