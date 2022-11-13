package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String amount = Input.inputAmount();
        int quantity = Input.getQuantity(amount);

        List<List<Integer>> purchased = Output.issueLotto(quantity);
        Output.printLotto(quantity, purchased);

        List<Integer> lottery = new ArrayList<>();
        String test = Lotto.inputLotto();
        lottery = Lotto.splitNumbers(test);
        int bonus = Input.inputBonus();

        List<Integer> result = Output.getResult(lottery, bonus, purchased);
        Output.printResult(result);
        Output.getRatio(quantity, result);

    }
}
