package lotto;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        User user = new User();
        Host host = new Host();
        InputHandler inputHandler = new InputHandler();

        int cash = inputHandler.inputPurchaseAmount();
        int numOfLotto = user.getNumberOfAvailableLotto(cash);

        for (int i = 0; i < numOfLotto; i++) {
            Lotto lotto = host.issueLotto();
            user.buyLotto(lotto);
        }

        user.showWholeLotto();

        List<Integer> winNumbers = inputHandler.inputWinNumbers();
        int bonusNumber = inputHandler.inputBonusNumber();
        host.registerWinningInformation(winNumbers, bonusNumber);
        System.out.println("Application.main");
        host.showWinResult(user);
    }
}
