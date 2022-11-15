package lotto;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import static lotto.ErrorCode.*;

public class Lotto {
    private final List<Integer> numbers;
    private Logic logic;

    public Lotto(List<Integer> numbers) {
        logic = new Logic();
        this.numbers = validate(numbers);
    }

    // validate 구현  입력되는 로또 형태의 유효성을 검사하는 함수
    // 유효하면 그대로 전달한 리스트 반환
    // 유효하지 않으면 에러 발생
    private List<Integer> validate(List<Integer> numbers) {
        return logic.lotto_Validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}