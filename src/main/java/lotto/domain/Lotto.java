package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;//주어진 금액에 대한 로또 번호 생성 결과물

    public Lotto(List<Integer> numbers) {//Random의 pickUniqueNumbersInRange를 사용해서 서로 다른 숫자 생성
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {//입력한 숫자 갯수 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

}
