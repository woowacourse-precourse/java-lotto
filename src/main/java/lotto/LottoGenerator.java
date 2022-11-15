package lotto;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateLottos(int countOfLottos) {
        for (int i = 0; i < countOfLottos; i++) {
            List<Integer> numbers = generateNumbers();

            Lotto lotto = createLottoByNumbers(numbers);

            addToLottos(lotto);
        }

        return lottos;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers
                = Randoms.pickUniqueNumbersInRange(Lotto.FIRST_NUMBER, Lotto.LAST_NUMBER, Lotto.SIZE);

        return sortNumbersInAscending(numbers);
    }

    private Lotto createLottoByNumbers(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> sortNumbersInAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }

    private void addToLottos(Lotto lotto) {
        lottos.add(lotto);
    }
}
