package lotto;

import lotto.model.UserDTO;
import lotto.view.InputPurchase;

public class RunGame {
    private InputPurchase inputPurchase = new InputPurchase();
    public void runGame() {
        UserDTO userDTO;
        try {
            userDTO = inputPurchase.makeUserData();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ;
        }
    }
}
