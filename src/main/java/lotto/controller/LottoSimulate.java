package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinLotto;
import lotto.service.Calculate;
import lotto.service.LottoShop;
import lotto.service.Statistics;
import lotto.view.Input;
import lotto.view.Print;

public class LottoSimulate {

    private final Print print = new Print();

    private final Input input = new Input();

    private final LottoShop lottoShop = new LottoShop();

    private final Statistics statistics = new Statistics();

    private final Calculate calculate = new Calculate();

    public void start() {
        try {
            int purchasePrice = inputPurchasePrice();
            List<Lotto> lottos = buyLottos(purchasePrice);
            WinLotto winLotto = new WinLotto(new Lotto(inputWinLottoNumbers()), inputWinLottoBonusNumber());
            Map<Prize, Integer> lottoStatics = getLottoStatics(winLotto, lottos);
            calculateYield(purchasePrice, lottoStatics);
        } catch (IllegalArgumentException e) {
            print.out("[ERROR] " + e.getMessage());
        }
    }

    private int inputPurchasePrice() {
        print.requestPurchasePrice();
        return input.number();
    }

    private List<Lotto> buyLottos(int purchasePrice) {
        List<Lotto> lottos = lottoShop.buy(purchasePrice);
        print.lottoNumbers(lottos);
        return lottos;
    }

    private List<Integer> inputWinLottoNumbers() {
        print.requestWinLottoNumber();
        return input.numbers();
    }

    private int inputWinLottoBonusNumber() {
        print.requestBonusNumber();
        return input.number();
    }

    private Map<Prize, Integer> getLottoStatics(WinLotto winLotto, List<Lotto> lottos) {
        Map<Prize, Integer> lottoStatics = statistics.produce(winLotto, lottos);
        print.statics(lottoStatics);
        return lottoStatics;
    }

    private void calculateYield(int purchasePrice, Map<Prize, Integer> lottoStatics) {
        double profits = calculate.yield(purchasePrice, lottoStatics);
        print.yield(profits);
    }
}
