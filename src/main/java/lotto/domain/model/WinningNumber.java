package lotto.domain.model;

import lotto.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumber {
	private final List<Integer> winningNumbers;

	public WinningNumber(String winningNumbers) {
		validateLastCharacter(winningNumbers);
		this.winningNumbers = initWinningNumbers(winningNumbers);
		validateCount(this.winningNumbers);
		validateRange(this.winningNumbers);
		validateOverlap(this.winningNumbers);
	}

	private void validateLastCharacter(String winningNumbers) {
		if (winningNumbers.charAt(winningNumbers.length() - 1) == ',') {
			System.out.println(ErrorMessage.ERROR_WRONG_INPUT.getError_message());
			throw new IllegalArgumentException("마지막 문자 쉼표");
		}
	}

	private void validateOverlap(List<Integer> winningNumbers) {
		HashSet<Integer> numberSet = new HashSet<>(winningNumbers);

		if (numberSet.size() != winningNumbers.size()) {
			System.out.println(ErrorMessage.ERROR_OVERLAP.getError_message());
			throw new IllegalArgumentException("중복 값");
		}
	}

	private List<Integer> initWinningNumbers(String input) {
		String[] numbers = input.split(",");
		System.out.println(numbers.length);
		List<Integer> winningNumber = new ArrayList<>();
		for (String number : numbers) {
			winningNumber.add(validateInt(number));
		}
		return winningNumber;
	}

	private int validateInt(String input) {
		int number;

		try {
			number = Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(ErrorMessage.ERROR_NOT_INTEGER.getError_message());
			throw new IllegalArgumentException("정수 값을 입력하세요");
		}

		return number;
	}

	private void validateCount(List<Integer> winning_numbers) {
		if (winning_numbers.size() != 6) {
			System.out.println(ErrorMessage.ERROR_WRONG_SIZE.getError_message());
			throw new IllegalArgumentException("6개 아님");
		}
	}

	private void validateRange(List<Integer> winning_numbers) {
		for (int number : winning_numbers) {
			if (number < 1 || 45 < number) {
				System.out.println(ErrorMessage.ERROR_WRONG_RANGE.getError_message());
				throw new IllegalArgumentException("잘못된 범위");
			}
		}
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}
}
