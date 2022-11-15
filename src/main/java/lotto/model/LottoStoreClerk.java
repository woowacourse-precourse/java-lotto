package lotto.model;

import java.util.List;

/**
 * 장당 1000원에 로또를 판매
 */
public class LottoStoreClerk {
    public List<Lotto> sellLotto(int fee) {
        int theAmountOfLottos = caculateTheAmountOfLottos(fee);
        return LottoPrinter.printLottos(theAmountOfLottos);
    }

    private int caculateTheAmountOfLottos(int fee) {
        return fee / Constants.LOTTO_PRICE;
    }


}
