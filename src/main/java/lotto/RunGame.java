package lotto;

import lotto.model.UserDTO;
import lotto.view.InputPurchase;

public class RunGame {
    InputPurchase input = new InputPurchase();

    public void runGame() {
        UserDTO userDTO;
        try {
        userDTO = input.inputPurchase();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ;
        }
    }
}
