package lotto.domain;

import static lotto.constants.LottoConstant.A_LOTTO_PRICE;
import static lotto.constants.LottoConstant.LENGTH_OF_WINNING_NUMBER;
import static lotto.constants.LottoConstant.NUMBER_MAX_RANGE;
import static lotto.constants.LottoConstant.NUMBER_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

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
