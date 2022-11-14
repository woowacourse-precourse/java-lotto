package lotto.domain;

import java.util.List;

public class WinningLotto{
    private static Lotto winningLottoNumber;
    private static Integer bonusNumber;

    public WinningLotto(Lotto winningLottoNumber, Integer bonusNumber) {
	validateBonusNumber(bonusNumber);
	validateBonusNumberDuplicate(winningLottoNumber, bonusNumber);
	this.winningLottoNumber = winningLottoNumber;
	this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
	if (bonusNumber < LottoNumberRule.LOTTO_MINIMUM_NUMBER.getValue()
	    || bonusNumber > LottoNumberRule.LOTTO_MAXIMUM_NUMBER.getValue()) {
	    throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getValue());
	}
    }

    private void validateBonusNumberDuplicate(Lotto winningLottoNumber, Integer bonusNumber) {
	if (winningLottoNumber.getLottoNumbers().contains(bonusNumber)) {
	    throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_DUPLICATE.getValue());
	}
    }

    public static Integer compareWinningLotto(Lotto lottoNumbers) {
	int matchScore = 0;
	for (Integer lottoNumber: lottoNumbers.getLottoNumbers()) {
	    matchScore += isContainWinningNumber(lottoNumber);
	    matchScore += isContainBonusNumber(lottoNumber);
	}
	if (matchScore == LottoNumberRule.MAXIMUM_NUMBER_MATCH.getValue()) {
	    matchScore += isNotContainBonusNumber(lottoNumbers.getLottoNumbers());
	}
	return matchScore;
    }

    private static int isContainWinningNumber(Integer lottoNumber) {
	if (winningLottoNumber.getLottoNumbers().contains(lottoNumber)) {
	    return 1;
	}
	return 0;
    }

    private static int isContainBonusNumber(Integer lottoNumber) {
	if (lottoNumber == bonusNumber) {
	    return 1;
	}
	return 0;
    }

    private static int isNotContainBonusNumber(List<Integer> lottoNumbers) {
	if (!lottoNumbers.contains(bonusNumber)) {
	    return 1;
	}
	return 0;
    }
}
