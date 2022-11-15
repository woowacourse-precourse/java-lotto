package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static int strToInt(String word) {
		try {
			return Integer.parseInt(word);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_NUMBER_FORMAT);
		}
	}

	public static List<Integer> pickUniqueNumbersInRange(int start, int end, int num) {
		return Randoms.pickUniqueNumbersInRange(start, end, num);
	}
}
