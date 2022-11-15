package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TypeConversion {
	public static int toInt(String str) {
		return java.lang.Integer.valueOf(str);
	}

	public static List<Integer> getSortedIntegers(List<Integer> numbers) {
		List<Integer> changeableNumbers = new ArrayList<>(numbers);
		Collections.sort(changeableNumbers);
		return changeableNumbers;
	}

	public static List<Integer> stringListToIntegerList(List<String> strings) {
		List<Integer> integers = new ArrayList<>();
		for (String string : strings) {
			integers.add(Integer.valueOf(string));
		}
		return integers;
	}

	public static List<String> stringsToList(String[] strings) {
		List<String> list = new ArrayList<>();
		for (String string : strings) {
			list.add(string);
		}
		return list;
	}
}
