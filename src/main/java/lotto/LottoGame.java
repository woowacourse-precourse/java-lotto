package lotto;

import java.util.List;

public class LottoGame {
    private final LottoGenerator generator = new LottoGenerator();

    public void start() {
        Print.money();
        int lottoTickets = Input.purchaseAmount();
        Print.purchaseLotto(lottoTickets);

        List<Lotto> lottos = generator.makeLottos(lottoTickets);
        Print.lottos(lottos);
    }
}
