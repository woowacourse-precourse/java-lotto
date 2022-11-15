package lotto.output;

import java.util.ArrayList;
import java.util.List;

public class quantityAndNumberOutput {
	public quantityAndNumberOutput(int numberOfGame, ArrayList<List<Integer>> userNumber) {
		System.out.println(numberOfGame + "개를 구매했습니다.");
		for (int i = 0; userNumber.size() > i; i++) {
			System.out.println(userNumber.get(i));
		}
	}
}
