package lotto.service;

import lotto.domain.Buyer;
import lotto.util.LottoRandomPeek;
import lotto.util.Statistics;
import lotto.domain.WinLotto;
import lotto.generate.BuyerGenerate;
import lotto.generate.WinLottoGenerate;
import lotto.output.LottoRandomPeekOutput;
import lotto.output.StatisticsOutput;

public class LottoService {
    public void play() throws IllegalArgumentException {

        Buyer buyer = new BuyerGenerate().generate();
        LottoRandomPeek lottoRandomPeek = new LottoRandomPeek();
        lottoRandomPeek.generateRandom(buyer.getBuyLottoCount());
        new LottoRandomPeekOutput().output(lottoRandomPeek.getRandomLottos());

        WinLotto winLotto = new WinLottoGenerate().generate();

        Statistics statistics = new Statistics();
        statistics.compareNumber(lottoRandomPeek.getRandomLottos(), winLotto);
        StatisticsOutput output = new StatisticsOutput();
        output.outputWiningHistory(statistics.getRank());
        output.outputProfit(statistics.getProfitRate(buyer));
    }
}
