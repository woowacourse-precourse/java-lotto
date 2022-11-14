package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_SIZE;

public class Lottos {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static List<Lotto> createLottoList(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while (count != 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_SIZE)
                    .stream()
                    .sorted().collect(Collectors.toList())));
            count--;
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
