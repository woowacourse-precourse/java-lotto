package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

/*
* 제공된 Lotto 클래스를 활용해 구현해야 한다.
* Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
* numbers의 접근 제어자인 private을 변경할 수 없다.
* Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
* Lotto의 패키지 변경은 가능하다.
* */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> removeDuplicate = numbers.stream().distinct().collect(Collectors.toList());

        if(numbers.size() != removeDuplicate.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
