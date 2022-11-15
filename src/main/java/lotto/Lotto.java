package lotto;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    // validate 구현  입력되는 로또 형태의 유효성을 검사하는 함수
    // 유효하면 그대로 전달한 리스트 반환
    // 유효하지 않으면 에러 발생
    private List<Integer> validate(List<Integer> numbers) {
        //입력된 로또 리스트 크기 확인
        throwInputExceptions(numbers.size() == 6, "로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.");

        // 중복 확인
        int frequency; // 확인할 빈도 수
        int comp; // 중복 확인하기 위해 각 순회마다 받을 배열
        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()) {
            comp = iter.next();
            frequency = Collections.frequency(numbers, comp);
            throwInputExceptions(frequency == 1, "로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
        }
        return numbers;
    }

    private void throwInputExceptions(boolean condition, String exceptionMessage) {
        if(condition) {
            return;
        }
        throw new IllegalArgumentException(exceptionMessage);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}