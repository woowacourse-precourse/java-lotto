package lotto.domain;

import java.util.List;

public class WinningLotto{
    private static final Integer MINIMUM_RANK = 8;
    private static Lotto winningLottoNumber;
    private static Integer bonusNumber;

    public WinningLotto(Lotto winningLottoNumber, Integer bonusNumber) {
	this.winningLottoNumber = winningLottoNumber;
	this.bonusNumber = bonusNumber;
    }

    public static Integer compareWinningLotto(Lotto lottoNumbers) {
	int rank = MINIMUM_RANK;
	for (Integer lottoNumber: lottoNumbers.getLottoNumbers()) {
	    rank -= isContainWinningNumber(lottoNumber);
	}
	rank -= isNotContainBonusNumber(rank, lottoNumbers.getLottoNumbers());
	return rank;
    }

    private static int isContainWinningNumber(Integer lottoNumber) {
	if (winningLottoNumber.getLottoNumbers().contains(lottoNumber)) {
	    return 1;
	}
	if (lottoNumber == bonusNumber) {
	    return 1;
	}
	return 0;
    }

    private static int isNotContainBonusNumber(int rank, List<Integer> lottoNumbers) {
	if (rank != 2) {
	    return 0;
	}
	if (!lottoNumbers.contains(bonusNumber)) {
	    return 1;
	}
	return 0;
    }
}
