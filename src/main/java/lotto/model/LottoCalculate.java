package lotto.model;

import static lotto.model.LottoInformation.convertPrizeNumberToLottoInfo;

import java.util.Collection;
import java.util.List;

public class LottoCalculate {

    int checkMatches(Collection<Integer> lottoNumbers, List<Integer> winNumbers) {
        int matchCount = 0;
        for (Integer winNumber : winNumbers) {
            if (lottoNumbers.contains(winNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    int calculatePrize(int matchCount, boolean checkBonusNumber) {
        if (matchCount == 6) {
            return 1;
        } else if (matchCount == 5 & checkBonusNumber) {
            return 2;
        } else if (matchCount == 5) {
            return 3;
        } else if (matchCount == 4) {
            return 4;
        } else if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    void calculateOverall(Lotto lotto, LottoData lottoData) {
        int matchCount = checkMatches(lotto.getNumbers(), lottoData.winNumbers);
        boolean matchBonusNumber = checkBonusNumber(lotto.getNumbers(), lottoData.bonusNumber);
        int prizeNumber = calculatePrize(matchCount, matchBonusNumber);
        LottoInformation lottoInformation = convertPrizeNumberToLottoInfo.get(prizeNumber);
        lottoData.prizeCount.addPrizeCount(lottoInformation.prizeNumber);
        lottoData.prizeMoneySum += lottoInformation.prizeMoney;
    }

    void calculatePercentageOfReturn(LottoData lottoData) {
        lottoData.percentageOfReturn = Math.round(lottoData.prizeMoneySum / lottoData.money * 1000) / 10.0f;
    }
}
