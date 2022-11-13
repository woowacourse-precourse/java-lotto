package lotto;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
	public static boolean isNotDigit(char source){
		return !Character.isDigit(source);
	}

	public static Long toLong(String number){
		return Long.parseLong(number);
	}

	public static List<Integer> getSplitList(String number) {
		return Arrays.stream(number.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public static boolean inRangeCheck(int num, int start, int end){
		return start <= num && start <= end;
	}

	public static boolean isCorrectSize(List<Integer> numbers, int size){
		return numbers.size() == size;
	}

}
