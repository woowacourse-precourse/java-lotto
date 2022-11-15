package lotto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class Exception {

	public static void UserContainExceptNumber(String stringLottoMoney) throws NoSuchElementException {
		for (int i = 0; i < stringLottoMoney.length(); i++) {
			char oneNumber = stringLottoMoney.charAt(i);
			if (!Character.isDigit(oneNumber)) {
				System.out.println("[ERROR]");
				throw new NoSuchElementException();
			}
		}
	}

	public static void UserMoneyDivide1000(Integer lottoMoney) throws IllegalArgumentException {

		if (lottoMoney % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 입력받은 구입금액은 천원 단위만 가능합니다.");
		}
	}

	public static void validateLottoLength(String[] stringWinningNumbers) {
		if (stringWinningNumbers.length != 6) {
			throw new IllegalArgumentException("[ERROR] 입력한 숫자가 6개가 아닙니다.");
		}
	}

	public static void validateLottoNumberRange(String[] stringWinningNumbers) {
		for (String number : stringWinningNumbers) {
			if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
				throw new IllegalArgumentException("[ERROR] 입력 가능한 숫자의 범위는 1~45까지입니다");
			}
		}
	}

	public static void validateLottoNumberRange(String number) {
		if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
			throw new IllegalArgumentException("[ERROR] 입력 가능한 숫자의 범위는 1~45까지입니다");
		}
	}

	public static void validateDuplicateNumbers(String[] stringWinningNumbers) {
		List<String> checkDuplicate = new ArrayList<>();
		for (String number : stringWinningNumbers) {
			if (checkDuplicate.contains(number)) {
				throw new IllegalArgumentException("[ERROR] 로또번호는 중복되지 않게 입력해주세요");
			}
			checkDuplicate.add(number);
		}
	}

	public static void validateDuplicateNumbers(Lotto winningLotto, String inputBonusNumber) {
		List<Integer> checkDuplicate = winningLotto.getNumbers();
		Integer bonusNumber = Integer.parseInt(inputBonusNumber);

		if (checkDuplicate.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해주세요");
		}
	}

	public static void validateNumber(String inputBonusNumber) {
		for (int i = 0; i < inputBonusNumber.length(); i++) {
			char oneNumber = inputBonusNumber.charAt(i);
			if (!Character.isDigit(oneNumber)) {
				System.out.println("[ERROR]");
				throw new IllegalArgumentException();
			}
		}
	}
}
