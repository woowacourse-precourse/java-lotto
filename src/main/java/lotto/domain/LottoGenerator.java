package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<List<Integer>> userLottoTickets;

    public LottoGenerator(int purchasesQuantity) {

        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int purchases = 0; purchases < purchasesQuantity; purchases++) {
            userLottoNumbers.add(createRandom());
        }
        this.userLottoTickets = userLottoNumbers;
    }

    private static List<Integer> createRandom() {
        List<Integer> userLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(userLottoNumbers);
        return userLottoNumbers;
    }

    public List<List<Integer>> getUserLottoTickets() {
        return this.userLottoTickets;
    }
}
