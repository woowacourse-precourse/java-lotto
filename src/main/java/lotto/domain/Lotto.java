package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("여섯개의 숫자를 입력해야 합니다");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다");
        }
        int filteredCnt = (int) numbers.stream().filter(number -> 1 <= number)
                .filter(number -> number <= 45)
                .count();
        if (filteredCnt != 6) {
            throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해야 합니다");
        }
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }

    public boolean has(Integer number) {
        return numbers.contains(number);
    }

    public Integer compare(Lotto winningNumber) {
        //우승 자리와 한자리씩 비교한다
        return (int) numbers.stream().filter(winningNumber::has)
                .count();
    }
    // 비교하며 숫자가 있는지, 보너스 숫자에 있는지 저장해서 반환한다
}
