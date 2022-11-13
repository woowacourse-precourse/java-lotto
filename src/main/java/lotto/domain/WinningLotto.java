package lotto.domain;

import java.util.List;

public class WinningLotto{
    private static final Integer RANK_TO_LIST = 3;
    private static final Integer MAXIMUM_RANK = 6;
    private static Lotto winningLottoNumber;
    private static Integer bonusNumber;

    public WinningLotto(Lotto winningLottoNumber, Integer bonusNumber) {
	this.winningLottoNumber = winningLottoNumber;
	this.bonusNumber = bonusNumber;
    }

    public static Integer compareWinningLotto(Lotto lottoNumbers) {
	int rank = 0;
	for (Integer lottoNumber: lottoNumbers.getLottoNumbers()) {
	    rank += isContainWinningNumber(lottoNumber);
	    rank += isContainBonusNumber(lottoNumber);
	}
	if (rank == MAXIMUM_RANK) {
	    rank += isNotContainBonusNumber(rank, lottoNumbers.getLottoNumbers());
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

    private static int isNotContainBonusNumber(int rank, List<Integer> lottoNumbers) {
	if (!lottoNumbers.contains(bonusNumber)) {
	    return 1;
	}
	return 0;
    }
}
