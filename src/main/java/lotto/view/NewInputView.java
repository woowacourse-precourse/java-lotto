package lotto.view;

import static lotto.constant.Constants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.system.Validator;

public class NewInputView {

	public List<Integer> winNumbers;
	public int bonusNumber;
	public int money;

	public void getWinNumbers() {
		System.out.println(WIN_INPUT_MESSAGE);
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
		System.out.println(BONUS_INPUT_MESSAGE);
		String inputNumber = Console.readLine();
		Validator.isDuplicate(winNumbers, inputNumber);
		Validator.isInRange(inputNumber);
		try {
			bonusNumber = Integer.parseInt(inputNumber);
		} catch (Exception exception) {
			System.out.println(INVALID_INPUT);
			throw new NoSuchElementException(INVALID_INPUT);
			//throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public void getMoney() {
		System.out.println(MONEY_INPUT_MESSAGE);
		String inputNumber = Console.readLine();
		String[] test = inputNumber.split("");
		try {
			money = Integer.parseInt(inputNumber);
			Validator.isMoneyValidate(money);
			Validator.isOnlyNumber(test);
		} catch (Exception exception) {
			System.out.println(INVALID_INPUT);
			throw new NoSuchElementException(INVALID_INPUT);
			// throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

}
