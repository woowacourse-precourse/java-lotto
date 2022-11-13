package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import lotto.model.Money;

public class LottoVendingMachine {

    List<Lotto> haveLottoList;

    public LottoVendingMachine(Money money) {
        buyLottoTicket(money);
    }

    public LottoVendingMachine(List<Lotto> lottoList) {
        this.haveLottoList = lottoList;
    }

    public List<Lotto> getHaveLottoList() {
        return haveLottoList;
    }

    public int getPrice() {
        return haveLottoList.size() * LottoConstants.LOTTO_PRICE;
    }


    private void buyLottoTicket(Money money) {
        int count = money.getMoney() / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (; count > 0; count--) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.LOTTO_NUMBER_START, LottoConstants.LOTTO_NUMBER_END,
                    LottoConstants.LOTTO_NUMBER_SIZE);
            lottoList.add(new Lotto(numbers));
        }

        this.haveLottoList = lottoList;
        printHaveLottoList();
    }

    private void printHaveLottoList() {
        System.out.println(haveLottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : haveLottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
