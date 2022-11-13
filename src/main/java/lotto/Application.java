package lotto;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
    controller();
    }
    public static void controller() {
        int numberOfGame = Input.budgetInput();
        ArrayList<Object> userNumber = Lotto.randomNumberGenerate(numberOfGame);
        System.out.println(userNumber);
        ArrayList<Integer> winningNumber=Input.winningNumberInput();
        System.out.println(winningNumber);

    }
}
