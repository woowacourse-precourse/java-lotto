package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception{
        validate(numbers);
        validate_winnumbers(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validate_winnumbers(List<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 중복되지 않는 숫자 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()) {
            System.out.println("[ERROR] 당첨 번호는 중복되지 않는 숫자 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }


        for(int n : numbers) {
            if (n < 1 || n > 45) {
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

}
