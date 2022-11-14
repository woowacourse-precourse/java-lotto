package lotto.domain;

import java.util.List;

public class WinningLotto{
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int RANK_TO_LIST = 3;
    private static final int MAXIMUM_RANK = 6;
    private static final String ERROR_PREFIX_MASSAGE = "[ERROR] ";
    private static final String ERROR_RANGE_MASSAGE = "로또 번호는 1부터 45까지입니다.";
    private static final String ERROR_DUPLICATE_MASSAGE = "로또 번호에 중복된 숫자는 없습니다.";
    private static Lotto winningLottoNumber;
    private static Integer bonusNumber;

    public WinningLotto(Lotto winningLottoNumber, Integer bonusNumber) {
	validateBonusNumber(bonusNumber);
	validateBonusNumberDuplicate(winningLottoNumber, bonusNumber);
	this.winningLottoNumber = winningLottoNumber;
	this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
	if (bonusNumber < LOTTO_MINIMUM_NUMBER || bonusNumber > LOTTO_MAXIMUM_NUMBER) {
	    throw new IllegalArgumentException(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE);
	}
    }

    private void validateBonusNumberDuplicate(Lotto winningLottoNumber, Integer bonusNumber) {
	if (winningLottoNumber.getLottoNumbers().contains(bonusNumber)) {
	    throw new IllegalArgumentException(ERROR_PREFIX_MASSAGE + ERROR_DUPLICATE_MASSAGE);
	}
    }

    public static Integer compareWinningLotto(Lotto lottoNumbers) {
	int rank = 0;
	for (Integer lottoNumber: lottoNumbers.getLottoNumbers()) {
	    rank += isContainWinningNumber(lottoNumber);
	    rank += isContainBonusNumber(lottoNumber);
	}
	if (rank == MAXIMUM_RANK) {
	    rank += isNotContainBonusNumber(lottoNumbers.getLottoNumbers());
	}
	return rank - RANK_TO_LIST;
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
