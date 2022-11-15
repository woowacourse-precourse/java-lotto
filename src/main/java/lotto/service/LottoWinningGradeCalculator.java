package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public class LottoWinningGradeCalculator {

    public LottoGrade getLottoGrade(List<Integer> userNumberGroup, Lotto lotto) {
        List<Integer> lottoWinningNumber = lotto.getLottoNumber();
        Integer lottoBonusNumber = lotto.getLottoBonusNumber();

        Integer mainCheckCount = getMainCheckCount(userNumberGroup, lottoWinningNumber);
        Integer bonusCheckCount = getBonusCheckCount(userNumberGroup, lottoBonusNumber);

        return getLottoGradeByMainBonusCount(mainCheckCount, bonusCheckCount);
    }

    private Integer getMainCheckCount(List<Integer> userNumberGroup,
            List<Integer> lottoMainNumber) {
        Integer mainCheckCount = 0;
        for (Integer userNumber : userNumberGroup) {
            if (lottoMainNumber.contains(userNumber)) {
                mainCheckCount++;
            }
        }

        return mainCheckCount;
    }

    private Integer getBonusCheckCount(List<Integer> userNumberGroup, Integer winningBonusNumber) {
        if (userNumberGroup.contains(winningBonusNumber)) {
            return 1;
        }
        return 0;
    }

    private LottoGrade getLottoGradeByMainBonusCount(Integer mainCheckCount,
            Integer bonusCheckCount) {
        if (mainCheckCount == 6) {
            return LottoGrade.FIRST;
        }
        if (mainCheckCount == 5 && bonusCheckCount == 1) {
            return LottoGrade.SECOND;
        }
        if (mainCheckCount == 5 && bonusCheckCount == 0) {
            return LottoGrade.THIRD;
        }
        if (mainCheckCount == 4) {
            return LottoGrade.FOURTH;
        }
        if (mainCheckCount == 3) {
            return LottoGrade.FIFTH;
        }
        return LottoGrade.DEFAULT;
    }
}
