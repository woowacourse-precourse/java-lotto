package lotto;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class Output {
	public static void output(int numberOfGame, ArrayList<Objects> userNumber, ArrayList<Integer> winningNumber, int bonusNumber) {
		quantityAndNumberOutput(numberOfGame, userNumber);
		winningResultOutput(userNumber,winningNumber,bonusNumber);
	}
	public static void quantityAndNumberOutput(int numberOfGame, ArrayList<Objects> userNumber) {
		System.out.println(numberOfGame+"개를 구매했습니다.");
		for (int i=0;userNumber.size()>i;i++){
			System.out.println(userNumber.get(i));
		}
	}
	public static void winningResultOutput(ArrayList<Objects> userNumber, ArrayList<Integer> winningNumber, int bonusNumber) {

	}

	public static String calculateResult(ArrayList<Objects> userNumber, ArrayList<Integer> winningNumber, int bonusNumber){

	}
}
