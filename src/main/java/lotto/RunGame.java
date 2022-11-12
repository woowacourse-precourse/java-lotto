package lotto;

import lotto.model.UserDTO;
import lotto.view.InputPurchase;
import lotto.view.Print;

public class RunGame {
    private InputPurchase inputPurchase = new InputPurchase();
    private Print print = new Print();
    public void runGame() {
        UserDTO userDTO;
        try {
            userDTO = inputPurchase.makeUserData();
            print.printGames(userDTO);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ;
        }
    }
}
