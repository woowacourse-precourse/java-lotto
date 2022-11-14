package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.constants.LottoConstants;

public class LottoMachine {

    List<Lotto> buyLottoList;

    public LottoMachine(Money money) {
        buyLottoTicket(money);
    }

    public LottoMachine(List<Lotto> lottoList) {
        this.buyLottoList = lottoList;
    }

    public List<Lotto> getBuyLottoList() {
        return buyLottoList;
    }

    public int getPrice() {
        return buyLottoList.size() * LottoConstants.LOTTO_PRICE;
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

        this.buyLottoList = lottoList;
        printHaveLottoList();
    }

    private void printHaveLottoList() {
        System.out.println(buyLottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : buyLottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
