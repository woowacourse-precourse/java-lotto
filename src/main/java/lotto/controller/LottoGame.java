package lotto.controller;

import static lotto.model.Constant.FIFTH_PRIZE;
import static lotto.model.Constant.FIRST_PRIZE;
import static lotto.model.Constant.FOURTH_PRIZE;
import static lotto.model.Constant.MONEY_UNIT;
import static lotto.model.Constant.ROUNDED_NUMBER;
import static lotto.model.Constant.SECOND_PRIZE;
import static lotto.model.Constant.THIRD_PRIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Constant;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoGame() {
        this.lottoInputView = new LottoInputView();
        this.lottoOutputView = new LottoOutputView();
        this.lottos = new ArrayList<>();
    }

    public void startLottoGame() {
        purchaseLotto();
        makeWinningNumber();
        checkWinningLotto();
    }

    public void purchaseLotto() {
        int userMoney = lottoInputView.getLottoAmount();
        issueLotto(userMoney);
        lottoOutputView.printLottoCount(userMoney, lottos);
    }

    public void issueLotto(int userMoney) {
        int lottoPaperCount = userMoney / 1000;
        makeUserLottos(lottoPaperCount);
    }

    public void makeUserLottos(int lottoPaperCount) {
        for (int i = 0; i < lottoPaperCount; i++) {
            List<Integer> randomLottoNumbers = makeRandomLottoNumbers();
            Lotto newUserLotto = new Lotto(randomLottoNumbers);
            lottos.add(newUserLotto);
        }
    }

    private List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange
                (Constant.NUMBER_RANGE_START,
                        Constant.NUMBER_RANGE_END,
                        Constant.LOTTO_NUMBER_COUNT);
        //sortLottoNumbers(randomNumbers);
        return randomNumbers;
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public void makeWinningNumber() {
        List<Integer> winningLottoNumbers = lottoInputView.getLottoNumber();
        int bonusNumber = lottoInputView.getBonusNumber();
        winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public void checkWinningLotto() {
        List<Integer> winningCount = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto userLotto = lottos.get(i);
            int sameNumberCount = winningLotto.countSameNumber(userLotto);
            winningCount.add(sameNumberCount);
        }
        double profitPercentage = calculateProfitPercentage(winningCount);
        lottoOutputView.printWinningStatistic(winningCount, profitPercentage);
    }

    public double calculateProfitPercentage(List<Integer> winningCount) {
        int purchaseAmount = lottos.size() * MONEY_UNIT;
        int[] prizeMoneys = {FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE};
        int profit = 0;
        for (int i = 0; i < winningCount.size(); i++) {
            int rankingCount = winningCount.get(i);
            int prizeMoney = prizeMoneys[i];
            profit += (rankingCount * prizeMoney);
        }
        double profitPercentage = (double) profit / purchaseAmount;
        double roundedPercentage = Math.round(profitPercentage * ROUNDED_NUMBER) / ROUNDED_NUMBER;
        return roundedPercentage;
    }
}
