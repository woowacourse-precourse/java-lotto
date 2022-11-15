package lotto.domain;

import static lotto.domain.constants.ErrorCode.NOT_BILL;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_END;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_START;
import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Money;

public class LottoMachine {

    private final List<Lotto> buyLotteries;

    public LottoMachine(Money money) {
        validBill(money);
        this.buyLotteries = buyLottoTicket(money);
    }

    public List<Lotto> getBuyLotteries() {
        return buyLotteries;
    }

    private void validBill(Money money) {
        if (money.getValue() % LOTTO_PRICE != 0) {
            throw NOT_BILL.getException();
        }
    }

    private List<Lotto> buyLottoTicket(Money money) {
        int tickets = money.getValue() / LOTTO_PRICE;
        List<Lotto> lotteries = new ArrayList<>();

        for (; tickets > 0; tickets--) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_SIZE);
            lotteries.add(new Lotto(lottoNumbers));
        }
        return lotteries;
    }
}
