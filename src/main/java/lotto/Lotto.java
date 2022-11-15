package lotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 개수는 6개여야 합니다.");
        }
        for(int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                throw new IllegalArgumentException("[ERROR] 중복되는 값이 존재합니다.");
            }
            if(!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 입력된 번호의 범위가 1부터 45 사이여야 합니다.");
            }
        }
    }


    public List<Integer> getLottoNum() {
        return numbers;
    }


    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    public boolean countOfBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
