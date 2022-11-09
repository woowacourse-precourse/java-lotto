package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.TreeSet;

public class LottoGenerator {
    public static List<Lotto> lottos;
    private final int quantity;
    private List<Integer> lottoNumbers;

    public LottoGenerator(int quantity) {
        this.quantity = quantity;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto sortLottoNumbers(List<Integer> numbers) {
        return new Lotto(List.copyOf(new TreeSet<Integer>(numbers)));
    }
}
