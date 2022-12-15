package lotto;

import lotto.calculate.calculateProfitability;
import lotto.calculate.calculateResult;
import lotto.input.bonusNumberInput;
import lotto.input.budgetInput;
import lotto.input.winningNumberInput;
import lotto.lotto.randomNumberGenerate;
import lotto.output.profitabilityOutput;
import lotto.output.quantityAndNumberOutput;
import lotto.output.winningResultOutput;
import lotto.util.sorter;

public class controller {
	static void main() {
		budgetInput numberOfGame = new budgetInput();
		randomNumberGenerate randomNumberGenerate = new randomNumberGenerate(numberOfGame.numberOfGame);
		sorter sortAnswer = new sorter(randomNumberGenerate.numbers);
		new quantityAndNumberOutput(numberOfGame.numberOfGame, randomNumberGenerate.numbers);
		winningNumberInput winningNumberInput = new winningNumberInput();
		bonusNumberInput bonusNumber = new bonusNumberInput(winningNumberInput.winningNumber);
		calculateResult calculateResult = new calculateResult(sortAnswer.answer, winningNumberInput.winningNumber,
			bonusNumber.bonusNumber);
		new winningResultOutput(calculateResult.calculateResult);
		calculateProfitability calculateProfitability = new calculateProfitability(calculateResult.calculateResult,
			sortAnswer.answer);
		new profitabilityOutput(calculateProfitability.calculateProfitability);
	}
}
