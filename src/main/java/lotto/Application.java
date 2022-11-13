package lotto;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
    controller();
    }
    public static void controller() {
        int numberOfGame = Input.budgetInput();
        ArrayList<Object> userNumber = Lotto.randomNumberGenerate(numberOfGame);
        ArrayList<Integer> winningNumber=Input.winningNumberInput();
        int bonusNumber = Input.bonusNumberInput(winningNumber);
        Output.output(numberOfGame, userNumber, winningNumber, bonusNumber);


    }
}
