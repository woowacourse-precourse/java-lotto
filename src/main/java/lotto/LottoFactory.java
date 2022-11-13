package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < quantity) {
            List<Integer> lottoNumbers = createLottoNumbers();
            this.sortInAscending(lottoNumbers);

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private void sortInAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
