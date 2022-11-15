package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConsoleIn {
	public static String readLine() {
		return Console.readLine();
	}

	public static List<Integer> readGoal() {
		StringTokenizer inputLine = new StringTokenizer(readLine(), Constants.DELIMITER);
		List<Integer> goal = new ArrayList<>();
		while (inputLine.hasMoreTokens()) {
			goal.add(Util.strToInt(inputLine.nextToken()));
		}

		return goal;
	}
}
