package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.WinLotto;
import lotto.generate.BuyerGenerate;
import lotto.generate.WinLottoGenerate;
import lotto.ouput.RandomPeekOutput;
import lotto.ouput.StatisticsOutput;
import lotto.util.LottoRandomPeek;
import lotto.util.Statistics;

public class LottoService {
    public void play() throws IllegalArgumentException {

        Buyer buyer = new BuyerGenerate().generate();
        LottoRandomPeek lottoRandomPeek = new LottoRandomPeek();
        lottoRandomPeek.generateRandom(buyer.getBuyLottoCount());
        new RandomPeekOutput().output(lottoRandomPeek.getRandomLottos());

        WinLotto winLotto = new WinLottoGenerate().generate();

        Statistics statistics = new Statistics();
        statistics.compareNumber(lottoRandomPeek.getRandomLottos(), winLotto);
        statistics.calculateProfitRate(buyer);
        System.out.println(statistics);

    }
}
