package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private static final Integer MINIMUM_RANK = 8;
    private static List<Integer> lottoNumbers;
    private static Integer bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
	super(lottoNumbers);
	this.bonusNumber = bonusNumber;
    }

    public static Integer prepareWinningLotto(Lotto lottoNumbers) {
	int rank = MINIMUM_RANK;
	for (Integer lottoNumber: lottoNumbers.getLottoNumbers()) {
	    rank -= isContainWinningNumber(lottoNumber);
	}
	rank -= isNotContainBonusNumber(rank, lottoNumbers.getLottoNumbers());
	return rank;
    }

    private static int isContainWinningNumber(Integer lottoNumber) {
	if (lottoNumbers.contains(lottoNumber)) {
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
