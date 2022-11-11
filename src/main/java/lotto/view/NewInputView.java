package lotto.view;

import static lotto.constant.Constants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.system.Validator;

public class NewInputView {

	public List<Integer> winNumbers;
	public int bonusNumber;
	public int money;

	public void getWinNumbers() {
		String[] inputNumbers = readNumbers();
		for (String inputNumber : inputNumbers) {
			Validator.isInRange(inputNumber);
		}
		winNumbers = convertIntoIntegerList(inputNumbers);
		Validator.isSizeValidate(winNumbers);
		Collections.sort(winNumbers);
	}

	public String[] readNumbers() {
		String[] separatedNumbers = Console.readLine().split(NUMBER_DELIMITER);
		return separatedNumbers;
	}

	public List<Integer> convertIntoIntegerList(String[] strings) {
		return Arrays.stream(strings).
			map(string -> Integer.parseInt(string))
			.collect(Collectors.toList());
	}

	public void getBonusNumber() {
		String inputNumber = Console.readLine();
		Validator.isDuplicate(winNumbers, inputNumber);
		Validator.isInRange(inputNumber);
		try {
			bonusNumber = Integer.parseInt(inputNumber);
		} catch (Exception exception) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public void getMoney() {
		String inputNumber = Console.readLine();
		try {
			money = Integer.parseInt(inputNumber);
		} catch (Exception exception) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

}
