package lotto.input;

import static lotto.util.validator.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class winningNumberInput {
	public ArrayList<Integer> winningNumber;

	public winningNumberInput() {
		System.out.println("1부터 45범위의 당첨번호 6개를 ,단위로 입력해주세요");
		String userInput = Console.readLine();
		String[] array = userInput.split(",");
		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0; array.length > i; i++) {
			input.add(Integer.valueOf(array[i]));
		}
		validateWinningNumber(input);
		this.winningNumber = input;
	}
}
