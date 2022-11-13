package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final int startNumber;
    private final int endNumber;
    private final int numberCount;

    public LottoGenerator(int startNumber, int endNumber, int numberCount) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.numberCount = numberCount;
    }

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = createLotto();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberCount);
        return sortLottoNumbers(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}