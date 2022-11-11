package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        for(int i=0;i<6;i++){
            if (!(0<numbers.get(i) && numbers.get(i)<= 45)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Set<Integer> noDuplicate = new HashSet<>(numbers);
        if(noDuplicate.size()!= numbers.size()){
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }
}
