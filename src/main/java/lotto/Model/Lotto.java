package lotto.Model;

import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개여야 합니다.");
        if(numbers.stream().anyMatch(num -> num < 1 || num > 45))
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1부터 45사이 숫자이어야 합니다.");
        HashMap<Integer,Integer> duplicated = new HashMap<>();
        numbers.forEach(number->{
            int cnt = duplicated.getOrDefault(number,0);
            if(cnt >= 1) throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            duplicated.put(number, cnt+1);
        });
    }
}
