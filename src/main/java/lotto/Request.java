package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Request {

	private String userInputBettingMoney;
	private String userInputWinningNumbers;
	private String userInputBonusNumber;
	private List<Integer> winningNumbers;

	public Request() {
	}

	public void requestBettingMoney() {
		System.out.println(EnumRequestMessage.BET.getValue());
		setUserInputBettingMoney(Console.readLine());
	}

	public void validateBettingMoney() {
		if (!Pattern.matches(EnumPatterns.BET.getValue(), userInputBettingMoney)) {
			throw new IllegalArgumentException(EnumError.INVALID_INPUT.getValue());
		}

		int input = Integer.parseInt(userInputBettingMoney);

		if (input > EnumNumeric.BET_LIMIT_EXCESS.getValue() || input <= EnumNumeric.BET_OVER_FLOW.getValue()) {
			throw new IllegalArgumentException(EnumError.LIMIT_EXCESS.getValue());
		}
	}

	public void setUserInputBettingMoney(String userInputBettingMoney) {
		this.userInputBettingMoney = userInputBettingMoney;
	}

	public String getBettingMoney() {
		return userInputBettingMoney;
	}

	public void requestWinningNumbers() {
		System.out.println(EnumRequestMessage.WINNING_NUMBERS.getValue());
		setUserInputWinningNumbers(Console.readLine());
	}

	public void validateWinningNumbers() {
		splitUserInput();
		isLottoNumbers();
		validateDuplication();
	}

	public void splitUserInput() {
		String[] splitUserInput = userInputWinningNumbers.split(EnumPatterns.SPLITTER.getValue());

		if (splitUserInput.length != EnumNumeric.LOTTO_NUMBERS_BOUND.getValue()) {
			throw new IllegalArgumentException(EnumError.DIGIT_MISMATCH.getValue());
		}
	}

	public void isLottoNumbers() {
		String[] splitUserInput = userInputWinningNumbers.split(EnumPatterns.SPLITTER.getValue());

		for (String eachNumber : splitUserInput) {
			if (!Pattern.matches(EnumPatterns.WINNING_NUMBERS.getValue(), eachNumber)) {
				throw new IllegalArgumentException(EnumError.OUT_OF_BOUNDS.getValue());
			}
		}
	}

	public void validateDuplication() {
		String[] splitUserInput = userInputWinningNumbers.split(EnumPatterns.SPLITTER.getValue());
		winningNumbers = new ArrayList<>();

		for (String eachNumbers : splitUserInput) {
			if (winningNumbers.contains(Integer.parseInt(eachNumbers))) {
				throw new IllegalArgumentException(EnumError.DUPLICATED.getValue());
			}

			winningNumbers.add(Integer.parseInt(eachNumbers));
		}
	}

	public void setUserInputWinningNumbers(String userInputWinningNumbers) {
		this.userInputWinningNumbers = userInputWinningNumbers;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public void requestBonusNumber() {
		System.out.println(EnumRequestMessage.BONUS_NUMBER.getValue());
		setUserInputBonusNumber(Console.readLine());
	}

	public void validateBonusNumber() {
		isBonusNumber();
		validateDuplicationWithWinningNumbers();
	}

	public void isBonusNumber() {
		if (!Pattern.matches(EnumPatterns.BONUS_NUMBER.getValue(), userInputBonusNumber)) {
			throw new IllegalArgumentException(EnumError.INVALID_INPUT.getValue());
		}
	}

	public void validateDuplicationWithWinningNumbers() {
		if (winningNumbers.contains(Integer.parseInt(userInputBonusNumber))) {
			throw new IllegalArgumentException(EnumError.DUPLICATED.getValue());
		}
	}

	public  void setUserInputBonusNumber(String userInputBonusNumber) {
		this.userInputBonusNumber = userInputBonusNumber;
	}

	public String getBonusNumber() {
		return userInputBonusNumber;
	}
}
