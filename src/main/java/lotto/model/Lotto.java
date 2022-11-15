package lotto.model;

import java.util.List;

import lotto.utils.CheckInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자이어야합니다.");
        }
        CheckInput.checkInputLottoDuplicate(numbers);

    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
    // 제공된 Lotto 클래스를 활용해 구현해야 한다.
    // Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
    // numbers의 접근 제어자인 private을 변경할 수 없다.
    // Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
    // Lotto의 패키지 변경은 가능하다.
}
