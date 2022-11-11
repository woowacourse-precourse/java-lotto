package lotto;

import java.util.List;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Lottos lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);

        Print.winningNumber();
        Lotto winningLotto = generator.makeLotto(Input.winningNumber());
        Print.bonusNumber();
        int bonus = Input.bonus();

        BonusLotto bonusLotto = new BonusLotto(winningLotto, bonus);
        List<Integer> matchCount = lottos.result(bonusLotto);
    }
}
