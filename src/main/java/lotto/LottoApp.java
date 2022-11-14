package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoApp {
    public LottoService lottoService = new LottoService();
    public void run() {
        try {
            LottoView.printBuyRequest();
            String money = Console.readLine().trim();
            Validator.validateMoneyString(money);
            int count = lottoService.calBuyingCount(Integer.parseInt(money));

            LottoView.printBuyNumber(count);
            Lottos lottos = lottoService.getLottos(count);
            LottoView.printLottoNumbers(lottos);

            LottoView.printWinningLottoRequest();
            String lotto = Console.readLine().trim();
            Validator.validateLottoString(lotto);
            WinningLotto winningLotto = new WinningLotto(lotto);

            LottoView.printBonusNumberRequest();
            String bonusNumber = Console.readLine().trim();
            winningLotto.setBonusNumber(bonusNumber);

            List<Integer> result = lottoService.getResult(winningLotto, lottos);
            double rateOfReturn = lottoService.getRateOfReturn(Integer.parseInt(money), result);
            LottoView.printWinningStatistics(result, rateOfReturn);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
