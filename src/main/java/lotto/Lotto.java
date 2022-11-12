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
    }

    // TODO: 추가 기능 구현
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNum = new ArrayList<>();

        while(lottoNum.size() < 6) {
            int generatedNumber = Randoms.pickNumberInRange(1, 45);

            if(!lottoNum.contains(generatedNumber)) {
                lottoNum.add(generatedNumber);
            }
        }

        lottoNum.sort(Comparator.naturalOrder());

        return lottoNum;
    }
}
