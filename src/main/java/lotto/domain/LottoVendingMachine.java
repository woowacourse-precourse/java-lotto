package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Money;

public class LottoVendingMachine {

    Money money;
    List<Lotto> haveLottoList;

    public LottoVendingMachine(Money money) {
        buyLottoTicket(money);
    }

    public List<Lotto> getHaveLottoList() {
        return haveLottoList;
    }

    private void buyLottoTicket(Money money) {
        int count = money.getMoney() / 1000;
        List<Lotto> lottoList = new ArrayList<>();

        for (; count > 0; count--) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
