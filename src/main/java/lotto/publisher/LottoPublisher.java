package lotto.publisher;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPublisher {

    private List<Integer> generateSortedNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public Lotto publishLotto() {
        List<Integer> numbers = generateSortedNumber();
        Lotto lotto = new Lotto(numbers);

        LottoStorage.registerLottos(lotto);

        return lotto;
    }

}
