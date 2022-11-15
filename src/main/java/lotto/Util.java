package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static int strToInt(String word) {
		int result = -1;
		try {
			result = Integer.parseInt(word);
		} catch (NumberFormatException e) {
			Verify.illegalArgumentException(Constants.ERROR_NOT_NUMBER_FORMAT);
		}

		return result;
	}

	public static List<Integer> pickUniqueNumbersInRange(int start, int end, int num) {
		return Randoms.pickUniqueNumbersInRange(start, end, num);
	}
}
