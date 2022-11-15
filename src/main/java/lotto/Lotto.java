package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public static List<Lotto> issueLotto(int numberOfLottos) {
        numberOfLottosValidation(numberOfLottos);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    private static void numberOfLottosValidation(int numberOfLottos) {
        if (numberOfLottos < 1) {
            throw new IllegalArgumentException("[ERROR] 1개 이상의 로또 개수를 입력하세요.");
        }
    }

    public static Lotto createWinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
