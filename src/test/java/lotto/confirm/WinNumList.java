package confirm;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class WinNumList {
	public static List<Integer> run(){
		List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0);
		String[] numList = Console.readLine().split(",");
		for (int i = 0; i<6; i++) {
			answer.set(i, Integer.parseInt(numList[i]));
		}

		return answer;
	}
}
