package lotto;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class Output {
	public static void output(int numberOfGame, ArrayList userNumber, ArrayList winningNumber, int bonusNumber) {
		outputQuantityAndNumber(numberOfGame, userNumber);
	}
	public static void outputQuantityAndNumber(int numberOfGame, ArrayList userNumber) {
		System.out.println(numberOfGame+"개를 구매했습니다.");
		for (int i=0;userNumber.size()>i;i++){
			System.out.println(userNumber.get(i));
		}
	}
}
