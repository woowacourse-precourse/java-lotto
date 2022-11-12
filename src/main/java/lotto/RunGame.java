package lotto;

import lotto.model.UserDTO;
import lotto.view.InputPurchase;

public class RunGame {

    public void runGame() {
        UserDTO userDTO = new UserDTO();
        try {
        new InputPurchase(userDTO);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ;
        }
    }
}
