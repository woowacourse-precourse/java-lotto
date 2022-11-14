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

}
