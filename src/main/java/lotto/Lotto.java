package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
        return new Lotto(numbers);
    }

    @Override
    public  String toString() {
        return numbers.toString();
    }
}
