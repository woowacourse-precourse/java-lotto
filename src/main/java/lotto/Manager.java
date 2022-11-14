package lotto;

import java.util.List;
import java.util.Map;

public class Manager {
    private int amount = 0;
    List<Lotto> Lottos;

    Map<Rank,Integer> winningBoard;


    public void inputAmount() {
        UserInput input = new UserInput();
        amount  = input.inputAmount();
    }

    public void compareLotto() {
        Compare compareLotto = new Compare();

        for(Lotto lotto : Lottos) {
            compareLotto.compareLotto(lotto);
        }


    }

}
