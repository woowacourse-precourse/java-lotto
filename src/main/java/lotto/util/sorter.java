package lotto.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class sorter {
	public ArrayList<List<Integer>> answer;

	public sorter(ArrayList<List<Integer>> answer) {
		for (int i = 0; answer.size() > i; i++) {
			answer.get(i).sort(Comparator.naturalOrder());
		}
		this.answer = answer;
	}
}
