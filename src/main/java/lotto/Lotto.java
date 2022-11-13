package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

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

        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.subList(0, i).contains(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNum.sort(Comparator.naturalOrder());
        return lottoNum;
    }
}
