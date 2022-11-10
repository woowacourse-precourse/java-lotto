package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    // final의 의미는 그 list format이 final? 아니면 그곳에 들어가는 값이 final?
    // [질문] Lotto class 에서 random 생성 명령까지 내리고 Application에서는 random 함수를 안쓸수는 없나? - 그냥 출력만 받아오는 방식은?

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        create(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
//    private void create(List<Integer> numbers) {
//    numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//    }

    public List<Integer> getNumbers() {
        System.out.println(numbers);
        return numbers;
    }

    // TODO: 추가 기능 구현
}
