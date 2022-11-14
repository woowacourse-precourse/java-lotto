package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 6개여야 합니다.");
        } else if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 중복되지 않아야 합니다.");
        }
    }

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
