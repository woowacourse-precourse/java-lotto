package lotto;

import java.util.Map;

public class Manager {
    User user = new User();
    Map<Rank,Integer> winningBoard;

    public void inputAmount() {
        UserInput input = new UserInput();
        int amount  = input.inputAmount();
        user.setAmount(amount);
    }

    public void compareLotto() {
        Compare compareLotto = new Compare();

        for(Lotto lotto : user.getLottos()) {
            compareLotto.compareLotto(lotto);
        }
    }

}
