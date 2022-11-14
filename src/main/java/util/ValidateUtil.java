package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import dto.Lotto;

public class ValidateUtil {
	
	
	final private static int start = 1;
	final private static int end = 45;
	
	
	public static boolean isNumber(String inputValue){
		return Pattern.matches("^[0-9]*$", inputValue);
	}

	public static boolean isMultipleOf1000(String inputValue) {
		return Integer.parseInt(inputValue)%1000 == 0;
	}

	public static boolean checkUniqueNumber(List<Integer> numbers) {
		Set<Integer> chcekNumber = new HashSet<>(numbers);
		return numbers.size() == chcekNumber.size();
	}

	@SuppressWarnings("rawtypes")
	public static boolean checkListSize(List numbers, int i) {
		return numbers.size() == i;
	}

	public static boolean checkListRange(List<Integer> winnigNumber) {
		
		boolean result = true;
		for(Integer number :  winnigNumber) {
			if(!checkRange(number)) {
				result = false;
			}
		}
		return result;
	}
	
	public static boolean checkRange(int number) {
		
		if(start <= number && number <= end ) {
			return true;
		}
		return false;
	}

	public static boolean checkDuplicates(Lotto winningNumber, int bonusNumber) {
		return winningNumber.getNumbers().contains(bonusNumber);
	}
}
