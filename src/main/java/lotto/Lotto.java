package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static view.ErrorMessage.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> mutableNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        mutableNumbers.sort(Integer::compareTo);
        return new Lotto(mutableNumbers);
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
            throw new IllegalArgumentException(ERROR_HEADER.getMsg() + ERROR_LOTTO_NUMBER.getMsg());
        }
        for (int number : numbers) {
            if (number >= 1 && number <= 45) {
                continue;
            }
            throw new IllegalArgumentException(ERROR_HEADER.getMsg() + ERROR_LOTTO_RANGE.getMsg());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ERROR_HEADER.getMsg() + ERROR_LOTTO_DUPLICATE.getMsg());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> notDuplicatedNumbers = new HashSet<>(numbers);
        return notDuplicatedNumbers.size() != numbers.size();
    }
}
