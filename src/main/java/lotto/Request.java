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

	public void printRequestMessageByStatus(String status) {
		if(status.equals("request money")) {
			System.out.println("구입금액을 입력해 주세요.");
		}

		if(status.equals("request winning numbers")) {
			System.out.println("당첨 번호를 입력해 주세요.");
		}

		if(status.equals("request bonus number")) {
			System.out.println("보너스 번호를 입력해 주세요.");
		}
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
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
		}

		int input = Integer.parseInt(userInput);

		if(input > 100000 || input == 0) {
			throw new IllegalArgumentException("[ERROR] 소액으로 건전하게 즐기세요. 1회차 1인당 구매 한도는 10만원 입니다.");
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
			throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리 입니다.");
		}
	}

	public void isLottoNumbers() {
		String[] splitUserInput = userInput.split(",");

		for(String eachNumber : splitUserInput) {
			if(!Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", eachNumber)) {
				throw new IllegalArgumentException("[ERROR] 1에서 45 사이 숫자를 입력해 주세요.");
			}
		}
	}

	public void validateDuplication() {
		String[] splitUserInput = userInput.split(",");
		winningNumbers = new ArrayList<>();

		for(String eachNumbers : splitUserInput) {
			if(winningNumbers.contains(Integer.parseInt(eachNumbers))) {
				throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
			}

			winningNumbers.add(Integer.parseInt(eachNumbers));
		}
	}

	public void validateBonusNumber() {
		isBonusNumber();
		validateDuplicationWithWinningNumbers();
	}

	public void isBonusNumber() {
		if(!Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", userInput)) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
		}
	}

	public void validateDuplicationWithWinningNumbers() {
		if(winningNumbers.contains(Integer.parseInt(userInput))) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
		}
	}

	public String getUserInput() {
		return userInput;
	}

	public List<Integer> getWinningNumbers () {
		return winningNumbers;
	}
}
