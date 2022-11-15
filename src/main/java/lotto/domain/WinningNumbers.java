package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers extends Number {

	private final String WINNING_NUMBER_INPUT_FORMAT = "^(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2}),(\\d{1,2})$";
	private final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
	private final String OVERLAP_NUMBER = "[ERROR] 당첨번호들을 중복없이 입력해 주시기 바랍니다.";

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
			.forEach(number -> validateNumberBoundary(number));

		Arrays.stream(convertedWinningNumbers)
			.forEach(number -> validateFirstNumberZero(number));
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
