package lotto.reward;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers; //인스턴스 변수

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    //로또 클래스 오버로딩 -> 로또 랜덤 숫자 발행 확인하기
    public Lotto(RandomNumbers randomNumbers) {
        numbers = new ArrayList<>(randomNumbers.getRandomNumbers());
        Collections.sort(numbers);
    }

    public List<Integer> getLottoSixNumbers() {
        return numbers;
    }

    public Long matchCountNumbers(Lotto winningNumber) {
        return numbers.stream()
                .filter(winningNumber.getLottoSixNumbers()::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.catchException());
        }
    }
    // TODO: 추가 기능 구현
}
