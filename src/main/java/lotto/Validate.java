package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Validate {

	public static String error = Message.ERROR.getMessage();

	public static void checkValidWinningNumbers(List<Integer> lottoNumbers){
		if (isInValidSize(lottoNumbers)) errorThrow(Message.INVALID_AMOUNT_NUMBER.getMessage());
		if (isDuplicated(lottoNumbers)) errorThrow(Message.DUPLICATED_NUMBER.getMessage());
		if (isOutOfRange(lottoNumbers)) errorThrow(Message.OUT_OF_RANGE.getMessage());
	}

	public static boolean isInValidSize(List<Integer> numbers) {
		return numbers.size() != Constant.NUMBER_OF_NUMBERS.getNumber();
	}

	public static boolean isDuplicated(List<Integer> numbers){
		Set<Integer> numbersSet = new TreeSet<>(numbers);
		return numbers.size() != numbersSet.size();
	}

	public static boolean isOutOfRange(List<Integer> numbers){
		for (int number: numbers){
			if (number < Constant.MIN_VALUE.getNumber() || number > Constant.MAX_VALUE.getNumber()){
				return true;
			}
		}
		return false;
	}

	public static void errorThrow(String message){
		throw new IllegalArgumentException(error + message);
	}

	public static void checkValidMoney(String money){
		if (isNotNumeric(money)) errorThrow(Message.NOT_NUMERIC.getMessage());
		if (isNotEnough(money)) errorThrow(Message.NOT_ENOUGH_MONEY.getMessage());
		if (isNotDivisible(money)) errorThrow(Message.NOT_DIVISIBLE_MONEY.getMessage());
	}

	public static boolean isNotNumeric(String money){
		return !money
			.chars()
			.allMatch(Character::isDigit);
	}

	public static boolean isNotEnough(String money){
		return Integer.parseInt(money) < Constant.LOTTO_PRICE.getNumber();
	}

	public static boolean isNotDivisible(String money){
		return Integer.parseInt(money) % Constant.LOTTO_PRICE.getNumber() > 0;
	}

	public static void initialInputCheck(String winningNumbers) {
		if (isNotConsistNumeric(winningNumbers)) errorThrow(Message.NOT_NUMERIC.getMessage());
	}

	public static boolean isNotConsistNumeric(String winningNumbers) {
		String[] numbers = winningNumbers.split(",");
		for (String number: numbers){
			if (!number.chars().allMatch(Character::isDigit)){
				return true;
			}
		}
		return false;
	}

	public static void checkBonusNumber(String bonusNumber, List<Integer> numbers) {
		if (isNotNumeric(bonusNumber)) errorThrow(Message.NOT_NUMERIC.getMessage());
		if (isInvalidSize(bonusNumber)) errorThrow(Message.INVALID_BONUS_AMOUNT.getMessage());
		if (isOutOfRange(bonusNumber)) errorThrow(Message.OUT_OF_RANGE.getMessage());
		if (isDuplicated(bonusNumber, numbers)) errorThrow(Message.DUPLICATED_NUMBER.getMessage());
	}

	public static boolean isOutOfRange(String bonusNumber){
		return Integer.parseInt(bonusNumber) < Constant.MIN_VALUE.getNumber()
			|| Integer.parseInt(bonusNumber) > Constant.MAX_VALUE.getNumber();
	}

	public static boolean isDuplicated(String bonusNumber, List<Integer> numbers) {
		return numbers.contains(Integer.parseInt(bonusNumber));
	}

	public static boolean isInvalidSize(String bonusNumber){
		String[] numbers = bonusNumber.split(",");
		return numbers.length != Constant.NUMBER_OF_BONUS_NUMBER.getNumber();
	}
}
