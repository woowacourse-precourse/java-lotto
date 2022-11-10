package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
	private final int MIN_NUMBER_BOUNDARY = 1;
	private final int MAX_NUMBER_BOUNDARY = 45;
	private final String WINNING_NUMBER_INPUT_FORMAT = "^(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2})$";
	private final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
	private final String INVALID_NUMBER_BOUNDARY = "[ERROR] 당첨번호들은 1~45의 숫자로만 구성되어야 합니다.";
	private final String OVERLAP_NUMBER = "[ERROR] 당첨번호들은 중복이 되지 않아야 합니다.";
	private List<Integer> numbers;

	public WinningNumbers(String winningNumbers) {
		validateWinningNumbersFormat(winningNumbers);
		validateWinningNumbersBoundary(winningNumbers);
		validateWinningNumbersOverlap(winningNumbers);
		this.numbers = convertStringToList(winningNumbers);
	}

	private void validateWinningNumbersFormat(String winningNumbers) {
		if (!winningNumbers.matches(WINNING_NUMBER_INPUT_FORMAT)) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT);
		}
	}

	private void validateWinningNumbersBoundary(String winningNumbers) {
		String[] convertWinningNumbers = winningNumbers.split(",");
		Arrays.stream(convertWinningNumbers)
			.forEach(number -> checkBoundary(number));
	}

	private void checkBoundary(String number) {
		int targetNumber = Integer.parseInt(number);
		if (targetNumber < MIN_NUMBER_BOUNDARY || targetNumber > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY);
		}
	}

	private void validateWinningNumbersOverlap(String winningNumbers) {
		String[] convertWinningNumbers = winningNumbers.split(",");
		Set<String> winningNumbersOverlapTester = new HashSet<>(List.of(convertWinningNumbers));
		if (winningNumbersOverlapTester.size() != convertWinningNumbers.length) {
			throw new IllegalArgumentException(OVERLAP_NUMBER);
		}
	}

	private List<Integer> convertStringToList(String winningNumbers) {
		String[] convertWinningNumbers = winningNumbers.split(",");
		return Arrays.stream(convertWinningNumbers)
			.map(number -> Integer.parseInt(number))
			.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
