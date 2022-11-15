package lotto.controller;

import static lotto.model.Constant.MINIMUM_SAME_NUMBER;
import static lotto.model.Constant.MONEY_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Constant;
import lotto.model.Lotto;
import lotto.model.Rank;
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
        int lottoPaperCount = userMoney / 1000;
        makeUserLottos(lottoPaperCount);
        lottoOutputView.printLottoCount(lottoPaperCount, lottos);
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
        return sortLottoNumbers(randomNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void makeWinningNumber() {
        List<Integer> winningLottoNumbers = lottoInputView.getLottoNumber();
        int bonusNumber = lottoInputView.getBonusNumber();
        winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public void checkWinningLotto() {
        Map<Rank, Integer> rankResult = initializeRankResult();
        for (Lotto userLotto : lottos) {
            int sameNumberCount = winningLotto.countSameNumber(userLotto);
            if (isWinningLotto(sameNumberCount)) {
                Rank rank = winningLotto.calculateRank(userLotto);
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
        double profitPercentage = calculateProfitPercentage(rankResult);
        lottoOutputView.printWinningStatistic(rankResult, profitPercentage);
    }

    public Map<Rank, Integer> initializeRankResult() {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for(Rank rank: Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    public boolean isWinningLotto(int sameNumberCount) {
        if(sameNumberCount >= MINIMUM_SAME_NUMBER) {
            return true;
        }
        return false;
    }

    public double calculateProfitPercentage(Map<Rank, Integer> rankResult) {
        int purchaseAmount = lottos.size() * MONEY_UNIT;
        int profit = 0;
        for (Rank rank : rankResult.keySet()) {
            int rankingCount = rankResult.get(rank);
            int prizeMoney = rank.getReward();
            profit += (rankingCount * prizeMoney);
        }
        double profitPercentage = (double) profit / purchaseAmount;
        return profitPercentage;
    }
}
