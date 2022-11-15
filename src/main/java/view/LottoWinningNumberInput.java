package view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoWinningNumberInput {

	private static final String LOTTO_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

	public List<Integer> readLottoWinningNumber() {
		System.out.println(LOTTO_INPUT_WINNING_NUMBERS);
		String winningNumberInput = Console.readLine();
		System.out.println();

		List<Integer> winningNumbers = new ArrayList<>();
		for (String winningNumber : winningNumberInput.split(",")) {
			winningNumbers.add(Integer.parseInt(winningNumber));
		}
		return winningNumbers;
	}
}