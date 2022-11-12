package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

	private final String WINNING_NUMBER_INPUT_FORMAT = "^(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2})$";
	private final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 당첨번호들은 1~45 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
	private final String INVALID_NUMBER_BOUNDARY = "[ERROR] 당첨번호는 1~45의 숫자로만 구성되어야 합니다.";
	private final String INVALID_FIRST_NUMBER = "[ERROR] 두자리 숫자인 당첨번호의 첫번째 자리는 0이 올 수 없습니다.";
	private final String OVERLAP_NUMBER = "[ERROR] 당첨번호들은 중복이 되지 않아야 합니다.";
	private final char FIRST_NUMBER_ZERO = '0';
	private final int MIN_NUMBER_BOUNDARY = 1;
	private final int MAX_NUMBER_BOUNDARY = 45;
	private final int DOUBLE_DIGIT_NUMBER = 2;
	private List<Integer> numbers;

	public WinningNumbers(String winningNumbers) {
		validateWinningNumbersFormat(winningNumbers);
		validateWinningNumberBoundary(winningNumbers);
		validateWinningNumbersOverlap(winningNumbers);
		this.numbers = toList(winningNumbers);
	}

	private void validateWinningNumbersFormat(String winningNumbers) {
		if (!winningNumbers.matches(WINNING_NUMBER_INPUT_FORMAT)) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT);
		}
	}

	private void validateWinningNumberBoundary(String winningNumbers) {
		String[] convertedWinningNumbers = winningNumbers.split(",");
		Arrays.stream(convertedWinningNumbers)
			.forEach(number -> checkNumberBoundary(number));

		Arrays.stream(convertedWinningNumbers)
			.forEach(number -> checkFirstNumberZero(number));
	}

	private void checkNumberBoundary(String number) {
		int winningNumber = Integer.parseInt(number);
		if (winningNumber < MIN_NUMBER_BOUNDARY || winningNumber > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY);
		}
	}

	private void checkFirstNumberZero(String number) {
		if (number.length() == DOUBLE_DIGIT_NUMBER && number.charAt(0) == FIRST_NUMBER_ZERO) {
			throw new IllegalArgumentException(INVALID_FIRST_NUMBER);
		}
	}


	private void validateWinningNumbersOverlap(String winningNumbers) {
		String[] convertedWinningNumbers = winningNumbers.split(",");
		Set<String> winningNumbersOverlapTester = new HashSet<>(List.of(convertedWinningNumbers));
		if (winningNumbersOverlapTester.size() != convertedWinningNumbers.length) {
			throw new IllegalArgumentException(OVERLAP_NUMBER);
		}
	}

	private List<Integer> toList(String winningNumbers) {
		String[] convertedWinningNumbers = winningNumbers.split(",");
		return Arrays.stream(convertedWinningNumbers)
			.map(number -> Integer.parseInt(number))
			.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
