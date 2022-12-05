package lotto.service;

import java.util.Map;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoList;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoNumber;
import lotto.domain.WinningLottoTicket;

public class LottoService {

    public WinningLottoTicket getWinningLottoTicket(User user, LottoList lottoList) {
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(user.getWinningNumber(), user.getBonusNumber());
        LottoMachine lottoMachine = new LottoMachine(winningLottoNumber);
        return lottoMachine.createLottoTicket(lottoList);
    }

    public LottoList createLottoList(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoList lottoList = lottoGenerator.createLotto(money);
        return lottoList;
    }

    public int getSum(Map<WinningLotto, Integer> winningLottoCount) {
        int sum = 0;
        for (WinningLotto winningLotto : winningLottoCount.keySet()) {
            if (WinningLotto.isNothing(winningLotto)) {
                continue;
            }
            if (isWinningLotto(winningLottoCount, winningLotto)) {
                sum += winningLotto.getWinningPrice() * winningLottoCount.get(winningLotto);
            }
        }
        return sum;
    }

    private static boolean isWinningLotto(Map<WinningLotto, Integer> winningLottoCount, WinningLotto winningLotto) {
        return winningLottoCount.get(winningLotto) > 0;
    }

    public static float calculateProfit(User user, float sum) {
        Money money = user.getMoney();
        return sum * 100 / money.getPrice();
    }
}
