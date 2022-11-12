package lotto;

import lotto.model.GameDTO;
import lotto.model.UserDTO;
import lotto.view.InputManager;
import lotto.view.InputUser;
import lotto.view.Print;

public class RunGame {
    private static InputUser inputUser = new InputUser();
    private static InputManager inputManager = new InputManager();
    private static Print print = new Print();
    private UserDTO userDTO;
    private GameDTO gameDTO;
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
        this.gameDTO = inputManager.makeGameData();
        System.out.println(gameDTO.getWinningNumber().getLotto());
        System.out.println(gameDTO.getBonusNumber());
    }
}
