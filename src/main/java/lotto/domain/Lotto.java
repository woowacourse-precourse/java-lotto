package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력되어야 합니다.");
        }
        for (int i =0;i<6;i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
