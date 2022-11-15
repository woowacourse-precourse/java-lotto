package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoSeller;
import lotto.domain.PaymentCalculator;
import lotto.domain.TotalLottoResult;
import lotto.domain.constants.LottoRank;

import java.util.List;
import java.util.Map;

public class GameService {
    private static final GameService instance = new GameService();
    private PaymentCalculator calculator;
    private LottoDraw lottoDraw;

    private GameService() { }

    public static GameService getInstance() {
        return instance;
    }

    public void initializePaymentCalculator(int payment) throws IllegalArgumentException {
        this.calculator = new PaymentCalculator(payment);
    }

    public int calculatePurchaseAmount() {
        return calculator.calculateAmountByLottoPrice();
    }

    public List<Lotto> sellLottosByAmount(int amount) throws IllegalArgumentException {
        return LottoSeller.issueLottosByAmount(amount);
    }

    public void drawLotto(Lotto lottoToDraw, int bonusNumberToDraw) throws IllegalArgumentException {
        this.lottoDraw = new LottoDraw(lottoToDraw, bonusNumberToDraw);
    }

    public TotalLottoResult checkTotalLottoResult(List<Lotto> purchasedLottos) throws IllegalArgumentException {
        Map<LottoRank, Integer> RankedCounts = lottoDraw.sumUpRankedCounts(purchasedLottos);
        return new TotalLottoResult(RankedCounts);
    }

    public double calculateEarningRatio(int totalPrize) throws IllegalArgumentException {
        return calculator.calculateEarningRatio(totalPrize);
    }
}
