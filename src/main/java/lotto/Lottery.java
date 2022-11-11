package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public List<Lotto> createLottos(int buyLottos) {
        return IntStream.range(0,buyLottos)
                .mapToObj(ticket -> getLottoInt())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Integer> getLottoInt() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
