package confirm;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BonusNum {
	public static List<Integer> run(List<Integer> winNums) {
		int bonusNum = Integer.parseInt(Console.readLine());
		winNums.set(7, bonusNum);
		return winNums;
	}
}
