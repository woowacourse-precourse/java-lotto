package lotto;

import camp.nextstep.edu.missionutils.Console;
import constant.Prize;

import java.util.List;
import java.util.Map;

public class LottoSimulate {
    private final Print print = new Print();

    private final Convert convert = new Convert();

    private final LottoShop lottoShop = new LottoShop();

    private final Statistics statistics = new Statistics();

    private final Calculate calculate = new Calculate();

    public void start() {
        try {
            int purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = buyLottos(purchasePrice);
            WinLotto winLotto = new WinLotto(inputWinLottoNumbers(), inputWinLottoBonusNumber());
            Map<Prize, Integer> lottoStatics = getLottoStatics(winLotto, lottos);
            calculateYield(purchasePrice, lottoStatics);
        } catch (IllegalArgumentException e) {
            print.out(e.getMessage());
        }
    }

    private int inputPurchasePrice() throws IllegalArgumentException {
        print.requestPurchasePrice();
        String input = Console.readLine();
        return convert.toInt(input);
    }

    private List<Lotto> buyLottos(int purchasePrice) {
        int lottoCount = convert.toLottoCount(purchasePrice);
        List<Lotto> lottos = lottoShop.buy(lottoCount);
        print.lottoNumbers(lottos);
        return lottos;
    }

    private List<Integer> inputWinLottoNumbers() {
        print.requestWinLottoNumber();
        String input = Console.readLine();
        return convert.toWinLottoNumbers(input);
    }

    private int inputWinLottoBonusNumber() {
        print.requestBonusNumber();
        String input = Console.readLine();
        return convert.toWinLottoBonusNumber(input);
    }

    private Map<Prize,Integer> getLottoStatics(WinLotto winLotto, List<Lotto> lottos) {
        Map<Prize,Integer> lottoStatics = statistics.produce(winLotto, lottos);
        print.statics(lottoStatics);
        return lottoStatics;
    }

    private void calculateYield(int purchasePrice, Map<Prize, Integer> lottoStatics) {
        double profits = calculate.yield(purchasePrice, lottoStatics);
        print.yield(profits);
    }
}
