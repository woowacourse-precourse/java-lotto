package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;
import lotto.service.LottoPublishService;
import lotto.service.LottoRaffleService;

import java.util.List;

public class LottoController {

    private final LottoPublishService lottoPublishService = new LottoPublishService();
    private LottoRaffleService lottoRaffleService;

    private final LottoWinning.Builder builder = new LottoWinning.Builder();

    private List<Lotto> lottos;

    public List<Lotto> buyLotto(Long money) {
        lottos = lottoPublishService.publish(money);
        return lottos;
    }

    public void inputWinLotto(Lotto lotto) {
        builder.winLotto(lotto);
    }

    public void inputWinBonus(int bonus) {
        builder.winBonus(bonus);
    }

    public LottoRaffleRecord raffle() {
        initRaffler();
        return lottoRaffleService.raffle(lottos);
    }

    private void initRaffler() {
        LottoWinning lottoWinning = new LottoWinning(builder);
        lottoRaffleService = new LottoRaffleService(lottoWinning);
    }
}
