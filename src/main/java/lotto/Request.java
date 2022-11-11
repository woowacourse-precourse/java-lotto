package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Request {

	private String userInput;

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
}
