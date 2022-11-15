package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 로또 번호의 길이가 6개가 맞는지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        // 로또 번호를 구성하는 숫자들 중 중복되는 수가 존재하는지 확인
        // 6자리의 로또 번호 중 숫자 범위(1~45)를 벗어나는 숫자가 존재하는지 확인
    }

    public void printOneLotto() {
        System.out.println(numbers);
    }

    public List<Integer> getOneLotto() {
        return numbers;
    }

}
