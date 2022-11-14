package lotto.domain;

/*
 * 1. 제공된 Lotto 클래스를 활용해 구현해야 한다.
 * 2. Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
 * 3. numbers의 접근 제어자인 private을 변경할 수 없다.
 * 4. Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
 * 5. Lotto의 패키지 변경은 가능하다.
 */

import lotto.validate.LottoValidate;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        new LottoValidate().validate(numbers);
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
