package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        LottoAmount amount = insertMoney();
        Lottos lottos = purchaseLotto(amount.makeLottoTickets());
        WinningLotto winningLotto = makeWinningLotto();
        Map<LottoOperator, Integer> winningResult = makeResult(lottos, winningLotto);
        Print.yield(amount.makeLottoTickets(), winningResult);
    }

    private LottoAmount insertMoney() {
        Print.money();
        return new LottoAmount(Input.purchaseAmount());
    }

    private Map<LottoOperator, Integer> makeResult(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoOperator, Integer> winningResult = findWinningResult(lottos, winningLotto);
        Print.winningResult(winningResult);
        return winningResult;
    }

    private Lottos purchaseLotto(int lottoTickets) {
        Lottos lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        Print.winningNumber();
        List<Integer> winningNumber = Input.winningNumber();
        Print.bonusNumber();
        int bonus = Input.bonus();
        return generator.makeLotto(winningNumber, bonus);
    }

    private Map<LottoOperator, Integer> findWinningResult(Lottos lottos, WinningLotto bonusLotto) {
        List<LottoOperator> winningRanks = lottos.result(bonusLotto);
        Map<LottoOperator, Integer> winningResult = resetWinningResult();
        for (LottoOperator rank : winningRanks) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

    private static Map<LottoOperator, Integer> resetWinningResult() {
        Map<LottoOperator, Integer> winningResult = new LinkedHashMap<>();
        winningResult.put(LottoOperator.NO_LUCK, 0);
        winningResult.put(LottoOperator.THREE, 0);
        winningResult.put(LottoOperator.FOUR, 0);
        winningResult.put(LottoOperator.FIVE, 0);
        winningResult.put(LottoOperator.FIVE_BONUS, 0);
        winningResult.put(LottoOperator.SIX, 0);
        return winningResult;
    }
}
