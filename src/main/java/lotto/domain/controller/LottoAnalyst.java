package lotto.domain.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public class LottoAnalyst {

    private Map<RankingInformation, Integer> statistics;
    private WinningLotto winningLotto;
    private Lotto lottoBeingChecked;
    private int purchaseAmount;

    public LottoAnalyst() {
        initStatistics();
    }

    private void initStatistics() {
        statistics = new HashMap<>();

        for (RankingInformation oneRank : RankingInformation.values()) {
            statistics.put(oneRank, 0);
        }
    }

    public Map<RankingInformation, Integer> makeWinningStatistics(List<Lotto> lottos,
            WinningLotto winningLotto) {

        savePurchaseAmount(lottos.size());

        this.winningLotto = winningLotto;

        checkEachLottoWithWinningLotto(lottos);

        return statistics;
    }

    private void savePurchaseAmount(int numberOfLottos) {
        this.purchaseAmount = numberOfLottos * LottoIssuer.PRICE_OF_LOTTO;
    }

    private void checkEachLottoWithWinningLotto(List<Lotto> lottos) {
        for (Lotto oneLotto : lottos) {
            lottoBeingChecked = oneLotto;
            compareOneLotto();
        }
    }

    private void compareOneLotto() {
        int numberOfDuplicated = countMatchingNumbers();

        reflectStatistics(numberOfDuplicated);
    }

    private int countMatchingNumbers() {
        List<Integer> matchingNumbers = leaveOnlyDuplicated();

        int numberOfMatchingNumbers = matchingNumbers.size();

        return numberOfMatchingNumbers;
    }

    private List<Integer> leaveOnlyDuplicated() {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();

        List<Integer> lottoNumbers = new ArrayList<>(lottoBeingChecked.getNumbers());

        lottoNumbers.retainAll(winningNumbers);

        return lottoNumbers;
    }

    private void reflectStatistics(int numberOfDuplicated) {
        RankingInformation[] rankingInformations = RankingInformation.values();

        for (RankingInformation rank : rankingInformations) {
            if (numberOfDuplicated == rank.getNumberOfMatch()) {
                increaseCount(rank);
                break;
            }
        }
    }

    private void increaseCount(RankingInformation rank) {
        if (rank.getNumberOfMatch() == 5) {
            boolean containsBonus = checkBonusNumber();

            if (containsBonus) {
                rank = RankingInformation.SECOND_PLACE;
            }
        }

        int count = statistics.get(rank) + 1;
        statistics.put(rank, count);
    }

    private boolean checkBonusNumber() {
        int bonusNumber = winningLotto.getBonusNumber();

        boolean isContained = lottoBeingChecked.getNumbers().contains(bonusNumber);

        return isContained;
    }

    public double calculateRateOfReturn() {
        int amountOfReturn = calculateAmountOfReturn();

        double rateOfReturn = (double) amountOfReturn / (double) purchaseAmount;
        rateOfReturn = rateOfReturn * 100;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;

        return rateOfReturn;
    }

    private int calculateAmountOfReturn() {
        int amountOfReturn = 0;

        for (Map.Entry<RankingInformation, Integer> oneRank : statistics.entrySet()) {
            int returnOfRank = oneRank.getKey().getAmountOfReturn();
            int numberOfRank = oneRank.getValue();

            amountOfReturn += returnOfRank * numberOfRank;
        }

        return amountOfReturn;
    }
}
