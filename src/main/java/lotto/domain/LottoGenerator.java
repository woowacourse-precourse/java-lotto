package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private List<Lotto> lottos = new ArrayList<>();

    public LottoGenerator(int amount) {
        issueLotto(amount);
    }

    public static List<Integer> generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_LENGTH);

        return lottoNumbers;
    }

    private void issueLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> lotto = generateLotto();
            lotto = sortListInOrder(lotto);
            lottos.add(new Lotto(lotto));
        }
    }

    private List<Integer> sortListInOrder(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i : numbers) {
            list.add(i);
        }

        Collections.sort(list);
        return list;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
