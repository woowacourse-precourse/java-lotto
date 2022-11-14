package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;
import lotto.service.LottoPublishService;
import lotto.service.LottoRaffleService;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoPublishService lottoPublishService = new LottoPublishService();
    private LottoRaffleService lottoRaffleService;

    private LottoWinning lottoWinning;
    private LottoWinning.Builder builder;

    private List<Lotto> lottos;

    public List<Lotto> buyLotto(int money) {
        lottos = lottoPublishService.publish(money);
        return lottos;
    }

    public void inputWinLotto(Lotto lotto) {
        builder.winLotto(lotto);
    }

    public void inputWinBonus(int bonus) {
        builder.winBonus(bonus);
    }

    public List<Integer> raffle() {
        initRaffler();
        LottoRaffleRecord result = lottoRaffleService.raffle(lottos);
        return new ArrayList<>(result.getPrizeRecord().values());
    }

    private void initRaffler() {
        lottoWinning = new LottoWinning(builder);
        lottoRaffleService = new LottoRaffleService(lottoWinning);
    }
}
