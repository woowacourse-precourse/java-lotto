package lotto.domain;

import java.util.HashSet;
import java.util.List;

import lotto.lottoConstant.Constant;
import lotto.lottoConstant.errorMessage.WinningNumberError;

public class WinningNumber {
	private final List<Integer> winningNumber;

	public WinningNumber(List<Integer> winNumbers) {
		validWinningNumber(winNumbers);
		this.winningNumber = winNumbers;
	}

	public LottoRanking calculateMatchCount(Lotto lotto, int bonusNumber) {
		int cnt = lotto.calculateSameNumber(winningNumber);
		return LottoRanking.findLottoRank(cnt, winningNumber.contains(bonusNumber));
	}

	private void validWinningNumber(List<Integer> winningNumber) {
		if (isWrongRangeNumber(winningNumber) || isWrongSize(winningNumber) || isDuplicateNumber(winningNumber)) {
			throw new IllegalArgumentException(WinningNumberError.VALID_WIN_NUMBER_ERROR_MESSAGE);
		}
	}

	private boolean isDuplicateNumber(List<Integer> winNumbers) {
		return new HashSet<>(winNumbers).size() != Constant.LOTTO_SIZE;
	}

	private boolean isWrongRangeNumber(List<Integer> winNumbers) {
		return !winNumbers.stream().allMatch(num -> Constant.MIN_VALUE <= num && num <= Constant.MAX_VALUE);
	}

	private boolean isWrongSize(List<Integer> winNumbers) {
		return winNumbers.size() != Constant.LOTTO_SIZE;
	}

	public List<Integer> getWinningNumber() {
		return winningNumber;
	}
}
