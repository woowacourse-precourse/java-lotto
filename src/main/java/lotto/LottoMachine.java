package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<List<Integer>> createLotto() {
        LottoStore lottoStore = new LottoStore();
        int lottoCount = lottoStore.calculateLottoCount(1);
        List<List<Integer>> totalLotteries = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            totalLotteries.add(numbers);
        }
        return totalLotteries;
    }

    public List<List<Integer>> sortLottoNumbers() {
        List<List<Integer>> totalLotteries = createLotto();
        for (List<Integer> lotto : totalLotteries) {
            Collections.sort(lotto);
        }
        return totalLotteries;
    }
}
