package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.validator.LottoNumberValidator;
import lotto.validator.MoneyValidator;

import java.util.List;

public class LottoController {
    public LottoService lottoService = new LottoService();

    public int printAndRequestMoney() {
        LottoView.printBuyRequest();
        String money = Console.readLine().trim();
        MoneyValidator.validate(money);
        return Integer.parseInt(money);
    }

    public int calAndShowBuyingCount(int money) {
        int buyingCount = lottoService.calBuyingCount(money);
        LottoView.printBuyNumber(buyingCount);
        return buyingCount;
    }

    public Lottos getAndShowLotto(int count) {
        Lottos lottos = lottoService.getLottos(count);
        LottoView.printLottoNumbers(lottos);
        return lottos;
    }

    public WinningLotto getWinningLotto() {
        LottoView.printWinningLottoRequest();
        String lotto = Console.readLine().trim();
        LottoNumberValidator.validate(lotto);

        WinningLotto winningLotto = new WinningLotto(lotto);
        addBonusNumber(winningLotto);

        return winningLotto;
    }

    public void addBonusNumber(WinningLotto winningLotto) {
        LottoView.printBonusNumberRequest();
        String bonusNumber = Console.readLine().trim();
        winningLotto.setBonusNumber(bonusNumber);
    }

    public List<Integer> getAndShowLottoResult(WinningLotto winningLotto, Lottos lottos) {
        List<Integer> result = lottoService.getWinningResult(winningLotto, lottos);
        LottoView.printWinningStatistics(result);
        return result;
    }

    public void calAndShowRateOfReturn(int money, List<Integer> result) {
        double rateOfReturn = lottoService.getRateOfReturn(money, result);
        LottoView.printRateOfReturn(rateOfReturn);
    }
}
