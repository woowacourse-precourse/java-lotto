package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.Notice;

public class LottoMachine {
	private static final String LOTTO_REGEX = ",";
	private final List<Integer> winningNumbers;
	private final int bonusNumber;


	public LottoMachine(String numbers, String bonus) {
		this.winningNumbers = convertStringToList(numbers);
		this.bonusNumber = convertInteger(bonus);

		checkException(winningNumbers, bonusNumber);
	}
	public int getBonusNumber() {
		return bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	private List<Integer> convertStringToList(String numbers) {
		List<String> lotto = Arrays.asList(numbers.split(LOTTO_REGEX));
		checkWinningNumbers(lotto);

		return lotto.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private int convertInteger(String number) {
		int bonus = 0;

		if (checkBonus(number)) {
			bonus = Integer.parseInt(number);
		}

		return bonus;
	}

	private void checkWinningNumbers(List<String> lotto) {
		if (lotto.size() != 6) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "쉼표로 구분해 주세요");
		}
		for (String s : lotto) {
			if (!isNumeric(s)) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "숫자만 입력해주세요");
			}

			int num = Integer.parseInt(s);

			if (num < 0 || num > 45) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 1 ~ 45 사이의 숫자만 입력해 주세요");
			}
		}
	}
	private boolean isNumeric(String str) {
		return str.chars().allMatch(Character :: isDigit);
	}

	public boolean checkBonus(String bonus) {
		if (bonus.length() > 2) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() +"1개만 입력해 주세요.");
		}

		if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "1 ~ 45 사이의 숫자를 입력해 주세요.");
		}

		return true;
	}

	private void checkException(List<Integer> lotto, int bonus) {
		if (lotto.contains(bonus)) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "로또 번호와 다른 보너스 숫자를 입력해주세요.");
		}
	}
}
