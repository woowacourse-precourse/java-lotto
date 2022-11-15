package lotto;

import java.util.List;

import lotto.domain.GenerateNumbers;
import lotto.domain.User;
import lotto.domain.WinConfirmation;

public class Application {
    public static void main(String[] args) {
    	GenerateNumbers generateNumbers = new GenerateNumbers();
    	User user = new User();
    	WinConfirmation confirmation = new WinConfirmation();
    	
    	List<Integer> randomNubmer = generateNumbers.lotto();
    	List<Integer> winningNumber = user.winningNumber();
    	
    	int correctCount = confirmation.correctCount(randomNubmer, winningNumber);
    	
    }
}
