package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		int numberOfGame = Input.budgetInput();
		ArrayList<List<Integer>> userNumber = Lotto.randomNumberGenerate(numberOfGame);
		ArrayList<Integer> winningNumber = Input.winningNumberInput();
		int bonusNumber = Input.bonusNumberInput(winningNumber);
		Output.output(numberOfGame, userNumber, winningNumber, bonusNumber);
	}
}
