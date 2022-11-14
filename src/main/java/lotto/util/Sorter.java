package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
	public static List<Integer> sortIntegerList(List<Integer> list) {
		List<Integer> newList = new ArrayList<>(list);
		Collections.sort(newList);
		return newList;
	}
}
