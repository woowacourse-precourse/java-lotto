package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Notice;

public class LottoMachine {
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;

		checkException();
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}


	/*
	예외 처리
	 */
	private void checkException() {
		checkWinningNumbers(winningNumbers);
		checkNumberRange(bonusNumber);

		checkDuplication(winningNumbers);
		checkBonusDuplication(winningNumbers, bonusNumber);
	}

	private void checkWinningNumbers(List<Integer> lotto) {
		if (lotto.size() != 6) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 6자리의 숫자를 입력해주세요.");
		}

		for (Integer integer : lotto) {
			checkNumberRange(integer);
		}
	}

	public void checkNumberRange(int number) {
		int LOTTO_MIN = 1;
		int LOTTO_MAX = 45;
		if (number< LOTTO_MIN || number > LOTTO_MAX) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 1 ~ 45 사이의 숫자를 입력해 주세요.");
		}
	}

	private void checkBonusDuplication(List<Integer> lotto, int bonus) {
		if (lotto.contains(bonus)) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 로또 번호와 다른 보너스 숫자를 입력해주세요.");
		}
	}

	private void checkDuplication(List<Integer> lotto) {
		List<Integer> check = new ArrayList<>();

		check.add(lotto.get(0));
		for (int i = 0; i < lotto.size(); i++) {
			if (i != 0 && check.contains(lotto.get(i))) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 중복된 숫자가 있습니다.");
			}
			if (i != 0)
				check.add(lotto.get(i));
		}
	}
}
