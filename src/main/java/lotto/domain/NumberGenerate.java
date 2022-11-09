package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerate {

    private final List<List<Integer>> userAllLotto;

    public NumberGenerate(int numberOfPurchases) {

        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int purchases = 0; purchases < numberOfPurchases; purchases++) {
            userLottoNumbers.add(createRandom());
        }
        this.userAllLotto = userLottoNumbers;
    }

    private static List<Integer> createRandom() {
        List<Integer> userLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return userLottoNumbers;
    }

    public List<List<Integer>> getUserAllLotto() {
        return this.userAllLotto;
    }
}
