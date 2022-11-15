package lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoView lottoView;
    private final LottoUtil lottoUtil;
    private final LottoRandom lottoRandom;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoRandom = new LottoRandom();
        this.lottoUtil = new LottoUtil();
    }

    public void run() {
        try{
            int purchaseAmount = this.getPurchaseAmount();
            List<List<Integer>> lottoRandom = this.generateLottoRandom(purchaseAmount);
            this.calculateStatics(lottoRandom, purchaseAmount);
        } catch (Exception e){
            this.lottoView.printException(e);
            throw e;
        }
    }

    private int getPurchaseAmount() {
        this.lottoView.printPurchaseAmountQuestion();
        String input = this.lottoView.getUserInput();

        int parseIntInput = this.lottoUtil.StringToInt(input);

        return parseIntInput;
    }

    private List<List<Integer>> generateLottoRandom(int purchaseAmount) {
        int purchaseCount = this.lottoRandom.calculatePurchaseCount(purchaseAmount);
        this.lottoView.printPurchaseUnitCount(purchaseCount);

        List<List<Integer>> lottoRandom = this.lottoRandom.generateRandomLottoNumberList(purchaseCount);
        this.lottoView.printNestedList(lottoRandom);

        return lottoRandom;
    }

    private void calculateStatics(List<List<Integer>> userLottoList, int purchaseAmount) {
        this.lottoView.printMatchLottoNumberQuestion();
        String prizeNumberInput = this.lottoView.getUserInput();
        List<Integer> prizeNumber = this.lottoUtil.StringListToIntList(
                this.lottoUtil.tokenizeString(prizeNumberInput));

        Lotto lotto = new Lotto(prizeNumber);

        this.lottoView.printBonusNumberQuestion();
        String bonusNumberInput = this.lottoView.getUserInput();
        int bonusNumber = this.lottoUtil.StringToInt(bonusNumberInput);

        Map<Lotto.MatchInfo, Integer> statistics = lotto.calculateLottoStatistics(userLottoList, bonusNumber);
        BigInteger winningAmount = lotto.calculateWinningAmount(statistics);
        BigDecimal ratio = lotto.calculateProfitRatio(winningAmount, purchaseAmount);

        this.lottoView.printLottoStatics(statistics, ratio);
    }
}
