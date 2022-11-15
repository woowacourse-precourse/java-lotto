package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.view.Output;

public class Person {
    private List<Lotto> lottos = new ArrayList<>();
    private int purchaseAmount = 0;
    private int totalLottoPrize = 0;
    private LottoScoreResult lottoScoreResult = new LottoScoreResult();
    public void buyLottos() {
        purchaseAmount = Input.inputPurchaseAmount();
        for (int i = 0; i < purchaseAmount; i += Game.LOTTO_PRICE) {
            lottos.add(new Lotto(createRandomLottoNum()));
        }
    }

    public void calculateTotalLottoPrize() {
        int totalPrize = 0;
        totalPrize= lottoScoreResult.winScoreList.get(0) * 0
                + lottoScoreResult.winScoreList.get(1) * LottoPrize.FIFTH_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(2) * LottoPrize.SECOND_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(3) * LottoPrize.THIRD_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(4) * LottoPrize.FOURTH_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(5) * LottoPrize.FIFTH_PRIZE.lottoPrize;
        totalLottoPrize = totalPrize;

    }

    public double calculateTotalReturnRate(){
        return Math.round(totalLottoPrize/purchaseAmount);
    }
    private List<Integer> createRandomLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public void printLottoScoreResult(){
        Output.outputLottoWinScoreResult(lottoScoreResult);
        Output.ouputLottoReturnRate(calculateTotalReturnRate());
    }
    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoScoreResult getLottoScoreResult() {
        return lottoScoreResult;
    }
}
