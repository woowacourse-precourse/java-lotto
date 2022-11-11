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

	public Request() {}

	public void requestBettingMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		userInputBettingMoney = Console.readLine();
	}

	public void validateBettingMoney() {
		if(!Pattern.matches("^1?[0-9]?[0-9]+000$", userInputBettingMoney)) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
		}

		int input = Integer.parseInt(userInputBettingMoney);

		if(input > 100000 || input == 0) {
			throw new IllegalArgumentException("[ERROR] 소액으로 건전하게 즐기세요. 1회차 1인당 구매 한도는 10만원 입니다.");
		}
	}

	public String getBettingMoney() {
		return userInputBettingMoney;
	}

	public void requestWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		userInputWinningNumbers = Console.readLine();
	}

	public void validateWinningNumbers() {
		splitUserInput();
		isLottoNumbers();
		validateDuplication();
	}

	public void splitUserInput() {
		String[] splitUserInput = userInputWinningNumbers.split(",");

		if(splitUserInput.length != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리 입니다.");
		}
	}

	public void isLottoNumbers() {
		String[] splitUserInput = userInputWinningNumbers.split(",");

		for(String eachNumber : splitUserInput) {
			if(!Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", eachNumber)) {
				throw new IllegalArgumentException("[ERROR] 1에서 45 사이 숫자를 입력해 주세요.");
			}
		}
	}

	public void validateDuplication() {
		String[] splitUserInput = userInputWinningNumbers.split(",");
		winningNumbers = new ArrayList<>();

		for(String eachNumbers : splitUserInput) {
			if(winningNumbers.contains(Integer.parseInt(eachNumbers))) {
				throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
			}

			winningNumbers.add(Integer.parseInt(eachNumbers));
		}
	}

	public List<Integer> getWinningNumbers () {
		return winningNumbers;
	}

	public void requestBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		userInputBonusNumber = Console.readLine();
	}

	public void validateBonusNumber() {
		isBonusNumber();
		validateDuplicationWithWinningNumbers();
	}

	public void isBonusNumber() {
		if(!Pattern.matches("^([1-9])|([1-3][0-9])|(4[0-5])$", userInputBonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
		}
	}

	public void validateDuplicationWithWinningNumbers() {
		if(winningNumbers.contains(Integer.parseInt(userInputBonusNumber))) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
		}
	}

	public String getBonusNumber() {
		return userInputBonusNumber;
	}
}
