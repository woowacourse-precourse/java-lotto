package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < lottoQuantity; index++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortNumbers(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
