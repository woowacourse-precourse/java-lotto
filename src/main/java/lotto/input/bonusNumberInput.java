package lotto.input;

import static lotto.util.validator.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class bonusNumberInput {
	public int bonusNumber;

	public bonusNumberInput(ArrayList<Integer> winningNumber) {
		System.out.println("1부터 45범위의 보너스번호 1개를 입력하세요.");
		bonusNumber = Integer.parseInt(Console.readLine());
		validateBonusNumber(winningNumber, bonusNumber);
	}

}
