package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.Prize;
import constant.LottoText;

import java.util.List;
import java.util.Map;

public class LottoSimulate {
    private final Print print = new Print();

    private final Convert convert = new Convert();

    private final LottoShop lottoShop = new LottoShop();

    private Statistics statistics = new Statistics();

    public void start() {
        try {
            int purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = buyLottos(purchasePrice);
            WinLotto winLotto = new WinLotto(inputWinLottoNumbers(), inputWinLottoBonusNumber());
            Map<Prize, Integer> statistic = getLottoStatics(winLotto, lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int inputPurchasePrice() throws IllegalArgumentException {
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

    private Map<Prize,Integer> getLottoStatics(WinLotto winLotto, List<Lotto> lottos) {
        Map<Prize,Integer> lottoStatics = statistics.produce(winLotto, lottos);
        print.out(LottoText.WINNING_STATISTICS);
        return lottoStatics;
    }
}
