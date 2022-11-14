package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.constants.ErrorCode;
import lotto.domain.constants.LottoConstants;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.Money;

public class LottoMachine {

    private List<Lotto> buyLottoList;

    public LottoMachine(Money money) {
        validBill(money);
        this.buyLottoList = buyLottoTicket(money);
    }

    public List<Lotto> getBuyLottoList() {
        return buyLottoList;
    }

    private void validBill(Money money) {
        if (money.getMoney() % LottoConstants.LOTTO_PRICE != 0) {
            throw ErrorCode.NOT_BILL.getException();
        }
    }

    private List<Lotto> buyLottoTicket(Money money) {
        int count = money.getMoney() / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (; count > 0; count--) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.LOTTO_NUMBER_START, LottoConstants.LOTTO_NUMBER_END,
                    LottoConstants.LOTTO_NUMBER_SIZE);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }
}
