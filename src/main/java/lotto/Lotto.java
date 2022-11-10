package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;
    Money money = new Money();

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
    public Map<Integer, List<Integer>> generateLottoNumber(List<Integer> numbers) {
        int count = money.countLotto(money.inputMoney());

        Map<Integer, List<Integer>> lottoMap = new HashMap<>();
        for (int i = 0; i < count; i++)
        {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoMap.put(i, lottoNumbers);
        }
        return lottoMap;
    }
}
