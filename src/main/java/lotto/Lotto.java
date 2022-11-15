package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    public static List<Lotto> generateLottoSet(int counts) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < counts; count++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 다릅니다.");
        }
        for (int number : numbers) {
            if (number >= 1 && number <= 45) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호입니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 사이에 중복이 존재합니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> notDuplicatedNumbers = new HashSet<>(numbers);
        return notDuplicatedNumbers.size() != numbers.size();
    }
}
