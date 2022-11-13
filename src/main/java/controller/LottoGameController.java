package controller;

public class LottoGameController {
    public void run() {
        InputController inputController = new InputController();
        int purchasingMoney = inputController.inputMoney();
        int chanceNumber = RandomNumberCreator.DivideMoneyBy1000(purchasingMoney);
    }
}
