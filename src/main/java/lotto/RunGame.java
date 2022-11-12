package lotto;

import lotto.model.UserDTO;
import lotto.view.InputUser;
import lotto.view.Print;

public class RunGame {
    private static InputUser inputUser = new InputUser();
    private static Print print = new Print();
    private UserDTO userDTO;
    public RunGame() {
        try {
            userSide();
            managerSide();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void userSide() {
            this.userDTO = inputUser.makeUserData();
            print.printGames(this.userDTO);
    }
    private void managerSide() {

    }
}
