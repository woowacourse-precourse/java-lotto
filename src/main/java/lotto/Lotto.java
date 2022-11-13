package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    // 매개 변수 없는 생성자 추가 불가
    // 인스턴스 변수 추가 불가
    // 패키지 변경은 가능
    private final List<Integer> numbers; //private 변경 불가

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // TODO: 번호 유효성 검사

}
