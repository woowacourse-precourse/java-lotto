package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Lotto> getLottoList(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < money / 1000; index++) {
            lottoList.add(generateLottoList());
        }
        return lottoList;
    }

    public static Lotto generateLottoList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int compareNumbers(List<Integer> winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer number : winningNumbers) {
            if (lotto.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }

    @Override
    public  String toString() {
        return numbers.toString();
    }
}
