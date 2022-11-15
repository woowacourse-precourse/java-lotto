package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
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
        Output.outputPurchaseLottoList(lottos, purchaseAmount);
    }

    public void calculateTotalLottoPrize() {
        int totalPrize = 0;
        totalPrize = lottoScoreResult.winScoreList.get(1) * LottoPrize.FIRST_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(2) * LottoPrize.SECOND_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(3) * LottoPrize.THIRD_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(4) * LottoPrize.FOURTH_PRIZE.lottoPrize
                + lottoScoreResult.winScoreList.get(5) * LottoPrize.FIFTH_PRIZE.lottoPrize;
        totalLottoPrize = totalPrize;

    }

    public double calculateTotalReturnRate() {
        return ((double)totalLottoPrize / (double)purchaseAmount)*100;
    }

    private List<Integer> createRandomLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        //Collections.sort(numbers,Comparator.naturalOrder());
        return numbers;
    }

    public void printLottoScoreResult() {
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
