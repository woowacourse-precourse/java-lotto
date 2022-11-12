package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private List<List<Integer>> userLottoTickets = new ArrayList<>();

    public LottoGenerator(int purchasesQuantity) {

        for (int purchases = 0; purchases < purchasesQuantity; purchases++) {
            this.userLottoTickets.add(createRandom()); //주문 개수만큼 랜덤생성
        }
    }

    private static List<Integer> createRandom() {
        List<Integer> getRandom = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        List<Integer> userLottoNumbers = new ArrayList<>(getRandom);
        Collections.sort(userLottoNumbers);
        return userLottoNumbers;
    }

    public List<List<Integer>> getUserLottoTickets() {
        return this.userLottoTickets;
    }
}
