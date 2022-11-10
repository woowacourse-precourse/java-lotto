package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.LottoText;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulate {
    private final Print print = new Print();

    private final Convert convert = new Convert();

    private final LottoShop lottoShop = new LottoShop();

    public void start() {
        int purchasePrice = inputPurchasePrice();
        List<Lotto> lottos = buyLottos(purchasePrice);
    }

    private int inputPurchasePrice() {
        print.out(LottoText.REQUEST_PURCHASE_PRICE);
        String input = Console.readLine();
        return convert.toInt(input);
    }

    private List<Lotto> buyLottos(int purchasePrice) {
        int lottoCount = convert.toLottoCount(purchasePrice);
        print.out(LottoText.PURCHASE_COUNT, lottoCount);
        return lottoShop.buy(lottoCount);
    }
}
