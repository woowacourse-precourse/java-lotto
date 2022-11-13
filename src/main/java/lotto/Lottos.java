package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.InputView.inputPurchase;

public class Lottos {

    private static final String OUTPUT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    private static List<Integer> createSingleRandomLotto() {
        List<Integer> lotto = new ArrayList<>();
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return lotto;

    }

    public static List<List<Integer>> createRandomLottos() {
        int n = inputPurchase() / 1000;
        System.out.println(n + OUTPUT_PURCHASE_COUNT_MESSAGE);
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lottos.add(createSingleRandomLotto());
        }
        return lottos;
    }
}
