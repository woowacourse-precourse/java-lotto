package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.validator.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lotto.validator.MoneyInputValidator;

public class InputView {
	private final MoneyInputValidator moneyInputValidator;
	private static final Pattern winningNumberPattern = Pattern.compile(
		"^([0-9]+),([0-9]+),([0-9]+),([0-9]+),([0-9]+),([0-9]+)$");
	private static final Pattern bonusNumberPattern = Pattern.compile("[0-9]+");

	public InputView(MoneyInputValidator moneyInputValidator) {
		this.moneyInputValidator = moneyInputValidator;
	}

	public int inputMoney() {
		String data = readLine();
		int money = 0;
		try {
			money = moneyInputValidator.runMoneyInputValidator(data);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return money;
	}

	public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
		String inputNumber = readLine();
		System.out.println("inputNumber = " + inputNumber);
		if (!winningNumberPattern.matcher(inputNumber).matches()) {
			throw new IllegalArgumentException(COMMA_CLASSIFICATION.getErrorMessage());
		}
		return inputNumbersToLottoBalls(inputNumber);
	}

	public Integer inputBonusNumber() throws IllegalArgumentException {
		String inputNumber = readLine();
		if (!bonusNumberPattern.matcher(inputNumber).matches()) {
			throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
		}
		return Integer.parseInt(inputNumber);
	}

	public List<Integer> inputNumbersToLottoBalls(String numbers) {
		List<String> inputNumbers = Arrays.asList(numbers.split(","));
		return inputNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
}
