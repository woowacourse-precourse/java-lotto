package lotto;

import java.util.List;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        List<Lotto> lottos = generator.makeLottos(lottoTickets);
        Print.purchaseLotto(lottoTickets, lottos);

        Print.winningNumber();
        Lotto winningLotto = generator.makeLotto(Input.winningNumber());
        Print.bonusNumber();
        int bonus = Input.bonus();
    }
}
