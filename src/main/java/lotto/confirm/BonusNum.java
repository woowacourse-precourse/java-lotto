package confirm;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BonusNum {
	public static List<Integer> run(List<Integer> winNums) {
		List<Integer> answer = winNums;
		int bonusNum = Integer.parseInt(Console.readLine());
		answer.set(6, bonusNum);
		return answer;
	}
}
