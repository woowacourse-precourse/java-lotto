package lotto.input;

import static lotto.util.validator.*;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.errorMessage;

public class budgetInput {
	public int numberOfGame;
	public budgetInput(){
		try {
			System.out.println("예산을 입력하세요");
			int budget = Integer.parseInt(Console.readLine());
			validateBudget(budget);
			this.numberOfGame = budget / 1000;
		}catch (NumberFormatException e){
			System.out.println(errorMessage.ONLY_INPUT_INTEGER.getValue());
			throw new NoSuchElementException(errorMessage.ONLY_INPUT_INTEGER.getValue());
		}
	}
}
