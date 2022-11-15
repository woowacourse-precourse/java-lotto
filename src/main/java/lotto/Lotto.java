package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 길이가 다릅니다.");
        }
    }
    private void overlap(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }


}
