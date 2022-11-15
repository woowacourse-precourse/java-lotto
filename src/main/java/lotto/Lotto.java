package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Message.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicatedNumber(numbers);
        checkRangeLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int count(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(INCORRECT_MONEY.getMessage());
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INCORRECT_MONEY_UNIT.getMessage());
        }

        int result = money / 1000;
        return result;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MORE_SIX_LOTTO.getMessage());
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_LOTTO.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void checkRangeLottoNumber(List<Integer> numbers) {
        final int start = 1;
        final int end = 45;
        for (int number : numbers) {
            if (!(number >= start || number <= end)) {
                throw new IllegalArgumentException(BETWEEN_NUMBER.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현
    public static List<List<Integer>> makeLotto(int count) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < count; i ++){
            List<Integer> winLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            winLotto = winLotto.stream().sorted().collect(Collectors.toList());
            lottos.add(winLotto);
        }

        return lottos;
    }
}
