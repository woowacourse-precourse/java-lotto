package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Request {

	private String userInput;
	private List<Integer> winningNumbers;

	public Request() {}

	public void requestUserInput() {
		userInput = Console.readLine();
	}

	public void validateByStatus(String status) {
		if(status.equals("request money")) {
			validateMoney();
		}

		if(status.equals("request winning numbers")) {
			validateWinningNumbers();
		}

		if(status.equals("request bonus number")) {
			validateBonusNumber();
		}
	}

	public void validateMoney() {
		if(!Pattern.matches("^1?[0-9]?[0-9]+000$", userInput)) {
			throw new IllegalArgumentException();
		}

		int input = Integer.parseInt(userInput);

		if(input > 100000 || input == 0) {
			throw new IllegalArgumentException();
		}
	}

	public void validateWinningNumbers() {
		splitUserInput();
		isLottoNumbers();
		validateDuplication();
	}

	public void splitUserInput() {
		String[] splitUserInput = userInput.split(",");

		if(splitUserInput.length != 6) {
			throw new IllegalArgumentException();
		}
	}

	public void isLottoNumbers() {
		String[] splitUserInput = userInput.split(",");

		for(String eachNumber : splitUserInput) {
			if(Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", eachNumber)) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void validateDuplication() {
		String[] splitUserInput = userInput.split(",");
		winningNumbers = new ArrayList<>();

		for(String eachNumbers : splitUserInput) {
			if(winningNumbers.contains(Integer.parseInt(eachNumbers))) {
				throw new IllegalArgumentException();
			}

			winningNumbers.add(Integer.parseInt(eachNumbers));
		}
	}

	public void validateBonusNumber() {
		isBonusNumber();
		validateDuplicationWithWinningNumbers();
	}

	public void isBonusNumber() {
		if(Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", userInput)) {
			throw new IllegalArgumentException();
		}
	}

	public void validateDuplicationWithWinningNumbers() {
		if(winningNumbers.contains(Integer.parseInt(userInput))) {
			throw new IllegalArgumentException();
		}
	}
}
