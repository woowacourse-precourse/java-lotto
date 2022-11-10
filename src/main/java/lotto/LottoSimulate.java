package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.LottoText;

import java.util.List;

public class LottoSimulate {
    private final Print print = new Print();

    private final Convert convert = new Convert();

    private final LottoShop lottoShop = new LottoShop();

    public void start() {
        int purchasePrice = inputPurchasePrice();
        List<Lotto> lottos = buyLottos(purchasePrice);
        List<Integer> winLottoNumbers = inputWinLottoNumbers();
        int winLottoBonusNumber = inputWinLottoBonusNumber();
    }

    private int inputPurchasePrice() {
        print.out(LottoText.REQUEST_PURCHASE_PRICE);
        String input = Console.readLine();
        return convert.toInt(input);
    }

    private List<Lotto> buyLottos(int purchasePrice) {
        int lottoCount = convert.toLottoCount(purchasePrice);
        List<Lotto> lottos = lottoShop.buy(lottoCount);

        print.out(LottoText.PURCHASE_COUNT, lottoCount);
        print.out(lottos);

        return lottos;
    }

    private List<Integer> inputWinLottoNumbers() {
        print.out(LottoText.REQUEST_WIN_LOTTO_NUMBER);
        String input = Console.readLine();
        return convert.toWinLottoNumbers(input);
    }

    private int inputWinLottoBonusNumber() {
        print.out(LottoText.REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        return convert.toWinLottoBonusNumber(input);
    }
}
