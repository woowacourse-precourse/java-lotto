package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidateUtil {
	
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
}
