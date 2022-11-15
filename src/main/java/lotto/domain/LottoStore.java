package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int A_LOTTO_PRICE = 1000;
    private static final int LENGTH_OF_WINNING_NUMBER = 6;
    private static final int NUMBER_MAX_RANGE = 45;
    private static final int NUMBER_MIN_RANGE = 1;

    private List<Lotto> lottoTickets = new ArrayList<>();

    public List<Lotto> buyLottoTickets(int lottoPurchaseMoney) {
        int lottoAmount = getLottoAmount(lottoPurchaseMoney);
        for (int i = 0; i < lottoAmount; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE, LENGTH_OF_WINNING_NUMBER)));
        }
        return lottoTickets;
    }

    public int getLottoAmount(int lottoPurchaseMoney) {
        return lottoPurchaseMoney / A_LOTTO_PRICE;
    }

}
