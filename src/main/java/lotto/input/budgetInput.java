package lotto.input;

import static lotto.util.validator.*;

import camp.nextstep.edu.missionutils.Console;

public class budgetInput {
	private static final String ERROR_MESSAGE = "[ERROR]";
	public int numberOfGame;
	public budgetInput(){
		try {
			System.out.println("예산을 입력하세요");
			int budget = Integer.parseInt(Console.readLine());
			validateBudget(budget);
			this.numberOfGame = budget / 1000;
		}catch (NumberFormatException e){
			System.out.println(ERROR_MESSAGE);
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}
}
