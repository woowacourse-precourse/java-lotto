package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> numbers1;
        numbers1 = new ArrayList<>();
        validate(numbers);
        isBoundary(numbers);
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 중복일 수 없습니다.");
        }
        numbers1 = new ArrayList<>(numbers);
        Collections.sort(numbers1);
        this.numbers = numbers1;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return " " + numbers;
    }
// TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void isBoundary(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (0 < numbers.get(i) && numbers.get(i) < 46) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
